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
        listaPitanja.add("Pitanje 1");
        listaPitanja.add("Pitanje 2");
        // Dodajte još pitanja prema potrebi...

        HashMap<String, PitanjeOdgovorModel> mapaPitanjaOdgovora = new HashMap<>();
        mapaPitanjaOdgovora.put("Pitanje 1", new PitanjeOdgovorModel("Pitanje 1", "Odgovor na pitanje 1"));
        mapaPitanjaOdgovora.put("Pitanje 2", new PitanjeOdgovorModel("Pitanje 2", "Odgovor na pitanje 2"));
        // Dodajte još pitanja i odgovora prema potrebi...

        return new PitajAdapter(requireContext(), listaPitanja, mapaPitanjaOdgovora);
    }
}