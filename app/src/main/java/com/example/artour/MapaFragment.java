package com.example.artour;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap myMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mapa, container, false);

        // Pronađite SupportMapFragment u rasporedu fragmenta
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        // Ako ne postoji, dodajte ga
        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            getChildFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();
        }

        // Učitajte mapu asinkrono
        mapFragment.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;
        float zoomLevel = 14.0f;//mijenjanje visine prikaza
        myMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //vrsta prikaza

        LatLng milici = new LatLng(44.1660, 19.0775);
        myMap.addMarker(new MarkerOptions().position(milici).title("Milici Republika Srpska"));
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(milici, zoomLevel));
    }
}