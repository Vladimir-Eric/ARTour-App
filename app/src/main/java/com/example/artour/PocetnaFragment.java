package com.example.artour;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PocetnaFragment extends Fragment {

    private ViewPager2 viewPager;

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

    public PocetnaFragment() {
    }

    private static String getRandomApiKey() {
        Random random = new Random();
        int index = random.nextInt(API_KEYS.length);
        return API_KEYS[index];
    }

    @SuppressLint("SetTextI18n")
    private void displayTemperature(double temperature) {
        int temperatureInCelsius = (int) (temperature - 273.15);
        temperatureTextView.setText(temperatureInCelsius + "°C");
    }

    @SuppressLint("SetTextI18n")
    private void displayHumidity(int humidity) {
        humidityTextView.setText(humidity + "%");
    }

    private void displayWeatherInfo(String weatherInfo) {
        weatherInfoTextView.setText(weatherInfo);
    }

    @SuppressLint("SetTextI18n")
    private void displayWindSpeed(double windSpeed) {
        windSpeedTextView.setText(windSpeed + " m/s");
    }

    private String getDayOfWeek() {
        // Implementacija za dobijanje vremenske zone na osnovu geografskih koordinata.
        ZoneId zoneId = getZoneId();
        Instant now = Instant.now();
        LocalDate localDate = now.atZone(zoneId).toLocalDate();
        return localDate.getDayOfWeek().toString();
    }

    private ZoneId getZoneId() {
        return ZoneId.systemDefault(); // Povratna vrijednost podrazumijevane vremenske zone
    }

    private void displayWeatherData(WeatherResponse weatherResponse) {
        double temperatureInCelsius = weatherResponse.getMainInfo().getTemperature();
        int humidity = weatherResponse.getMainInfo().getHumidity();
        String weatherInfo = weatherResponse.getWeatherInfo()[0].getWeatherMain();
        double windSpeed = weatherResponse.getWindInfo().getWindSpeed();

        if (weatherInfo.contains("Clouds")) {
            weatherInfo = "Oblačno";
            weatherIconImageView.setImageResource(R.drawable.clouds);
        } else if (weatherInfo.contains("Clear")) {
            weatherInfo = "Vedro";
            weatherIconImageView.setImageResource(R.drawable.clear_drawable);
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

        @SuppressLint("CutPasteId") View menuButton = view.findViewById(R.id.menu);

        final Window window = requireActivity().getWindow(); // Preuzimanje Window objekta izvan onClickListener-a

        menuButton.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireActivity());
            @SuppressLint("InflateParams") View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);

            bottomSheetDialog.setOnShowListener(dialog -> {
                BottomSheetBehavior<View> bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
                bottomSheetBehavior.setPeekHeight(window.getDecorView().getHeight());
            });

            bottomSheetView.findViewById(R.id.opstina_menu).setOnClickListener(v12 -> {
                openAboutFragment("naslov_opstina", "podnaslov_opstina", "opstina_tekst");
                bottomSheetDialog.dismiss();
            });

            bottomSheetView.findViewById(R.id.aplikacija_menu).setOnClickListener(v13 -> {
                openAboutFragment("naslov_aplikacija", "podnaslov_aplikacija", "aplikacija_tekst");
                bottomSheetDialog.dismiss();
            });

            bottomSheetView.findViewById(R.id.prava_menu).setOnClickListener(v1 -> {
                openAboutFragment("naslov_prava", "podnaslov_prava", "prava_tekst");
                bottomSheetDialog.dismiss();
            });

            bottomSheetDialog.setContentView(bottomSheetView);
            bottomSheetDialog.show();
        });

        if (!dataLoaded) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            WeatherService weatherService = retrofit.create(WeatherService.class);

            Call<WeatherResponse> call = weatherService.getWeather(CITY_NAME, getRandomApiKey());

            call.enqueue(new Callback<WeatherResponse>() {
                public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                    if (response.isSuccessful()) {
                        WeatherResponse weatherResponse = response.body();
                        if (weatherResponse != null) {
                            cachedWeatherResponse = weatherResponse;
                            dataLoaded = true;
                            displayWeatherData(weatherResponse);
                        }
                    }  // Obrada neuspješnog odgovora

                }

                @Override
                public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                    // Obrada greške
                }
            });
        } else {
            displayWeatherData(cachedWeatherResponse);
        }

        TextView danTextView = view.findViewById(R.id.dan);
        String dayOfWeek = getDayOfWeek();
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
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());

        // Slike i tekstovi koji trebaju u adapter
        viewPagerAdapter.addSlide(R.drawable.vp_image_1, "Image 1");
        viewPagerAdapter.addSlide(R.drawable.vp_image_2, "Image 2");
        viewPagerAdapter.addSlide(R.drawable.vp_image_3, "Image 3");
        viewPagerAdapter.addSlide(R.drawable.vp_image_4, "Image 4");
        viewPagerAdapter.addSlide(R.drawable.vp_image_5, "Image 5");

        viewPager.setAdapter(viewPagerAdapter);

        // Postavljanje OnClickListener-a za svaki ImageButton
        ImageButton dugme1 = view.findViewById(R.id.dugme1);
        ImageButton dugme2 = view.findViewById(R.id.dugme2);
        ImageButton dugme3 = view.findViewById(R.id.dugme3);
        ImageButton dugme4 = view.findViewById(R.id.dugme4);
        ImageButton dugme5 = view.findViewById(R.id.dugme5);

        dugme1.setOnClickListener(v -> {
            // Postavljanje trenutnog prikazanog elementa u ViewPager2
            viewPager.setCurrentItem(0);
        });

        dugme2.setOnClickListener(v -> viewPager.setCurrentItem(1));

        dugme3.setOnClickListener(v -> viewPager.setCurrentItem(2));

        dugme4.setOnClickListener(v -> viewPager.setCurrentItem(3));

        dugme5.setOnClickListener(v -> viewPager.setCurrentItem(4));

        return view;
    }

    private void openAboutFragment(String naslovStringId, String podnaslovStringId, String tekstStringId) {
        FragmentAbout fragmentAbout = new FragmentAbout();

        // Prosljeđivanje parametara fragmentu
        Bundle bundle = new Bundle();
        bundle.putString("naslovStringId", naslovStringId);
        bundle.putString("podnaslovStringId", podnaslovStringId);
        bundle.putString("tekstStringId", tekstStringId);
        fragmentAbout.setArguments(bundle);

        // Zamjena trenutnog fragmenta sa FragmentAbout
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, fragmentAbout)
                .addToBackStack(null)
                .commit();
    }

}
