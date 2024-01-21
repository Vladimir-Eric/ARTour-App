package com.example.artour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap myMap;
    private ImageButton legendImageButton;
    private CardView legendCardView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mapa, container, false);

        legendCardView = rootView.findViewById(R.id.legendCardView);

        // Pronađite SupportMapFragment u rasporedu fragmenta
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        // Ako ne postoji, dodajte ga
        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            getChildFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();
        }

        // Učitajte mapu asinkrono
        mapFragment.getMapAsync(this);

        legendImageButton = rootView.findViewById(R.id.legendImageButton);
        legendCardView = rootView.findViewById(R.id.legendCardView);

        legendImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleLegendVisibility();
            }
        });

        return rootView;
    }

    private void toggleLegendVisibility() {
        if (legendCardView.getVisibility() == View.VISIBLE) {
            // Ako je trenutno vidljiva, sakrij
            legendCardView.setVisibility(View.GONE);
        } else {
            // Ako je trenutno nevidljiva, prikaži
            legendCardView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;
        float zoomLevel = 15.0f;//mijenjanje visine prikaza
        myMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //vrsta prikaza


        // Postavite minimalni i maksimalni nivo zumiranja
        myMap.setMinZoomPreference(10.0f); // Postavite željeni minimalni nivo zumiranja
        myMap.setMaxZoomPreference(20.0f); // Postavite željeni maksimalni nivo zumiranja

        // Definirajte granice (bounds)
        LatLngBounds bounds = new LatLngBounds(
                new LatLng(44.04, 19.02), // Južozapadni kut
                new LatLng(44.27, 19.24)  // Sjeveroistočni kut
        );

        if (zoomLevel == 10.0f) {
            LatLng southwestCorner = new LatLng(44.22, 19.00); // Jugozapadni ugao
            LatLng northeastCorner = new LatLng(44.25, 19.15); // Sjeveroistočni ugao
        } else if (zoomLevel == 20.0f) {
            LatLng southwestCorner = new LatLng(44.04, 19.02); // Jugozapadni ugao
            LatLng northeastCorner = new LatLng(44.27, 19.24); // Sjeveroistočni ugao
        }

        // Postavite granice karte
        myMap.setLatLngBoundsForCameraTarget(bounds);

        LatLng muzej = new LatLng(44.1696, 19.0787);
        myMap.addMarker(new MarkerOptions().position(muzej).title("Muzej rudarstva").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng dom_zdravlja = new LatLng(44.1690, 19.0770);
        myMap.addMarker(new MarkerOptions().position(dom_zdravlja).title("Dom zdravlja Sveti Nikola").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng park_velikih_masina = new LatLng(44.1691, 19.0754);
        myMap.addMarker(new MarkerOptions().position(park_velikih_masina).title("Muzej rudarstva na otvorenom").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng motel = new LatLng(44.1682, 19.0753);
        myMap.addMarker(new MarkerOptions().position(motel).title("Motel Milici").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        LatLng motel_crystal = new LatLng(44.1924, 19.0717);
        myMap.addMarker(new MarkerOptions().position(motel_crystal).title("Motel Crystal Milici").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng rajkov_toranj = new LatLng(44.1697, 19.0787);
        myMap.addMarker(new MarkerOptions().position(rajkov_toranj).title("Rajkov toranj").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng park_ruskih_velikana = new LatLng(44.1695, 19.0781);
        myMap.addMarker(new MarkerOptions().position(park_ruskih_velikana).title("Park Ruskih velikana").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng park_indijskih_velikana = new LatLng(44.17012, 19.07809);
        myMap.addMarker(new MarkerOptions().position(park_indijskih_velikana).title("Park Indijskih velikana").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng park_kineskih_velikana = new LatLng(44.16999, 19.07815);
        myMap.addMarker(new MarkerOptions().position(park_kineskih_velikana).title("Park Kineskih velikana").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng park_srpskih_velikana = new LatLng(44.1693, 19.0769);
        myMap.addMarker(new MarkerOptions().position(park_srpskih_velikana).title("Park Srpskih velikana").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng park_evropskih_velikana = new LatLng(44.16870, 19.07491);
        myMap.addMarker(new MarkerOptions().position(park_evropskih_velikana).title("Park Evropskih velikana").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng dom_rudara = new LatLng(44.1698, 19.0788);
        myMap.addMarker(new MarkerOptions().position(dom_rudara).title("Dom rudara Milici").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng spomenik_drugi_svjetski_rat_milici = new LatLng(44.1685, 19.07822);
        myMap.addMarker(new MarkerOptions().position(spomenik_drugi_svjetski_rat_milici).title("Spomenik palim borcima u drugom svjetskom ratu").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng spomen_kosturnica_derventa = new LatLng(44.12643, 19.13523);
        myMap.addMarker(new MarkerOptions().position(spomen_kosturnica_derventa).title("Spomen kosturnica poginulim partizanima Derventa").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng spomen_ploca_bukovica = new LatLng(44.13667, 19.17325);
        myMap.addMarker(new MarkerOptions().position(spomen_ploca_bukovica).title("Spomen ploča palim Srpskim borcimna Donja Bukovica").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng spomen_ploca_derventa = new LatLng(44.12644, 19.13508);
        myMap.addMarker(new MarkerOptions().position(spomen_ploca_derventa).title("Spomen ploča palim Srpskim borcima Derventa").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng spomenik_prethodni_rat_milici = new LatLng(44.16974, 19.0781);
        myMap.addMarker(new MarkerOptions().position(spomenik_prethodni_rat_milici).title("Spomenik palim borcima u prethodnom ratu Milići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng spomen_ploca_buljevici = new LatLng(44.22877, 19.03753);
        myMap.addMarker(new MarkerOptions().position(spomen_ploca_buljevici).title("Spomen ploča palim borcima Buljevići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng spomen_cesma_misici = new LatLng(44.15991, 19.09854);
        myMap.addMarker(new MarkerOptions().position(spomen_cesma_misici).title("Spomen česma palim Srpskim borcima Mišići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng spomen_soba_milici = new LatLng(44.16670, 19.08904);
        myMap.addMarker(new MarkerOptions().position(spomen_soba_milici).title("Spomen soba palim borcima Milići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng komic = new LatLng(44.1542, 19.0415);
        myMap.addMarker(new MarkerOptions().position(komic).title("Tvrdjava grad Komić").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng crkva_milici = new LatLng(44.1663, 19.0889);
        myMap.addMarker(new MarkerOptions().position(crkva_milici).title("Crkva Svetog Nikole Milici").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng crkva_derventa = new LatLng(44.1277, 19.1393);
        myMap.addMarker(new MarkerOptions().position(crkva_derventa).title("Crkva Svete Trojice Derventa").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng crkva_kasaba = new LatLng(44.21368, 19.10719);
        myMap.addMarker(new MarkerOptions().position(crkva_kasaba).title("Crkva Svetog Ilije Nova Kasaba").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng crkva_dukici = new LatLng(44.14577, 19.1275);
        myMap.addMarker(new MarkerOptions().position(crkva_dukici).title("Crkva Svetog velikomucenika Prokopija").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng crkva_sosari = new LatLng(44.2012, 19.0943);
        myMap.addMarker(new MarkerOptions().position(crkva_sosari).title("Crkva Svetog Joakima i Ane Vukscic Polje").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng crkva_koprivno = new LatLng(44.1469, 19.1548);
        myMap.addMarker(new MarkerOptions().position(crkva_koprivno).title("Crkva Svetih Apostola Petra i Pavla Koprivno").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng dzamija = new LatLng(44.21556, 19.10670);
        myMap.addMarker(new MarkerOptions().position(dzamija).title("Musa Pašina džamija Nova Kasaba").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng biblioteka = new LatLng(44.16944, 19.07867);
        myMap.addMarker(new MarkerOptions().position(biblioteka).title("Narodna biblioteka Milići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng rudnik = new LatLng(44.0746, 19.1916);
        myMap.addMarker(new MarkerOptions().position(rudnik).title("Rudnik Boksita").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng o_skola = new LatLng(44.16820, 19.07829);
        myMap.addMarker(new MarkerOptions().position(o_skola).title("Osnovna skola Aleksa Jaksic Milici").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng s_skola = new LatLng(44.1642, 19.0697);
        myMap.addMarker(new MarkerOptions().position(s_skola).title("SSC Milutin Milankovic Milici").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng sportski_centar = new LatLng(44.16491, 19.07014);
        myMap.addMarker(new MarkerOptions().position(sportski_centar).title("Sportski centar Milici").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng vatrogasci = new LatLng(44.1630, 19.0691);
        myMap.addMarker(new MarkerOptions().position(vatrogasci).title("Teritorijalna vatrogasna jedinica Milici").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng policija = new LatLng(44.1701, 19.0784);
        myMap.addMarker(new MarkerOptions().position(policija).title("Policijska stanica Milici").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rajkov_toranj, zoomLevel));
    }

}