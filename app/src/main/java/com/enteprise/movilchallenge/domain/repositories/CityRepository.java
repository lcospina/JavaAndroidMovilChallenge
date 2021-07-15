package com.enteprise.movilchallenge.domain.repositories;


import com.enteprise.movilchallenge.domain.models.CitySpecificData;

import java.util.List;

public interface CityRepository {
    List<com.enteprise.movilchallenge.domain.models.City> searchCity(String nameCity);
    CitySpecificData searchWeatherByCity(String codeCity);
}
