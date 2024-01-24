package com.example.artour;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Objects;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


    public class FragmentAbout extends Fragment {
        @SuppressLint("DiscouragedApi")
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_about, container, false);

            // Izvucite argumente iz bundla
            Bundle args = getArguments();
            if (args != null) {
                String naslovStringId = args.getString("naslovStringId", "");
                String podnaslovStringId = args.getString("podnaslovStringId", "");
                String tekstStringId = args.getString("tekstStringId", "");

                // Postavljanje vrijednosti za "Naslov" i "Podnaslov" koristeći string resurse
                TextView naslovTextView = rootView.findViewById(R.id.Naslov);
                naslovTextView.setText(getString(getResources().getIdentifier(naslovStringId, "string", requireActivity().getPackageName())));

                TextView podnaslovTextView = rootView.findViewById(R.id.Podnaslov);
                podnaslovTextView.setText(getString(getResources().getIdentifier(podnaslovStringId, "string", requireActivity().getPackageName())));

                TextView tekstTextView = rootView.findViewById(R.id.tekst_tekst);
                tekstTextView.setText(getString(getResources().getIdentifier(tekstStringId, "string", requireActivity().getPackageName())));

            }



            Button backButton2 = rootView.findViewById(R.id.backButton2);

            // Postavite OnClickListener za backButton2
            backButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Vraćanje na prethodni fragment
                    FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                    fragmentManager.popBackStack();
                }
            });

            return rootView;
        }
    }


