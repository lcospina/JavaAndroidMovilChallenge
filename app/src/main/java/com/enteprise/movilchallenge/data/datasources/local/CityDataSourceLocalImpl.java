package com.enteprise.movilchallenge.data.datasources.local;

import com.enteprise.movilchallenge.data.datasources.CityDataSource;
import com.enteprise.movilchallenge.data.datasources.DataSourceException;
import com.enteprise.movilchallenge.domain.models.City;
import com.enteprise.movilchallenge.domain.models.CitySpecificData;

import java.util.List;

import javax.sql.DataSource;

public class CityDataSourceLocalImpl implements CityDataSource, DataSourceException {
    @Override
    public List<City> searchCity(String nameCity) {
        //CONSULTA A ROOM DATABASE
        return null;
    }

    @Override
    public CitySpecificData searchWeatherByCity(String codeCity) {
        //CONSULTA A ROOM DATABASE
        return null;
    }

    @Override
    public void noConnection() {

    }
}
