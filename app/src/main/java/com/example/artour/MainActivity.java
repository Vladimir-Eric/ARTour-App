package com.example.artour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.example.artour.databinding.ActivityMainBinding;




public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //EDGE TO EDGE
        //WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        replaceFragment(new PocetnaFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.pocetna) {
                replaceFragment(new PocetnaFragment());
            } else if (item.getItemId() == R.id.location) {
                replaceFragment(new MapaFragment());
            } else if (item.getItemId() == R.id.chatgpt) {
                replaceFragment(new PitajFragment());
            } else if (item.getItemId() == R.id.popis) {
                //promjena sa PopisFragment na DestinationsFragment zbog ubačenog fragmenta
                replaceFragment(new DestinationsFragment());
            } else if (item.getItemId() == R.id.ar) {
                replaceFragment(new ARFragment());
            }

            return true;
        });
        binding.bottomNavigationView.setSelectedItemId(R.id.pocetna);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}