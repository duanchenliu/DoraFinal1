package com.example.user.dorafinal1;

import java.io.Serializable;

public class HospitalRecord implements Serializable {

    public String address;

    public String city;

    public String county;

    public String condition;

    public String hospitalName;

    public double lng;

    public double lat;

    public String phoneNumber;

    public String zipcode;

    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty(){
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCondition(){
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }


    public double getLng() {
        return lng;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
