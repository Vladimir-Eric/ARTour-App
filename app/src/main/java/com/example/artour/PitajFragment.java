package com.example.artour;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PitajFragment extends Fragment {

    public PitajFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pitaj_fragment, container, false);

        ExpandableListView expandableListView = view.findViewById(R.id.expandableListView);
        PitajAdapter adapter = createPitajAdapter();
        expandableListView.setAdapter(adapter);

        return view;
    }

    private PitajAdapter createPitajAdapter() {
        List<String> listaPitanja = new ArrayList<>();
        listaPitanja.add("Pumpe na opštini Milići");
        listaPitanja.add("Apoteke na opštini Milići");
        listaPitanja.add("Banke na opštini Milići");
        listaPitanja.add("Marketi na opštini Milići");
        listaPitanja.add("Kafići na opštini Milići");
        listaPitanja.add("Pošta na opštini Milići");
        listaPitanja.add("Godišnji događaji na  opštini Milići");
        listaPitanja.add("Autobuske linije koje prolaze kroz opštinu Milići");
        listaPitanja.add("Hitne službe na opštini Milići");
        listaPitanja.add("Pitanje 10");
        // Dodajte još pitanja prema potrebi...

        HashMap<String, PitanjeOdgovorModel> mapaPitanjaOdgovora = new HashMap<>();
        mapaPitanjaOdgovora.put("Pumpe na opštini Milići", new PitanjeOdgovorModel("Pumpe na opštini Milići", "Odgovor na pitanje 1"));
        mapaPitanjaOdgovora.put("Apoteke na opštini Milići", new PitanjeOdgovorModel("Apoteke na opštini Milići", "Odgovor na pitanje 2"));
        mapaPitanjaOdgovora.put("Banke na opštini Milići", new PitanjeOdgovorModel("Banke na opštini Milići", "Odgovor na pitanje 3"));
        mapaPitanjaOdgovora.put("Marketi na opštini Milići", new PitanjeOdgovorModel("Marketi na opštini Milići", "Odgovor na pitanje 4"));
        mapaPitanjaOdgovora.put("Kafići na opštini Milići", new PitanjeOdgovorModel("Kafići na opštini Milići", "Odgovor na pitanje 5"));
        mapaPitanjaOdgovora.put("Pošta na opštini Milići", new PitanjeOdgovorModel("Pošta na opštini Milići", "Odgovor na pitanje 6"));
        mapaPitanjaOdgovora.put("Godišnji događaji na  opštini Milići", new PitanjeOdgovorModel("Godišnji događaji na  opštini Milići", "Odgovor na pitanje 7"));
        mapaPitanjaOdgovora.put("Autobuske linije koje prolaze kroz opštinu Milići", new PitanjeOdgovorModel("Autobuske linije koje prolaze kroz opštinu Milići", "Odgovor na pitanje 8"));
        mapaPitanjaOdgovora.put("Hitne službe na opštini Milići", new PitanjeOdgovorModel("Hitne službe na opštini Milići", "Odgovor na pitanje 9"));
        mapaPitanjaOdgovora.put("Pitanje 10", new PitanjeOdgovorModel("Pitanje 10", "Odgovor na pitanje 10"));
        // Dodajte još pitanja i odgovora prema potrebi...

        return new PitajAdapter(requireContext(), listaPitanja, mapaPitanjaOdgovora);
    }
}