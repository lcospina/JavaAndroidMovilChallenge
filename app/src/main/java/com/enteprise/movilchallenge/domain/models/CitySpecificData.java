package com.enteprise.movilchallenge.domain.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CitySpecificData {

    @SerializedName("consolidated_weather")
    @Expose
    private List<CityWeather> consolidated_weather;

    @SerializedName("timezone")
    @Expose
    private String timezone;

    public List<CityWeather> getConsolidated_weather() {
        return consolidated_weather;
    }

    public void setConsolidated_weather(List<CityWeather> consolidated_weather) {
        this.consolidated_weather = consolidated_weather;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
