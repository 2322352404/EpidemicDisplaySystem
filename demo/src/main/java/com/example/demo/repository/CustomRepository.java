package com.example.demo.repository;

import com.example.demo.bean.countryBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomRepository {
    public List<countryBean> getcountrysum() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/epidemic", "root", "");
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("SELECT id,date,sum(confirm),sum(dead),sum(heal) FROM `country_cov` group by `date`");
        List<countryBean> list = new ArrayList<>();
        while (res.next()) {
            int id = res.getInt("id");
            String date = res.getString("date");
            int confirm = res.getInt("sum(confirm)");
            int dead = res.getInt("sum(dead)");
            int heal = res.getInt("sum(heal)");
            countryBean world = new countryBean();
            world.setId(id);
            world.setDate(date);
            world.setName("世界");
            world.setConfirm(confirm);
            world.setDead(dead);
            world.setHeal(heal);
            list.add(world);
        }
        return list;
    }
    public List<String> searchcountry(String keyword) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/epidemic", "root", "");
        PreparedStatement ps;
        ps=con.prepareStatement("SELECT distinct `name` FROM `country_cov` WHERE `name` like ?");
        ps.setString(1,"%"+keyword+"%");
        ResultSet res = ps.executeQuery();
        List<String> list=new ArrayList<>();
        while(res.next()){
            String name=res.getString("name");
            list.add(name);
        }
        return list;
    }
    public List<String> searchprovince(String keyword) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/epidemic", "root", "");
        PreparedStatement ps;
        ps=con.prepareStatement("SELECT distinct `name` FROM `province_data` WHERE `name` like ?");
        ps.setString(1,"%"+keyword+"%");
        ResultSet res = ps.executeQuery();
        List<String> list=new ArrayList<>();
        while(res.next()){
            String name=res.getString("name");
            list.add(name);
        }
        return list;
    }
}
