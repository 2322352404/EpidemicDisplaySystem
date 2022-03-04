package com.example.demo.bean;

import javax.persistence.*;

@Entity
@Table(name = "province_data")
public class ProvinceBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date")
    private String date;
    @Column(name = "country")
    private String country;
    @Column(name = "name")
    private String name;
    @Column(name = "confirm")
    private int confirm;
    @Column(name = "dead")
    private int dead;
    @Column(name = "heal")
    private int heal;

    public void setId(int id) {
        this.id = id;
    }

    public void setConfirm(int confirm) {
        this.confirm = confirm;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public int getConfirm() {
        return confirm;
    }

    public int getDead() {
        return dead;
    }

    public int getHeal() {
        return heal;
    }
}
