package com.example.demo.serviceImpl;

import com.example.demo.bean.ProvinceBean;
import com.example.demo.repository.ProvinceRepository;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public ProvinceBean searchProvinceData(String date, String name) {
        ProvinceBean provinceBean = provinceRepository.findByDateAndName(date, name);
        return provinceBean;
    }

    @Override
    public List<ProvinceBean> searchProvinceData(String name) {
        List<ProvinceBean> provinceBeanList = provinceRepository.findByName(name);
        return provinceBeanList;
    }

    @Override
    public List<ProvinceBean> searchProvinceDataBycountry(String date, String country) {
        List<ProvinceBean> provinceBeanList = provinceRepository.findByDateAndCountry(date, country);
        return provinceBeanList;
    }
}
