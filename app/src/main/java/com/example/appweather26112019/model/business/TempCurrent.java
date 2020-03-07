package com.example.appweather26112019.model.business;

import java.util.List;

import com.example.appweather26112019.model.response.Clouds;
import com.example.appweather26112019.model.response.Main;
import com.example.appweather26112019.model.response.Sys;
import com.example.appweather26112019.model.response.Weather;
import com.example.appweather26112019.model.response.Wind;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TempCurrent {

    private List<Weather> weather = null;

    private String message = null;

    private Main main;

    private Wind wind;

    private Sys sys;

    private String name;

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}