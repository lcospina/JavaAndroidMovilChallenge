package com.enteprise.movilchallenge.domain.usecases.city;

import com.enteprise.movilchallenge.domain.models.CitySpecificData;
import com.enteprise.movilchallenge.domain.repositories.CityRepository;

public class SearchWeatherByCityImp implements SearchWeatherByCityUseCase {

    private CityRepository cityRepository;

    public SearchWeatherByCityImp(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public CitySpecificData searchWeatherByCity(String codeCity) {
        return cityRepository.searchWeatherByCity(codeCity);
    }
}
