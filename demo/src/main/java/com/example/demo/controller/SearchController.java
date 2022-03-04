package com.example.demo.controller;

import com.example.demo.bean.ProvinceBean;
import com.example.demo.bean.countryBean;
import com.example.demo.repository.CustomRepository;
import com.example.demo.service.CountryService;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    CountryService countryService;
    @Autowired
    ProvinceService provinceService;

    CustomRepository customRepository=new CustomRepository();

    /*@RequestMapping(value = "/search")
    public String search(String keyword, RedirectAttributes attr) {
        List<countryBean> countryBeanList = countryService.searchCountryData(keyword);
        if (countryBeanList.size() != 0) {
            attr.addAttribute("name", keyword);
            return "redirect:/getcountrydata";
        } else {
            List<ProvinceBean> provinceBeanList = provinceService.searchProvinceData(keyword);
            if (provinceBeanList.size() != 0) {
                attr.addAttribute("name", keyword);
                return "redirect:/getprovincedata";
            } else {
                return "error";
            }
        }
    }*/
    @RequestMapping("/search")
    public String search(String keyword, Model model) throws SQLException, ClassNotFoundException {
        List<String> country=customRepository.searchcountry(keyword);
        List<String> province=customRepository.searchprovince(keyword);
        model.addAttribute("keyword",keyword);
        if(country.size()!=0){
            model.addAttribute("country",country);
        }
        else{
            model.addAttribute("province",province);
        }
        return "searchresult";

    }
}
