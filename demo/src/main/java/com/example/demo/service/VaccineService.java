package com.example.demo.service;

import com.example.demo.bean.VaccinesBean;

import java.util.List;

public interface VaccineService {
    public VaccinesBean getVaccineData(String date, String name);

    public List<VaccinesBean> getVaccineDataByDate(String date);

    public List<VaccinesBean> getVaccineDataByname(String name);
}
