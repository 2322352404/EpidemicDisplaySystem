package com.example.demo.serviceImpl;

import com.example.demo.bean.countryBean;
import com.example.demo.repository.CountryRepository;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository CounRepository;

    @Override
    public countryBean searchCountryData(String date, String name) {
        countryBean country = CounRepository.getByDateAndName(date, name);
        return country;
    }

    @Override
    public List<countryBean> searchCountryData(String name) {
        List<countryBean> countryBeanList = (List<countryBean>) CounRepository.getByName(name);
        return countryBeanList;
    }

    @Override
    public List<countryBean> searchALLCountryByDate(String date) {
        List<countryBean> countryBeanList = CounRepository.getByDateOrderByConfirmDesc(date);
        return countryBeanList;
    }
}
