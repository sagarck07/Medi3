package com.example.medi3.Models;

public class RequestList {

    String patient, blood, location, aditional;

    public RequestList(String patient, String blood, String location, String aditional){
        this.patient = patient;
        this.blood = blood;
        this.location = location;
        this.aditional = aditional;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAditional() {
        return aditional;
    }

    public void setAditional(String aditional) {
        this.aditional = aditional;
    }
}
