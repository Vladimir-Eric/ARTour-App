package com.example.artour;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.List;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class PocetnaFragment extends Fragment {

    private ViewPager2 viewPager;
    private ViewPagerAdapter viewPagerAdapter;

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
        int temperatureInCelsius = (int) (temperature - 273.15);
        temperatureTextView.setText(temperatureInCelsius + "°C");
    }

    private void displayHumidity(int humidity) {
        humidityTextView.setText(humidity + "%");
    }

    private void displayWeatherInfo(String weatherInfo) {
        weatherInfoTextView.setText(weatherInfo);
    }

    private void displayWindSpeed(double windSpeed) {
        windSpeedTextView.setText(windSpeed + " m/s");
    }

    /*private void displayWeatherIcon(String weatherIcon) {
        String iconUrl = "https://openweathermap.org/img/wn/" + weatherIcon + ".png";
        Picasso.get().load(iconUrl).into(weatherIconImageView);
    }*/

    private String getDayOfWeek(double lat, double lon) {
        // Implementacija za dobijanje vremenske zone na osnovu geografskih koordinata.
        // Ova funkcija bi trebalo da vrati dan u sedmici na osnovu trenutnog vremena u odabranoj vremenskoj zoni.

        ZoneId zoneId = getZoneId(lat, lon);
        Instant now = Instant.now();
        LocalDate localDate = now.atZone(zoneId).toLocalDate();
        return localDate.getDayOfWeek().toString();
    }

    private ZoneId getZoneId(double lat, double lon) {
        // Implementacija za dobijanje vremenske zone na osnovu geografskih koordinata.
        // Ova funkcija bi trebalo da vrati odgovarajuću vremensku zonu na osnovu latitude i longitude.

        // Primer implementacije:
        // Zamenite ovu implementaciju sa stvarnom logikom za dobijanje vremenske zone.
        // Ako koristite Android, možete razmotriti korišćenje LocationManager-a za dobijanje vremenske zone.
        // Na primer, možete koristiti LocationManager.getLastKnownLocation() sa GPS_PROVIDER.

        // Povratna vrednost je ZoneId za vremensku zonu na osnovu latitude i longitude.
        // Ako ne možete dobiti preciznu vremensku zonu, možete koristiti neku podrazumevanu vremensku zonu.

        // Primer:
        // return ZoneId.of("Europe/Belgrade"); // Podrazumevana vremenska zona za Beograd
        return ZoneId.systemDefault(); // Povratna vrednost podrazumevane vremenske zone
    }

    private void displayWeatherData(WeatherResponse weatherResponse) {
        double temperatureInCelsius = weatherResponse.getMainInfo().getTemperature();
        int humidity = weatherResponse.getMainInfo().getHumidity();
        String weatherInfo = weatherResponse.getWeatherInfo()[0].getWeatherMain();
        double windSpeed = weatherResponse.getWindInfo().getWindSpeed();
        //String weatherIcon = weatherResponse.getWeatherInfo()[0].getWeatherIcon();


        if (weatherInfo.contains("Clouds")) {
            weatherInfo = "Oblačno";
            weatherIconImageView.setImageResource(R.drawable.clouds);
        } else if (weatherInfo.contains("Clear")) {
            weatherInfo = "Vedro";
            weatherIconImageView.setImageResource(R.drawable.clear);
        } else if (weatherInfo.contains("Mist") && weatherInfo.contains("Haze")) {
            weatherInfo = "Izmaglica";
            weatherIconImageView.setImageResource(R.drawable.fog);
        } else if (weatherInfo.contains("Smoke")) {
            weatherInfo = "Dim";
            weatherIconImageView.setImageResource(R.drawable.fog);
        } else if (weatherInfo.contains("Dust") && weatherInfo.contains("Sand")) {
            weatherInfo = "Prašina";
            weatherIconImageView.setImageResource(R.drawable.fog);
        } else if (weatherInfo.contains("Fog")) {
            weatherInfo = "Magla";
            weatherIconImageView.setImageResource(R.drawable.fog);
        } else if (weatherInfo.contains("Squall")) {
            weatherInfo = "Jak vjetar";
            weatherIconImageView.setImageResource(R.drawable.windy);
        } else if (weatherInfo.contains("Tornado")) {
            weatherInfo = "Tornado";
            weatherIconImageView.setImageResource(R.drawable.hurricane);
        } else if (weatherInfo.contains("Snow")) {
            weatherInfo = "Snijeg";
            weatherIconImageView.setImageResource(R.drawable.snowy);
        } else if (weatherInfo.contains("Rain")) {
            weatherInfo = "Kiša";
            weatherIconImageView.setImageResource(R.drawable.rain);
        } else if (weatherInfo.contains("Drizzle")) {
            weatherInfo = "Sitna kiša";
            weatherIconImageView.setImageResource(R.drawable.drizzle);
        } else if (weatherInfo.contains("Thunderstorm")) {
            weatherInfo = "Grmljavina";
            weatherIconImageView.setImageResource(R.drawable.storm);
        }

        displayTemperature(temperatureInCelsius);
        displayHumidity(humidity);
        displayWeatherInfo(weatherInfo);
        displayWindSpeed(windSpeed);
        //displayWeatherIcon(weatherIcon);
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

        TextView danTextView = view.findViewById(R.id.dan);
        double latitude = 44.17016;
        double longitude = 19.09195;
        String dayOfWeek = getDayOfWeek(latitude, longitude);
        if (dayOfWeek.contains("MONDAY")) {
            dayOfWeek = "Ponedjeljak";
        } else if (dayOfWeek.contains("TUESDAY")) {
            dayOfWeek = "Utorak";
        } else if (dayOfWeek.contains("WEDNESDAY")) {
            dayOfWeek = "Srijeda";
        } else if (dayOfWeek.contains("THURSDAY")) {
            dayOfWeek = "Četvrtak";
        } else if (dayOfWeek.contains("FRIDAY")) {
            dayOfWeek = "Petak";
        } else if (dayOfWeek.contains("SATURDAY")) {
            dayOfWeek = "Subota";
        } else if (dayOfWeek.contains("SUNDAY")) {
            dayOfWeek = "Nedjelja";
        }
        danTextView.setText(dayOfWeek);

        viewPager = view.findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getContext());

        // Dodajte slike i tekstove u adapter
        viewPagerAdapter.addSlide(R.drawable.slika, "Tekst 1");
        viewPagerAdapter.addSlide(R.drawable.toranj, "Tekst 2");
        viewPagerAdapter.addSlide(R.drawable.slika, "Tekst 3");
        viewPagerAdapter.addSlide(R.drawable.default_image, "Tekst 4");
        viewPagerAdapter.addSlide(R.drawable.slika, "Tekst 5");

        viewPager.setAdapter(viewPagerAdapter);

        // Postavljanje OnClickListener-a za svaki ImageButton
        ImageButton dugme1 = view.findViewById(R.id.dugme1);
        ImageButton dugme2 = view.findViewById(R.id.dugme2);
        ImageButton dugme3 = view.findViewById(R.id.dugme3);
        ImageButton dugme4 = view.findViewById(R.id.dugme4);
        ImageButton dugme5 = view.findViewById(R.id.dugme5);

        dugme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Postavljanje trenutnog prikazanog elementa u ViewPager2
                viewPager.setCurrentItem(0);
            }
        });

        dugme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        dugme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });

        dugme4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        });

        dugme5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(4);
            }
        });

        return view;
    }
}