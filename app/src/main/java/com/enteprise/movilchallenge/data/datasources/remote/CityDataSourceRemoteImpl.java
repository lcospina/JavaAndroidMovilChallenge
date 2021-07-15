package com.enteprise.movilchallenge.data.datasources.remote;

import com.enteprise.movilchallenge.data.apis.routes.CityService;
import com.enteprise.movilchallenge.data.datasources.CityDataSource;

import com.enteprise.movilchallenge.data.apis.constants.Constants;
import com.enteprise.movilchallenge.data.datasources.DataSourceException;
import com.enteprise.movilchallenge.domain.models.City;
import com.enteprise.movilchallenge.domain.models.CitySpecificData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class CityDataSourceRemoteImpl implements CityDataSource, DataSourceException {

    CityService citySearchService;

    public CityDataSourceRemoteImpl() {

        //HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //interceptor.level(HttpLoggingInterceptor.Level.BODY);
        //OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        citySearchService = new retrofit2.Retrofit.Builder()
                .baseUrl(Constants.CITY_SEARCH_SERVICE_BASE_URL)
                //.client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CityService.class);
    }

    @Override
    public List<City> searchCity(String nameCity) {

        List<City> data = null;
        try {
            data = citySearchService.searchCitys(nameCity).execute().body();

        } catch (IOException e) {
            noConnection();
        }
        if (data == null) {
            data = new ArrayList<City>();
        }

        return data;
    }

    @Override
    public CitySpecificData searchWeatherByCity(String codeCity) {

        CitySpecificData data = null;
        try {
            data = citySearchService.getWeatherByCity(codeCity).execute().body();
        } catch (IOException e) {
            noConnection();
        }

        return data;

    }

    @Override
    public void noConnection() {
        System.out.println("No connection.");
    }
}
