package com.example.medi3.Models;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterDoner {
    String mobileno, name, blood_group, state, city,age;

    public RegisterDoner(String name, String blood_group, String state, String city, String age, String mobileno) {
        this.name = name;
        this.blood_group = blood_group;
        this.state = state;
        this.city = city;
        this.age = age;
        this.mobileno = mobileno;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
