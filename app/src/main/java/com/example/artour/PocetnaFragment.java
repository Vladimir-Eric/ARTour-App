package com.example.artour;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Random;

public class PocetnaFragment extends Fragment {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API_KEY1 = "51f470aceb657d8b45bda10108a0b3d2";
    private static final String API_KEY2 = "62239b9f50779b246af00153acec56cb";
    private static final String[] API_KEYS = {API_KEY1, API_KEY2};
    private static final String CITY_NAME = "Milići";

    private TextView temperatureTextView;
    private TextView humidityTextView;
    private TextView weatherInfoTextView;
    private TextView windSpeedTextView;
    private ImageView weatherIconImageView;

    private boolean dataLoaded = false;
    private WeatherResponse cachedWeatherResponse;

    private static String getRandomApiKey() {
        Random random = new Random();
        int index = random.nextInt(API_KEYS.length);
        return API_KEYS[index];
    }

    private void displayTemperature(double temperature) {
        temperatureTextView.setText("Temperature: " + temperature);
    }

    private void displayHumidity(int humidity) {
        humidityTextView.setText("Humidity: " + humidity + "%");
    }

    private void displayWeatherInfo(String weatherInfo) {
        weatherInfoTextView.setText("Weather: " + weatherInfo);
    }

    private void displayWindSpeed(double windSpeed) {
        windSpeedTextView.setText("Wind Speed: " + windSpeed + " m/s");
    }

    private void displayWeatherIcon(String weatherIcon) {
        String iconUrl = "https://openweathermap.org/img/wn/" + weatherIcon + ".png";
        Picasso.get().load(iconUrl).into(weatherIconImageView);
    }

    private void displayWeatherData(WeatherResponse weatherResponse) {
        double temperature = weatherResponse.getMainInfo().getTemperature();
        int humidity = weatherResponse.getMainInfo().getHumidity();
        String weatherInfo = weatherResponse.getWeatherInfo()[0].getWeatherMain();
        double windSpeed = weatherResponse.getWindInfo().getWindSpeed();
        String weatherIcon = weatherResponse.getWeatherInfo()[0].getWeatherIcon();

        displayTemperature(temperature);
        displayHumidity(humidity);
        displayWeatherInfo(weatherInfo);
        displayWindSpeed(windSpeed);
        displayWeatherIcon(weatherIcon);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pocetna, container, false);
        temperatureTextView = view.findViewById(R.id.temperatureTextView);
        humidityTextView = view.findViewById(R.id.humidityTextView);
        weatherInfoTextView = view.findViewById(R.id.weatherInfoTextView);
        windSpeedTextView = view.findViewById(R.id.windSpeedTextView);
        weatherIconImageView = view.findViewById(R.id.weatherIconImageView);

        if (!dataLoaded) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            WeatherService weatherService = retrofit.create(WeatherService.class);

            Call<WeatherResponse> call = weatherService.getWeather(CITY_NAME, getRandomApiKey());

            call.enqueue(new Callback<WeatherResponse>() {
                public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                    if (response.isSuccessful()) {
                        WeatherResponse weatherResponse = response.body();
                        if (weatherResponse != null) {
                            cachedWeatherResponse = weatherResponse;
                            dataLoaded = true;
                            displayWeatherData(weatherResponse);
                        }
                    } else {
                        // Obrada neuspješnog odgovora
                    }
                }

                @Override
                public void onFailure(Call<WeatherResponse> call, Throwable t) {
                    // Obrada greške
                }
            });
        } else {
            displayWeatherData(cachedWeatherResponse);
        }

        return view;
    }
}