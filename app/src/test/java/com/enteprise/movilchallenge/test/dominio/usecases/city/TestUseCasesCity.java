package com.enteprise.movilchallenge.test.dominio.usecases.city;

import com.enteprise.movilchallenge.data.datasources.remote.CityDataSourceRemoteImpl;
import com.enteprise.movilchallenge.data.repositories.CityRepositoryImpl;
import com.enteprise.movilchallenge.domain.models.City;
import com.enteprise.movilchallenge.domain.models.CitySpecificData;
import com.enteprise.movilchallenge.domain.repositories.CityRepository;
import com.enteprise.movilchallenge.domain.usecases.city.SearchCityImp;
import com.enteprise.movilchallenge.domain.usecases.city.SearchCityUseCase;
import com.enteprise.movilchallenge.domain.usecases.city.SearchWeatherByCityImp;
import com.enteprise.movilchallenge.domain.usecases.city.SearchWeatherByCityUseCase;

import org.junit.Test;

import static org.junit.Assert.*;

import org.mockito.*;

import java.util.List;

public class TestUseCasesCity {

    @Mock
    CityDataSourceRemoteImpl cityRepositoryRemote;

    @Test
    public void validateSearchCityUseCase() {
        CityRepository cityRepository = new CityRepositoryImpl(new CityDataSourceRemoteImpl());
        SearchCityUseCase obj = new SearchCityImp(cityRepository);
        List<City> citys = obj.searchCity("Miami");
        System.out.println(citys.size());
        assertEquals(citys.size(), 1);
    }

    @Test
    public void validateSearchCityUseCase2() {
        CityRepository cityRepository = new CityRepositoryImpl(new CityDataSourceRemoteImpl());
        SearchWeatherByCityUseCase obj = new SearchWeatherByCityImp(cityRepository);
        CitySpecificData data = obj.searchWeatherByCity("2450022");
        System.out.println(data.getTimezone());
        assertEquals(data.getTimezone(), "America/New_York");

    }
}
