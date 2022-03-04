package com.example.demo.service;

import com.example.demo.bean.ProvinceBean;

import java.util.List;

public interface ProvinceService {
    ProvinceBean searchProvinceData(String date, String name);

    List<ProvinceBean> searchProvinceData(String name);

    List<ProvinceBean> searchProvinceDataBycountry(String date, String country);
}
