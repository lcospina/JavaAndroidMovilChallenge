package com.enteprise.movilchallenge.domain.usecases.city;


import com.enteprise.movilchallenge.domain.models.City;
import com.enteprise.movilchallenge.domain.repositories.CityRepository;

import java.util.List;

public class SearchCityImp implements SearchCityUseCase {

    private CityRepository cityRepository;

    public SearchCityImp(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> searchCity(String nameCity) {
        return cityRepository.searchCity(nameCity);
    }
}
