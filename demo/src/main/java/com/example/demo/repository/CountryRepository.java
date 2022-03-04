package com.example.demo.repository;

import com.example.demo.bean.countryBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<countryBean, Integer> {
    countryBean getByDateAndName(String date, String name);

    List<countryBean> getByName(String name);

    List<countryBean> getByDateOrderByConfirmDesc(String date);
}
