package com.example.medi3.Models;

public class DonorRequestStatusModel {
    String NameDonorStatus, BloodGroupDonorStatus, MobileDonorStatus, LocationDonorStatus;

    public DonorRequestStatusModel(String nameDonorStatus, String bloodGroupDonorStatus, String mobileDonorStatus, String locationDonorStatus) {
        NameDonorStatus = nameDonorStatus;
        BloodGroupDonorStatus = bloodGroupDonorStatus;
        MobileDonorStatus = mobileDonorStatus;
        LocationDonorStatus = locationDonorStatus;
    }

    public String getNameDonorStatus() {
        return NameDonorStatus;
    }

    public void setNameDonorStatus(String nameDonorStatus) {
        NameDonorStatus = nameDonorStatus;
    }

    public String getBloodGroupDonorStatus() {
        return BloodGroupDonorStatus;
    }

    public void setBloodGroupDonorStatus(String bloodGroupDonorStatus) {
        BloodGroupDonorStatus = bloodGroupDonorStatus;
    }

    public String getMobileDonorStatus() {
        return MobileDonorStatus;
    }

    public void setMobileDonorStatus(String mobileDonorStatus) {
        MobileDonorStatus = mobileDonorStatus;
    }

    public String getLocationDonorStatus() {
        return LocationDonorStatus;
    }

    public void setLocationDonorStatus(String locationDonorStatus) {
        LocationDonorStatus = locationDonorStatus;
    }
}
