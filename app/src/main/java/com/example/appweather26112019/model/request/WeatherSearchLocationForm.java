package com.example.appweather26112019.model.request;

public class WeatherSearchLocationForm {
    private String q;
    private String mode;
    private String units;
    private String appid;

    public WeatherSearchLocationForm(String q, String mode, String units, String appid) {
        this.q = q;
        this.mode = mode;
        this.units = units;
        this.appid = appid;
    }

    public WeatherSearchLocationForm() {
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
