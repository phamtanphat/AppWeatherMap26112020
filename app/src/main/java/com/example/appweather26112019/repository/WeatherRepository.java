package com.example.appweather26112019.repository;

import com.example.appweather26112019.api.ApiService;
import com.example.appweather26112019.api.NetWorkModule;

public class WeatherRepository {
    private ApiService apiService;
    private static WeatherRepository repository;

    private WeatherRepository(){
        apiService = NetWorkModule.getInStance();
    }

    public static WeatherRepository getInstance(){
        if (repository == null){
            repository = new WeatherRepository();
        }
        return repository;
    }

    public

}
