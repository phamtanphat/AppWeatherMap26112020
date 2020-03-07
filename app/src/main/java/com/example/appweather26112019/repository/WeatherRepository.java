package com.example.appweather26112019.repository;

import com.example.appweather26112019.api.ApiService;
import com.example.appweather26112019.api.NetWorkModule;
import com.example.appweather26112019.model.business.TempCurrent;
import com.example.appweather26112019.model.request.WeatherSearchLocationForm;

import io.reactivex.Observable;

public class WeatherRepository {
    private ApiService apiService;
    private static WeatherRepository repository;

    private WeatherRepository() {
        apiService = NetWorkModule.getInStance();
    }

    public static WeatherRepository getInstance() {
        if (repository == null) {
            repository = new WeatherRepository();
        }
        return repository;
    }

    public Observable<TempCurrent> getTempAtLocation(WeatherSearchLocationForm weatherSearchLocationForm) {
        return apiService.getTempAtLocation(
                weatherSearchLocationForm.getQ(),
                weatherSearchLocationForm.getUnits(),
                weatherSearchLocationForm.getAppid());
    }

}
