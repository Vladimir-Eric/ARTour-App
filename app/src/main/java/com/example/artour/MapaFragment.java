package com.example.artour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private Button spomeniciButton;
    private Button vObjektiButton;
    private Button bisteButton;
    private Button prirodaButton;
    private Button sportButton;
    private Button ostaleKategorijeButton;
    private Button sveKategorijeButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         //Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mapa, container, false);

        legendCardView = rootView.findViewById(R.id.legendCardView);

        //Pronađite SupportMapFragment u rasporedu fragmenta
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

        spomeniciButton = rootView.findViewById(R.id.spomenici);
        vObjektiButton = rootView.findViewById(R.id.v_objekti);
        bisteButton = rootView.findViewById(R.id.biste);
        prirodaButton = rootView.findViewById(R.id.priroda);
        sportButton = rootView.findViewById(R.id.sport);
        ostaleKategorijeButton = rootView.findViewById(R.id.ostale_kategorije);
        sveKategorijeButton = rootView.findViewById(R.id.sve_kategorije);

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

        //Map toolbar-iskljucivanje
        myMap.getUiSettings().setMapToolbarEnabled(false);

        // Postavite granice karte
        myMap.setLatLngBoundsForCameraTarget(bounds);

        LatLng muzej = new LatLng(44.16956, 19.07872);
        myMap.addMarker(new MarkerOptions().position(muzej).title("Muzej rudarstva").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng park_velikih_masina = new LatLng(44.1691, 19.0754);
        myMap.addMarker(new MarkerOptions().position(park_velikih_masina).title("Muzej rudarstva na otvorenom").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng rajkov_toranj = new LatLng(44.16968, 19.07869);
        myMap.addMarker(new MarkerOptions().position(rajkov_toranj).title("Rajkov toranj").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng park_ruskih_velikana = new LatLng(44.16955, 19.07816);
        myMap.addMarker(new MarkerOptions().position(park_ruskih_velikana).title("Park Ruskih velikana").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng park_indijskih_velikana = new LatLng(44.17012, 19.07809);
        myMap.addMarker(new MarkerOptions().position(park_indijskih_velikana).title("Park Indijskih velikana").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng park_kineskih_velikana = new LatLng(44.16999, 19.07815);
        myMap.addMarker(new MarkerOptions().position(park_kineskih_velikana).title("Park Kineskih velikana").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng park_srpskih_velikana = new LatLng(44.1693, 19.0769);
        myMap.addMarker(new MarkerOptions().position(park_srpskih_velikana).title("Park Srpskih velikana").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng park_evropskih_velikana = new LatLng(44.16870, 19.07491);
        myMap.addMarker(new MarkerOptions().position(park_evropskih_velikana).title("Park Evropskih velikana").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng dom_rudara = new LatLng(44.16984, 19.07882);
        myMap.addMarker(new MarkerOptions().position(dom_rudara).title("Dom rudara Milići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng spomenik_drugi_svjetski_rat_milici = new LatLng(44.16854, 19.07820);
        myMap.addMarker(new MarkerOptions().position(spomenik_drugi_svjetski_rat_milici).title("Spomenik palim borcima u Drugom svjetskom ratu Milići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng spomen_kosturnica_derventa = new LatLng(44.12635, 19.13530);
        myMap.addMarker(new MarkerOptions().position(spomen_kosturnica_derventa).title("Spomen kosturnica poginulim partizanima Derventa").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng spomen_ploca_bukovica = new LatLng(44.13667, 19.17325);
        myMap.addMarker(new MarkerOptions().position(spomen_ploca_bukovica).title("Spomen ploča palim Srpskim borcimna u Otadžbinskom ratu Donja Bukovica").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng spomen_ploca_derventa = new LatLng(44.12644, 19.13508);
        myMap.addMarker(new MarkerOptions().position(spomen_ploca_derventa).title("Spomen ploča palim Srpskim borcima u Prvom, Drugom i Otadžbinskom ratu Derventa").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng spomenik_prethodni_rat_milici = new LatLng(44.16974, 19.0781);
        myMap.addMarker(new MarkerOptions().position(spomenik_prethodni_rat_milici).title("Spomenik palim borcima u Otadžbinskom ratu Milići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng spomen_ploca_buljevici = new LatLng(44.22624, 19.04182);
        myMap.addMarker(new MarkerOptions().position(spomen_ploca_buljevici).title("Spomen ploča palim borcima u Otadžbinskom ratu Buljevići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng spomen_cesma_misici = new LatLng(44.15991, 19.09854);
        myMap.addMarker(new MarkerOptions().position(spomen_cesma_misici).title("Spomen česma borcima u Otadžbinskom ratu Mišići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng spomen_ploca_zutica = new LatLng(44.11014, 19.15912);
        myMap.addMarker(new MarkerOptions().position(spomen_ploca_zutica).title("Spomen ploča nastradalim civilima i vojnicima u Otadžbinskom ratu Žutica").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng spomen_soba = new LatLng(44.16671, 19.08902);
        myMap.addMarker(new MarkerOptions().position(spomen_soba).title("Kapela Svetog velikomučenika Dimitrija u Milićima").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng komic = new LatLng(44.11972, 19.05308);
        myMap.addMarker(new MarkerOptions().position(komic).title("Tvrđava-grad Komić").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng jerinin_grad = new LatLng(44.14057, 19.05270);
        myMap.addMarker(new MarkerOptions().position(jerinin_grad).title("Ukleti Jerinin grad").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng crkva_milici = new LatLng(44.16624, 19.08896);
        myMap.addMarker(new MarkerOptions().position(crkva_milici).title("Hram Svetog Nikole Milići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng crkva_derventa = new LatLng(44.12760, 19.13925);
        myMap.addMarker(new MarkerOptions().position(crkva_derventa).title("Crkva Svete Trojice Derventa").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng crkva_kasaba = new LatLng(44.21369, 19.10718);
        myMap.addMarker(new MarkerOptions().position(crkva_kasaba).title("Crkva Svetog Ilije Nova Kasaba").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng crkva_dukici = new LatLng(44.14568, 19.12758);
        myMap.addMarker(new MarkerOptions().position(crkva_dukici).title("Crkva Svetog velikomučenika Prokopija").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng crkva_sosari = new LatLng(44.20106, 19.09433);
        myMap.addMarker(new MarkerOptions().position(crkva_sosari).title("Crkva Svetog Joakima i Ane Vukšić Polje").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng crkva_koprivno = new LatLng(44.14660, 19.15476);
        myMap.addMarker(new MarkerOptions().position(crkva_koprivno).title("Crkva Svetih Apostola Petra i Pavla Koprivno").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng dzamija = new LatLng(44.21556, 19.10670);
        myMap.addMarker(new MarkerOptions().position(dzamija).title("Musa Pašina džamija Nova Kasaba").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng biblioteka = new LatLng(44.16944, 19.07867);
        myMap.addMarker(new MarkerOptions().position(biblioteka).title("Narodna biblioteka Milići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng rudnik = new LatLng(44.07352, 19.19231);
        myMap.addMarker(new MarkerOptions().position(rudnik).title("Rudnik Boksita površinski kop Braćan").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng crvene_stijene = new LatLng(44.12800, 19.12247);
        myMap.addMarker(new MarkerOptions().position(crvene_stijene).title("Rudnik Boksita povšinski kop Crvene stijene").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng tisovljak = new LatLng(44.09965, 19.14469);
        myMap.addMarker(new MarkerOptions().position(tisovljak).title("Botanički park Tisovljak").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng sportski_centar = new LatLng(44.16491, 19.07014);
        myMap.addMarker(new MarkerOptions().position(sportski_centar).title("Sportski centar Milići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        LatLng bazeni = new LatLng(44.16823, 19.07587);
        myMap.addMarker(new MarkerOptions().position(bazeni).title("Bazeni Milići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        LatLng vatrogasci = new LatLng(44.1630, 19.0691);
        myMap.addMarker(new MarkerOptions().position(vatrogasci).title("Teritorijalna vatrogasna jedinica Milići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng policija = new LatLng(44.17005, 19.07839);
        myMap.addMarker(new MarkerOptions().position(policija).title("Policijska stanica Milići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng dom_zdravlja = new LatLng(44.1690, 19.0770);
        myMap.addMarker(new MarkerOptions().position(dom_zdravlja).title("Dom zdravlja Sveti Nikola").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng o_skola = new LatLng(44.16812, 19.07834);
        myMap.addMarker(new MarkerOptions().position(o_skola).title("Osnovna škola \"Aleksa Jakšić Milići\"").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng s_skola = new LatLng(44.1642, 19.0697);
        myMap.addMarker(new MarkerOptions().position(s_skola).title("SŠC Milutin Milankovic Milići").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng parking1 = new LatLng(44.17018, 19.07861);
        myMap.addMarker(new MarkerOptions().position(parking1).title("Parking kod policijske stanice").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng parking2 = new LatLng(44.16922, 19.07745);
        myMap.addMarker(new MarkerOptions().position(parking2).title("Parking kod doma zdravlja").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng parking3 = new LatLng(44.16516, 19.07032);
        myMap.addMarker(new MarkerOptions().position(parking3).title("Parking kod sportske dvorane").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rajkov_toranj, zoomLevel));
    }

}