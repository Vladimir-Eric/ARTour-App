package com.example.artour;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.example.artour.databinding.ActivityMainBinding;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        View decorView = getWindow().getDecorView();

        // Postavljanje prozora da omogući prikazivanje status bara
        WindowInsetsController insetsController = decorView.getWindowInsetsController();
        if (insetsController != null) {
            insetsController.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
            insetsController.hide(WindowInsets.Type.navigationBars());
        }

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
                replaceFragment(new DestinationsFragment());
            } else if (item.getItemId() == R.id.ar) {
                replaceFragment(new ARFragment());
            }
            return true;
        });
        binding.bottomNavigationView.setSelectedItemId(R.id.pocetna);

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                FragmentManager fragmentManager = getSupportFragmentManager();
                int count = fragmentManager.getBackStackEntryCount();

                if (count == 0) {
                    Fragment currentFragment = fragmentManager.findFragmentById(R.id.frame_layout);

                    if (currentFragment instanceof PocetnaFragment) {
                        // Ako smo već na PocetnaFragment, izlazak iz aplikacije
                        finish();
                    } else {
                        if (currentFragment instanceof ZnamenitostiFragment) {
                            replaceFragment(new DestinationsFragment());
                        }
                        else {
                            // Ako nismo na PocetnaFragment, zamijeni fragment s PocetnaFragment
                            replaceFragment(new PocetnaFragment());
                            binding.bottomNavigationView.setSelectedItemId(R.id.pocetna);
                        }
                    }
                } else {
                    // Ako ima prethodnih fragmenata, vrati se na prethodni fragment
                    fragmentManager.popBackStack();
                }
            }
        };

        // callback
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    private void replaceFragment(Fragment fragment) {
        // Učitajte animaciju fade_in
        Animation fadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);

        // Dobivanje reference na odgovarajući View objekt (pretpostavljamo da je R.id.frame_layout)
        View view = findViewById(R.id.frame_layout);

        // Pokrenite animaciju na odgovarajućem View objektu
        view.startAnimation(fadeIn);

        // Zamijenite fragmente
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}