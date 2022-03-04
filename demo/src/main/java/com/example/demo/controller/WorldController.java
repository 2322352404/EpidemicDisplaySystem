package com.example.demo.controller;

import com.example.demo.bean.VaccinesBean;
import com.example.demo.bean.countryBean;
import com.example.demo.repository.CustomRepository;
import com.example.demo.service.CountryService;
import com.example.demo.service.ProvinceService;
import com.example.demo.service.VaccineService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

@Controller
public class WorldController {

    @Autowired
    ProvinceService provinceService;
    @Autowired
    CountryService countryService;
    @Autowired
    VaccineService vaccineService;
    @RequestMapping("/")
    public String show(){
        return "world";
    }
    @RequestMapping("/api/getworlddata")
    @ResponseBody
    public String getWorlddata() throws ParseException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        CustomRepository customRepository = new CustomRepository();
        String d = date.format(formatter);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(d));
        cal.add(5, -1);
        String yesterday = sdf.format(cal.getTime());
        Gson gson = new Gson();
        List<countryBean> countryBeanList = countryService.searchALLCountryByDate(date.format(formatter));
        if (countryBeanList.size() != 0) {
            String world = gson.toJson(countryBeanList);
            return world;
        } else {

            List<countryBean> countryBeanList1 = countryService.searchALLCountryByDate(yesterday);
            if (countryBeanList1.size() != 0) {
                String world = gson.toJson(countryBeanList1);
                return world;
            } else {
                return "error";
            }
        }
    }
    @RequestMapping("/api/countrysum")
    @ResponseBody
    public String getsumdata() throws SQLException, ClassNotFoundException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        CustomRepository customRepository = new CustomRepository();
        List<countryBean> list = customRepository.getcountrysum();
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @RequestMapping("/api/getvaccinesdata")
    @ResponseBody
    public String getVaccinesdata() throws ParseException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        CustomRepository customRepository = new CustomRepository();
        String d = date.format(formatter);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(d));
        cal.add(5, -1);
        String yesterday = sdf.format(cal.getTime());
        Gson gson = new Gson();
        List<VaccinesBean> vaccinesBeanList = vaccineService.getVaccineDataByDate(d);
        if (vaccinesBeanList.size() != 0) {
            String vaccine = gson.toJson(vaccinesBeanList);
            return vaccine;
        } else {
            List<VaccinesBean> vaccinesBeanList1 = vaccineService.getVaccineDataByDate(yesterday);
            if (vaccinesBeanList1.size() != 0) {
                return gson.toJson(vaccinesBeanList1);
            } else {
                return "error";
            }
        }
    }
}
