package com.enteprise.movilchallenge.domain.usecases.city;


import com.enteprise.movilchallenge.domain.models.CitySpecificData;

public interface SearchWeatherByCityUseCase {
    CitySpecificData searchWeatherByCity(String codeCity);
}
