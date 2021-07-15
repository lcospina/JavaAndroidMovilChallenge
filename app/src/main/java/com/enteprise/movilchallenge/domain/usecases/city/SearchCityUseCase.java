package com.enteprise.movilchallenge.domain.usecases.city;


import com.enteprise.movilchallenge.domain.models.City;

import java.util.List;

public interface SearchCityUseCase {
    List<City> searchCity(String nameCity);
}
