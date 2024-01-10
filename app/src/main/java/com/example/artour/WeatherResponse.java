package com.example.artour;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {

    @SerializedName("main")
    private MainInfo mainInfo;

    @SerializedName("weather")
    private WeatherInfo[] weatherInfo;

    @SerializedName("wind")
    private WindInfo windInfo;

    public WeatherResponse() {
    }

    public MainInfo getMainInfo() {
        return mainInfo;
    }

    public WeatherInfo[] getWeatherInfo() {
        return weatherInfo;
    }

    public WindInfo getWindInfo() {
        return windInfo;
    }

    public static class MainInfo {
        @SerializedName("temp")
        private double temperature;

        @SerializedName("humidity")
        private int humidity;

        public double getTemperature() {
            return temperature;
        }

        public int getHumidity() {
            return humidity;
        }
    }

    public static class WeatherInfo {

        @SerializedName("main")
        private String weatherMain;

        // Dodajte dodatne atribute prema potrebi (opis, ikona, itd.)

        public String getWeatherMain() {
            return weatherMain;
        }

        @SerializedName("icon")
        private String weatherIcon;

        public String getWeatherIcon() {
            return weatherIcon;
        }

    }

    public static class WindInfo {
        @SerializedName("speed")
        private double windSpeed;

        // Dodajte dodatne atribute prema potrebi (smjer vjetra, itd.)

        public double getWindSpeed() {
            return windSpeed;
        }
    }
}