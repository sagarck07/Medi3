package com.example.medi3.Models;

public class LatestReqModel {
    String NameReq, BloodGroupReq, MobileReq, LocationReq;

    public LatestReqModel(String nameReq, String bloodGroupReq, String mobileReq, String locationReq) {
        NameReq = nameReq;
        BloodGroupReq = bloodGroupReq;
        MobileReq = mobileReq;
        LocationReq = locationReq;
    }

    public String getNameReq() {
        return NameReq;
    }

    public void setNameReq(String nameReq) {
        NameReq = nameReq;
    }

    public String getBloodGroupReq() {
        return BloodGroupReq;
    }

    public void setBloodGroupReq(String bloodGroupReq) {
        BloodGroupReq = bloodGroupReq;
    }

    public String getMobileReq() {
        return MobileReq;
    }

    public void setMobileReq(String mobileReq) {
        MobileReq = mobileReq;
    }

    public String getLocationReq() {
        return LocationReq;
    }

    public void setLocationReq(String locationReq) {
        LocationReq = locationReq;
    }
}
