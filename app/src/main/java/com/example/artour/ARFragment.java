package com.example.artour;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ARFragment extends Fragment {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "51f470aceb657d8b45bda10108a0b3d2";
    private static final String CITY_NAME = "Milići";

    private TextView temperatureTextView;
    private TextView humidityTextView;
    private TextView weatherInfoTextView;
    private TextView windSpeedTextView;

    private void displayTemperature(double temperature) {
        String formattedTemperature = String.format(Locale.getDefault(), "%.1f", temperature);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a_r, container, false);
        temperatureTextView = view.findViewById(R.id.temperatureTextView);
        humidityTextView = view.findViewById(R.id.humidityTextView);
        weatherInfoTextView = view.findViewById(R.id.weatherInfoTextView);
        windSpeedTextView = view.findViewById(R.id.windSpeedTextView);

            // Inicijalizirajte Retrofit instancu
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Nastavite s korištenjem Retrofit instance za dohvaćanje podataka
        // ...

        fetchWeatherData();

        return view;
    }

    private void fetchWeatherData() {
        // Inicijalizirajte Retrofit objekt
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) //http://openweathermap.org/data/2.5
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Inicijalizirajte WeatherService pomoću Retrofit objekta
        WeatherService weatherService = retrofit.create(WeatherService.class);

        // Napravite poziv prema API-ju
        Call<WeatherResponse> call = weatherService.getWeather(CITY_NAME, API_KEY);

        // Izvršite asinkroni poziv
        call.enqueue(new Callback<WeatherResponse>() {
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    WeatherResponse weatherResponse = response.body();
                    if (weatherResponse != null) {
                        double temperature = weatherResponse.getMainInfo().getTemperature();
                        int humidity = weatherResponse.getMainInfo().getHumidity();
                        String weatherInfo = weatherResponse.getWeatherInfo()[0].getWeatherMain();
                        double windSpeed = weatherResponse.getWindInfo().getWindSpeed();

                        displayTemperature(temperature);
                        displayHumidity(humidity);
                        displayWeatherInfo(weatherInfo);
                        displayWindSpeed(windSpeed);
                    }
                } else {
                    // Obrada neuspješnog odgovora
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }


}