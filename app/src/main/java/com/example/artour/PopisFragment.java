package com.example.artour;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PopisFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //promjena layouta sa fragment_popis na fragment_destinations
        return inflater.inflate(R.layout.fragment_destinations, container, false);
    }
}