package com.example.demo.bean;

import javax.persistence.*;

@Entity
@Table(name="vaccines_data_country")
public class VaccinesBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "name")
    private String name;

    @Column(name = "vaccinednum")
    private int vaccinednum;

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getVaccinednum() {
        return vaccinednum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setVaccinednum(int vaccinednum) {
        this.vaccinednum = vaccinednum;
    }

    public void setId(int id) {
        this.id = id;
    }
}
