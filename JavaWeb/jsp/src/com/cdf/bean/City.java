package com.cdf.bean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-11
 * Time: 21:59
 */
public class City {
    private String cityName;
    private String addR;

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", addR='" + addR + '\'' +
                '}';
    }

    public City(String cityName, String addR) {
        this.cityName = cityName;
        this.addR = addR;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddR() {
        return addR;
    }

    public void setAddR(String addR) {
        this.addR = addR;
    }
}
