package com.example.demo.controller;

import com.example.demo.bean.ProvinceBean;
import com.example.demo.service.ProvinceService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

@Controller
public class ProvinceController{
    @Autowired
    ProvinceService provinceService;
    @RequestMapping(value = "/getprovincedata", method = RequestMethod.GET)
    public String getProvincedata(@RequestParam("name") String name, Model model){
        /*String d=date.format(formatter);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        cal.setTime(sdf.parse(d));
        cal.add(5,-1);
        String yesterday=sdf.format(cal.getTime());*/
        Gson gson = new Gson();
        List<ProvinceBean> provinceBeanList = provinceService.searchProvinceData(name);
        if (provinceBeanList.size() != 0) {
            model.addAttribute("province", name);
            model.addAttribute("data", gson.toJson(provinceBeanList));
            return "province";
        } else {
            return "error";
        }
    }
}
