package com.enteprise.movilchallenge.domain.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("title")
    @Expose
    private String name;

    @SerializedName("location_type")
    @Expose
    private String type;

    @SerializedName("woeid")
    @Expose
    private String idWebService;

    @SerializedName("latt_long")
    @Expose
    private String latlong;

    private transient boolean isExpanden;

    public boolean isExpanden() {
        return isExpanden;
    }

    public void setExpanden(boolean expanden) {
        isExpanden = expanden;
    }

    public CitySpecificData getCitySpecificData() {
        return citySpecificData;
    }

    public void setCitySpecificData(CitySpecificData citySpecificData) {
        this.citySpecificData = citySpecificData;
    }

    private CitySpecificData citySpecificData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdWebService() {
        return idWebService;
    }

    public void setIdWebService(String idWebService) {
        this.idWebService = idWebService;
    }

    public String getLatlong() {
        return latlong;
    }

    public void setLatlong(String latlong) {
        this.latlong = latlong;
    }
}
