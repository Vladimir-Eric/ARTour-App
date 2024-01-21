package com.example.artour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.fragment.app.Fragment;

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

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                // Zatvori sve ostale grupe osim trenutno proširene
                for (int i = 0; i < adapter.getGroupCount(); i++) {
                    if (i != groupPosition && expandableListView.isGroupExpanded(i)) {
                        expandableListView.collapseGroup(i);
                    }
                }
            }
        });

        return view;
    }

    private PitajAdapter createPitajAdapter() {
        List<String> listaPitanja = new ArrayList<>();
        listaPitanja.add("Parking");
        listaPitanja.add("Benzinske pumpe");
        listaPitanja.add("Apoteke");
        listaPitanja.add("Banke");
        listaPitanja.add("Pekare");
        listaPitanja.add("Pošta");
        listaPitanja.add("Autobuske linije kroz opštinu Milići");
        listaPitanja.add("Razonoda i fizička aktivnost");
        listaPitanja.add("Hitne službe");
        listaPitanja.add("Godišnji događaji");
        // Dodajte još pitanja prema potrebi...

        HashMap<String, PitanjeOdgovorModel> mapaPitanjaOdgovora = new HashMap<>();
        mapaPitanjaOdgovora.put("Parking", new PitanjeOdgovorModel("Parking", "Na raspolaganju Vam stoji besplatan parking na više lokacija širom Milića"));
        mapaPitanjaOdgovora.put("Benzinske pumpe", new PitanjeOdgovorModel("Benzinske pumpe", "Pumpa (Milići) \n\nRadno vrijeme: pon-ned 06:00-22:00 \nAdresa: Srpskih vladara bb \nBroj telefona: 056/490-516 \n\n\nPumpa (Milići)\n\nRadno vrijeme: pon-ned 05:00-00:00 \nAdresa: Miloša Obilića bb \nBroj telefona: 056/745-491 \n\n\nPumpa (Šošari)\n\nRadno vrijeme: pon-ned 07:00-22:00 \nAdresa: \nBroj telefona:"));
        mapaPitanjaOdgovora.put("Apoteke", new PitanjeOdgovorModel("Apoteke", "Apoteka (Milići)\n\nRadno vrijeme: \nAdresa: Trg rudara br. 1 \nBroj telefona: 065/871-533 \n\n\nApoteka (Milići)\n\nRadno vrijeme: pon-pet 07:00-18:00 \nsubota 08:00-13:00 \nnedjelja zatvoreno"));
        mapaPitanjaOdgovora.put("Banke", new PitanjeOdgovorModel("Banke", "Banka (Milići) \n\nRadno vrijeme: pon-pet: 08:00-15:30 \nsubota: 08:00-11:30 \nnedjelja: zatvoreno \nAdresa: Trg rudara br. 12 \nBroj telefona: 056/745-042"));
        mapaPitanjaOdgovora.put("Pekare", new PitanjeOdgovorModel("Pekare", "Pekara (Milići) \n\nRadno vrijeme: pon-ned: 07:00-21:00 \nAdresa: Cara Dušana 8A \nBroj telefona: 056/741-121 \n\nPekara (Milići) \n\nRadno vrijeme: pon-sub: 06:30-22:00 \nnedjelja: 08:00-20:00 \nAdresa: Petra Petrovića Njegoša \nBroj telefona: 065/548-801"));
        mapaPitanjaOdgovora.put("Pošta", new PitanjeOdgovorModel("Pošta", "Pošte Srpske: \n\nRadno vrijeme: pon-pet: 07:00-15:00 \nsubota: 07:00-13:00 \nnedjelja: zatvoreno \nAdresa: Trg rudara br. 10 \nBroj telefona: 056/745-132"));
        mapaPitanjaOdgovora.put("Autobuske linije kroz opštinu Milići", new PitanjeOdgovorModel("Autobuske linije kroz opštinu Milići", "Međunarodne linije: \n\nBeograd: \n11:10; 13:00; 14:20; 15:30; 17:30; 00:30; \n\nIstočno Sarajevo: \n08:50; 09:50; 11:35; 12:35; 13:15; 14:20; 16:10; 17:30; 02:10; 03:15; \n\nSarajevo: \n06:35; \n\nSrebrenica: \n11:40; \n\nVlasenica: \n06:35; 07:40; 08:50; 09:50; 11:30; 11:35; 12:30; 13:15; 13:25; 13:35; 14:20; 15:10; 15:20; 16:10; 16:30; 17:20; 18:10 \n\nBijeljina: \n07:50; 09:30 12:35; 14:55; 18:35; \n\nBrčko: \n14:55; \n\nZvornik: \n07:50; 10:05; 11:10; 12:30; 13:00; 14:20; 14:55; 15:30; 16:30; 17:30; 18:15; 18:35; \n\nTrebinje: \n16:35; \n\nNovi Sad: \n10:05; 16:30; 02:30; \n\nVišegrad: \n14:30; \n\n\nMeđugradske linije: \n\nNova Kasaba: \n05:50; 06:20; 12:20; 13:25; 14:20; 15:30; 17:30; \n\nKonjević Polje: \n06:20; 13:25; \n\nSopotnik: \n13:25; \n\nAvdagina Njiva: \n14:20; \n\nDerventa: \n05:50; 06:20; 06:45; 12:20; 13:25; 14:20; 15:30; 17:30; 18:20; \n\nŽutica: \n06:20; 06:45; 13:25; 14:20; 18:20; \n\nŠtedrić: \n06:45; 13:25; \n\nBakići: \n17:30; \n\nPajići: \n06:45; 13:25; \n\nVukovići: \n07:10; 11:50; 14:20; 17:30; \n\n\nSezonske linije: \n\nBudva: \n07:30; \n\nPetrovac: \n22:30; \n\nUlcinj: \n23:50;"));
        mapaPitanjaOdgovora.put("Razonoda i fizička aktivnost", new PitanjeOdgovorModel("Razonoda i fizička aktivnost", "Uživajte u raznim sportskim aktivnostima u opštini Milići. \nNaša opština nudi brojne mogućnosti za fizičku aktivnost, odmor i zabavu:\n" +
                "\n" +
                "Sportski Centar \nModerni sportski centar sa terenom za basket, mali fudbal, odbojku na pijesku, fudbal na travi, kao i street workout zonu.\n" +
                "\n" +
                "Dvorana za sport i rekreaciju \nZa one koji vole sportske igre u zatvorenom prostoru, naša dvorana je opremljena za različite aktivnosti.\n" +
                "\n" +
                "Teniski tereni"));
        mapaPitanjaOdgovora.put("Hitne službe", new PitanjeOdgovorModel("Hitne službe", "122 Policija; \n123 Vatrogasna služba; \n124 Služba hitne pomoći; \n\n1325 BIHAMK info centar; \n033/282-100 BIHAMK pozivi iz inostranstva; \n\n1285 Auto moto savez Republike Srpske; \n+387 051/341-285 AMSRS pozivi iz inostranstva;"));
        mapaPitanjaOdgovora.put("Godišnji događaji", new PitanjeOdgovorModel("Godišnji događaji", "Božićno selo \njanuar 4-7 \n\nDoček Srpske Nove godine \njanuar 13. \n\nMemorijalni turnir u malom fudbalu \njanuar 15-19 \n\nDan opštine Milići \nmart 31. \n\nJulsko-avgustovski dani kulture i sporta \njul 11. - avgust 31. \n\nJagnjijada Derventa \nseptembar - prva subota"));
        // Dodajte još pitanja i odgovora prema potrebi...

        return new PitajAdapter(requireContext(), listaPitanja, mapaPitanjaOdgovora);
    }
}