package com.example.demo.repository;

import com.example.demo.bean.VaccinesBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineRepository extends JpaRepository<VaccinesBean, Integer> {
    VaccinesBean findByDateAndName(String date, String name);

    List<VaccinesBean> findByDate(String date);

    List<VaccinesBean> findByNameOrderByDate(String name);
}
