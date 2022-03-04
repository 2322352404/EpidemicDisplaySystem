package com.example.demo.bean;

import javax.persistence.*;

@Entity
@Table(name = "country_cov")
public class countryBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String date;
    private String name;
    private int confirm;
    private int dead;
    private int heal;


    public int getConfirm() {
        return confirm;
    }

    public int getDead() {
        return dead;
    }

    public int getHeal() {
        return heal;
    }

    public void setConfirm(int confirm) {
        this.confirm = confirm;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void output() {
        System.out.println("date:" + this.date + " name:" + this.name + " confirm:" + this.confirm + " dead:" + this.dead + " heal:" + this.heal);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
