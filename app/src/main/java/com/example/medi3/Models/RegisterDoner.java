package com.example.medi3.Models;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterDoner {
    String Name, BloodGroup, State, City,Age;

    public RegisterDoner(String Name,String BloodGroup,String State,String City,String Age ) {
        this.Name = Name;
        this.BloodGroup = BloodGroup;
        this.State = State;
        this.City = City;
        this.Age = Age;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }
}
