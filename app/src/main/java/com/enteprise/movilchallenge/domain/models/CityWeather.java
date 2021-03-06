package com.enteprise.movilchallenge.domain.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityWeather {

    @SerializedName("weather_state_name")
    @Expose
    private String weather_state_name;

    @SerializedName("weather_state_abbr")
    @Expose
    private String weather_state_abbr;

    @SerializedName("applicable_date")
    @Expose
    private String applicable_date;

    @SerializedName("min_temp")
    @Expose
    private String min_temp;

    @SerializedName("max_temp")
    @Expose
    private String max_temp;

    @SerializedName("the_temp")
    @Expose
    private String the_temp;

    @SerializedName("wind_speed")
    @Expose
    private String wind_speed;

    @SerializedName("wind_direction")
    @Expose
    private String wind_direction;

    @SerializedName("air_pressure")
    @Expose
    private String air_pressure;

    @SerializedName("humidity")
    @Expose
    private String humidity;


    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    public String getWeather_state_abbr() {
        return weather_state_abbr;
    }

    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    public String getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public String getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(String min_temp) {
        this.min_temp = min_temp;
    }

    public String getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(String max_temp) {
        this.max_temp = max_temp;
    }

    public String getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(String the_temp) {
        this.the_temp = the_temp;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(String air_pressure) {
        this.air_pressure = air_pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }


}
