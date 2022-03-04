package com.example.demo.serviceImpl;

import com.example.demo.bean.VaccinesBean;
import com.example.demo.repository.VaccineRepository;
import com.example.demo.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    public VaccinesBean getVaccineData(String date, String name) {
        return vaccineRepository.findByDateAndName(date, name);
    }

    @Override
    public List<VaccinesBean> getVaccineDataByDate(String date) {
        List<VaccinesBean> vaccinesBeanList = vaccineRepository.findByDate(date);
        return vaccinesBeanList;
    }

    @Override
    public List<VaccinesBean> getVaccineDataByname(String name) {
        List<VaccinesBean> vaccinesBeanList = vaccineRepository.findByNameOrderByDate(name);
        return vaccinesBeanList;
    }
}
