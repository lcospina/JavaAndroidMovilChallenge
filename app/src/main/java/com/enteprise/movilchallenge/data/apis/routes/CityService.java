package com.enteprise.movilchallenge.data.apis.routes;

import com.enteprise.movilchallenge.domain.models.City;
import com.enteprise.movilchallenge.domain.models.CitySpecificData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CityService {

    @GET("/api/location/search/")
    Call<List<City>> searchCitys(
            @Query("query") String txtCity
    );


    @GET("/api/location/{query}/")
    Call<CitySpecificData> getWeatherByCity(
            @Path("query") String woeId
    );

}
