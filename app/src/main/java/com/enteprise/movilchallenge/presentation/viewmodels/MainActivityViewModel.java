package com.enteprise.movilchallenge.presentation.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.enteprise.movilchallenge.data.containers.MyApplication;
import com.enteprise.movilchallenge.data.datasources.remote.CityDataSourceRemoteImpl;
import com.enteprise.movilchallenge.data.repositories.CityRepositoryImpl;
import com.enteprise.movilchallenge.domain.models.City;
import com.enteprise.movilchallenge.domain.repositories.CityRepository;
import com.enteprise.movilchallenge.domain.usecases.city.SearchCityImp;
import com.enteprise.movilchallenge.domain.usecases.city.SearchCityUseCase;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<List<City>> citysLiveData;
    private SearchCityUseCase searchCityUseCase;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        citysLiveData = new MutableLiveData<>();
        searchCityUseCase = new SearchCityImp(((MyApplication) getApplication()).appContainer.cityRepository);
    }

    public void searchCity(String city) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                citysLiveData.postValue(searchCityUseCase.searchCity(city));
            }
        }).start();
    }

    public LiveData<List<City>> getCitysLiveData() {
        return citysLiveData;
    }
}
