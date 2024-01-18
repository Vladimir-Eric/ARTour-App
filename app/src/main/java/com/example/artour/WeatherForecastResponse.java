package com.example.artour;

import com.example.artour.WeatherResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherForecastResponse {

    @SerializedName("list")
    private List<WeatherResponse> weatherList;

    public List<WeatherResponse> getWeatherList() {
        return weatherList;
    }
}