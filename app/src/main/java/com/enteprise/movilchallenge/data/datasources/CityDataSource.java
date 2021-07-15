package com.enteprise.movilchallenge.data.datasources;

import com.enteprise.movilchallenge.domain.models.City;
import com.enteprise.movilchallenge.domain.models.CitySpecificData;

import java.util.List;

public interface CityDataSource {

    List<City> searchCity(String nameCity);

    CitySpecificData searchWeatherByCity(String codeCity);



}
