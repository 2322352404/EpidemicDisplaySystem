package com.example.demo.controller;

import com.example.demo.bean.ProvinceBean;
import com.example.demo.bean.VaccinesBean;
import com.example.demo.bean.countryBean;
import com.example.demo.service.CountryService;
import com.example.demo.service.ProvinceService;
import com.example.demo.service.VaccineService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

@Controller
public class CountryController {

    @Autowired
    CountryService countryService;
    @Autowired
    VaccineService vaccineService;
    @Autowired
    ProvinceService provinceService;
    @RequestMapping(value = "/getcountrydata", method = RequestMethod.GET)
    public String getContrydata(@RequestParam("name") String name, Model model) throws ParseException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String d = date.format(formatter);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(d));
        cal.add(5, -1);
        String yesterday = sdf.format(cal.getTime());
        Gson gson = new Gson();
        List<ProvinceBean> provinceBeanList = provinceService.searchProvinceDataBycountry(d, name);
        List<countryBean> countryBeanList = countryService.searchCountryData(name);
        List<VaccinesBean> vaccinesBeanList = vaccineService.getVaccineDataByname(name);
        if (provinceBeanList.size() != 0) {
            String provinces = gson.toJson(provinceBeanList);
            model.addAttribute("data", provinces);
            model.addAttribute("country", name);
            model.addAttribute("contryseries", gson.toJson(countryBeanList));
            model.addAttribute("vaccines", gson.toJson(vaccinesBeanList));
            //return "countrytest";
            return "country";
        } else {
            List<ProvinceBean> provinceBeanList1 = provinceService.searchProvinceDataBycountry(yesterday, name);
            if (provinceBeanList1.size() != 0) {
                model.addAttribute("data", gson.toJson(provinceBeanList1));
                model.addAttribute("country", name);
                model.addAttribute("contryseries", gson.toJson(countryBeanList));
                model.addAttribute("vaccines", gson.toJson(vaccinesBeanList));
                //return "countrytest";
                return "country";
            } else if (countryBeanList.size() != 0) {
                model.addAttribute("country", name);
                model.addAttribute("contryseries", gson.toJson(countryBeanList));
                model.addAttribute("vaccines", gson.toJson(vaccinesBeanList));
                return "country";
            } else {
                return "error";
            }
        }
    }
}
