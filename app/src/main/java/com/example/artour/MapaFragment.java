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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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
        float zoomLevel = 15.0f;//mijenjanje visine prikaza
        myMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //vrsta prikaza

        LatLng milici = new LatLng(44.1660, 19.0775);
        myMap.addMarker(new MarkerOptions().position(milici).title("Milici Republika Srpska").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng dom_zdravlja = new LatLng(44.1690, 19.0770);
        myMap.addMarker(new MarkerOptions().position(dom_zdravlja).title("Dom zdravlja Sveti Nikola").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng park_velikih_masina = new LatLng(44.1690, 19.0754);
        myMap.addMarker(new MarkerOptions().position(park_velikih_masina).title("Muzej rudarstva na otvorenom").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng motel = new LatLng(44.1682, 19.0753);
        myMap.addMarker(new MarkerOptions().position(motel).title("Motel Milici").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng rajkov_toranj = new LatLng(44.1697, 19.0787);
        myMap.addMarker(new MarkerOptions().position(rajkov_toranj).title("Rajkov toranj").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));


        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(milici, zoomLevel));
    }
}