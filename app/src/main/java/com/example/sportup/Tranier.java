package com.example.sportup;

import java.io.Serializable;

public class Tranier implements Serializable {
    String name , city, phone_num,password,id_Trainer;

    public Tranier(String name, String city, String phone_num, String password,String id_Trainer) {
        this.id_Trainer=id_Trainer;
        this.name = name;
        this.city = city;
        this.phone_num = phone_num;
        this.password = password;
    }
    public Tranier(String name, String city, String phone_num, String password) {
        this.name = name;
        this.city = city;
        this.phone_num = phone_num;
        this.password = password;
    }
    public Tranier(String name, String password , String phone_num) {
        this.name = name;
        this.phone_num = phone_num;
        this.password = password;
    }
    public String getId() {
        return id_Trainer;
    }

    public void setId(String id_Trainer) {
        this.id_Trainer = id_Trainer;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
