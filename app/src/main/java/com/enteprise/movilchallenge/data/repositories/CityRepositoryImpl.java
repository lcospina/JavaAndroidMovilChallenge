package com.enteprise.movilchallenge.data.repositories;

import com.enteprise.movilchallenge.data.datasources.CityDataSource;
import com.enteprise.movilchallenge.data.datasources.remote.CityDataSourceRemoteImpl;
import com.enteprise.movilchallenge.domain.models.City;
import com.enteprise.movilchallenge.domain.models.CitySpecificData;
import com.enteprise.movilchallenge.domain.repositories.CityRepository;

import java.util.List;



public class CityRepositoryImpl implements CityRepository {

    CityDataSource cityDataSource;

    public CityRepositoryImpl(CityDataSource cityDataSource) {
        this.cityDataSource = cityDataSource;
    }

    @Override
    public List<City> searchCity(String nameCity) {
        return cityDataSource.searchCity(nameCity);
    }

    @Override
    public CitySpecificData searchWeatherByCity(String codeCity) {
        return cityDataSource.searchWeatherByCity(codeCity);
    }

}
