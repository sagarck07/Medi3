package com.example.medi3.Models;

public class RequestPatient {

    String mobileno, number_of_units, name, bloodgroup, state, city, additional_info, transportprovide;

    public RequestPatient(String mobileno, String number_of_units, String name, String bloodgroup, String state, String city, String additional_info, String transportprovide) {
        this.mobileno = mobileno;
        this.number_of_units = number_of_units;
        this.name = name;
        this.bloodgroup = bloodgroup;
        this.state = state;
        this.city = city;
        this.additional_info = additional_info;
        this.transportprovide = transportprovide;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getNumber_of_units() {
        return number_of_units;
    }

    public void setNumber_of_units(String number_of_units) {
        this.number_of_units = number_of_units;
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

    public String getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }

    public String getTransportprovide() {
        return transportprovide;
    }

    public void setTransportprovide(String transportprovide) {
        this.transportprovide = transportprovide;
    }
}
