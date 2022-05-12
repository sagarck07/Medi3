package com.example.medi3.Models;

public class BtnDonateModel {
    String btn_Donate_patient, btn_Donate_blood, btn_Donate_location, btn_Donate_aditional;


    public BtnDonateModel(String btn_Donate_patient, String btn_Donate_blood, String btn_Donate_location, String btn_Donate_aditional) {
        this.btn_Donate_patient = btn_Donate_patient;
        this.btn_Donate_blood = btn_Donate_blood;
        this.btn_Donate_location = btn_Donate_location;
        this.btn_Donate_aditional = btn_Donate_aditional;
    }

    public String getBtn_Donate_patient() {
        return btn_Donate_patient;
    }

    public void setBtn_Donate_patient(String btn_Donate_patient) {
        this.btn_Donate_patient = btn_Donate_patient;
    }

    public String getBtn_Donate_blood() {
        return btn_Donate_blood;
    }

    public void setBtn_Donate_blood(String btn_Donate_blood) {
        this.btn_Donate_blood = btn_Donate_blood;
    }

    public String getBtn_Donate_location() {
        return btn_Donate_location;
    }

    public void setBtn_Donate_location(String btn_Donate_location) {
        this.btn_Donate_location = btn_Donate_location;
    }

    public String getBtn_Donate_aditional() {
        return btn_Donate_aditional;
    }

    public void setBtn_Donate_aditional(String btn_Donate_aditional) {
        this.btn_Donate_aditional = btn_Donate_aditional;
    }
}
