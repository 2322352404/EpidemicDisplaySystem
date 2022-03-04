package com.example.demo.repository;

import com.example.demo.bean.ProvinceBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<ProvinceBean, Integer> {
    ProvinceBean findByDateAndName(String name, String date);

    List<ProvinceBean> findByName(String name);

    List<ProvinceBean> findByDateAndCountry(String date, String country);
}
