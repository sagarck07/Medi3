package com.example.medi3.Models;

public class LatestReqModel {
    String name, bloodgroup, state, city, mobileno;

    public LatestReqModel(String name, String bloodgroup, String state, String city, String mobileno) {
        this.name = name;
        this.bloodgroup = bloodgroup;
        this.state = state;
        this.city = city;
        this.mobileno = mobileno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
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

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}
