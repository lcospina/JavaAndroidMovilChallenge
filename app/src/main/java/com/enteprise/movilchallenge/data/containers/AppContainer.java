package com.enteprise.movilchallenge.data.containers;

import com.enteprise.movilchallenge.data.datasources.remote.CityDataSourceRemoteImpl;
import com.enteprise.movilchallenge.data.repositories.CityRepositoryImpl;
import com.enteprise.movilchallenge.domain.repositories.CityRepository;

public class AppContainer {
    public  CityRepository cityRepository = new CityRepositoryImpl(new CityDataSourceRemoteImpl());
}
