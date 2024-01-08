package com.example.artour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ZnamenitostiFragment extends Fragment {

    private static final String ARG_DESTINATION_ID = "destinationId";

    public ZnamenitostiFragment() {
        // Prazan konstruktor
    }

    public static ZnamenitostiFragment newInstance(int destinationId) {
        ZnamenitostiFragment fragment = new ZnamenitostiFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_DESTINATION_ID, destinationId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_znamenitosti, container, false);

        ImageView znamenitostImageView = view.findViewById(R.id.znamenitostImageView);
        TextView znamenitostTextView = view.findViewById(R.id.znamenitostTextView);
        ImageButton backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());

        // Dohvati destinationId
        assert getArguments() != null;
        int destinationId = getArguments().getInt(ARG_DESTINATION_ID);

        // Postavi slike i tekstove na osnovu destinationId
        switch (destinationId) {
            case 1:
                znamenitostImageView.setImageResource(R.drawable.toranj);
                znamenitostTextView.setText(getString(R.string.dest1));
                break;
            case 2:
                znamenitostImageView.setImageResource(R.drawable.default_image);
                znamenitostTextView.setText(getString(R.string.dest2));
                break;
            case 3:
                znamenitostImageView.setImageResource(R.drawable.default_image);
                znamenitostTextView.setText(getString(R.string.dest3));
                break;
            case 4:
                znamenitostImageView.setImageResource(R.drawable.default_image);
                znamenitostTextView.setText(getString(R.string.dest4));
                break;
            // Dodajte ostale destinacije...
            default:
                // Defaultne slike i tekstovi
                znamenitostImageView.setImageResource(R.drawable.default_image);
                znamenitostTextView.setText(getString(R.string.default_opis));
        }

        return view;
    }
}