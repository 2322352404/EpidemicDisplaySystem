package com.example.demo.service;

import com.example.demo.bean.countryBean;

import java.util.List;

public interface CountryService {
    countryBean searchCountryData(String date, String name);

    List<countryBean> searchCountryData(String name);

    List<countryBean> searchALLCountryByDate(String date);
}
