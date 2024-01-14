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
        listaPitanja.add("Pekare na opštini Milići");
        listaPitanja.add("Marketi na opštini Milići");
        listaPitanja.add("Kafići na opštini Milići");
        listaPitanja.add("Pošta na opštini Milići");
        listaPitanja.add("Autobuske linije koje prolaze kroz opštinu Milići");
        listaPitanja.add("Hitne službe na opštini Milići");
        listaPitanja.add("Godišnji događaji na opštini Milići");
        // Dodajte još pitanja prema potrebi...

        HashMap<String, PitanjeOdgovorModel> mapaPitanjaOdgovora = new HashMap<>();
        mapaPitanjaOdgovora.put("Pumpe na opštini Milići", new PitanjeOdgovorModel("Pumpe na opštini Milići", "Nestro Petrol: \nRadno vrijeme: pon-ned: 06:00-22:00 \nAdresa: Srpski vladara bb \nBroj telefona: 056/490-516 \n\nHifa Petrol: \nRadno vrijeme: 05:00-00:00 \nAdresa: Miloša Obilića bb \nBroj telefona: 056/745-491 \n\nBoksit Milići: \nRadno vrijeme: pon-ned: 07:00-22:00 \nAdresa: \nBroj telefona:"));
        mapaPitanjaOdgovora.put("Apoteke na opštini Milići", new PitanjeOdgovorModel("Apoteke na opštini Milići", "Apoteka Galen Milići: \nRadno vrijeme: \nAdresa: Trg rudara br. 1 \nBroj telefona: 065/871-533 \n\nApoteka Sveti Nikola \nRadno vrijeme: pon-pet: 08:30-16:30 \nsubota: 08:00-16:00 \nnedelja: zatvoreno"));
        mapaPitanjaOdgovora.put("Banke na opštini Milići", new PitanjeOdgovorModel("Banke na opštini Milići", "Nova Banka: \nRadno vrijeme: pon-petak: 08:00-15:30 \nsubota: 08:00-11:30 \nnedelja: zatvoreno \nAdresa: Trg rudara br. 12 \nBroj telefona: 056/745-042"));
        mapaPitanjaOdgovora.put("Pekare na opštini Milići", new PitanjeOdgovorModel("Pekare na opštini Milići", "Pekara Mileks: \nRadno vrijeme: pon-ned: 07:00-21:00 \nAdresa: Cara Dušana 8A \nBroj telefona: 056/741-121 \n\nPekara San: \nRadno vrijeme: pon-sub: 06:30-22:00 \nnedelja: 08:00-20:00 \nAdresa: Petra Petrovića Njegoša \nBroj telefona: 065/548-801"));
        mapaPitanjaOdgovora.put("Marketi na opštini Milići", new PitanjeOdgovorModel("Marketi na opštini Milići", "ZMarketi: \nRadno vrijeme: pon-sub: 07:00-21:30 \nnedelja: 07:00-14:00 \nAdresa: Vuka Karadžića br.4 \nBroj telefona: 056/740-005 \n\nTrgovina Riva: \nRadno vrijeme: pon-sub: 07:00-21:00 \nnedelja: 07:00-14:00 \nAdresa: Trg rudara br. \nBroj telefona: \n\nTrgovina Maja: \nRadno vrijeme: pon-sub: 07:00-21:00 \nnedelja: 07:00-14:00 \nAdresa: Trg rudara br. \bBroj telefona: \n\nTrgovina San: \nRadno vrijeme: pon-subota: 07:00-21:00\nnedelja: 07:00-14:00 \nAdresa: Petra Petrovića Njegoša \nBroj telefona: 065/548-801"));
        mapaPitanjaOdgovora.put("Kafići na opštini Milići", new PitanjeOdgovorModel("Kafići na opštini Milići", "Kod Putina: \nRadno vrijeme: pon-nedelja: 07:00-22:00\nAdresa: Trg rudara br. \nBroj telefon: 056/740-674 \n\nKafe bar Itinere: \nRadno vrijeme: pon-nedelja: 07:00-23:00\nAdresa: Petra Petrovića Njegoša \nBroj telefon: 066/196-444 \n\nKafe bar Itinere2: \nRadno vrijeme: pon-nedelja: 07:00-00:00\nAdresa: Vuka Karadžića br. 10 \nBroj telefon: 066/196-444 \n\nKafe bar Sport: \nRadno vrijeme: pon-nedelja: 07:00-23:00\nAdresa: Vuka Karadžića br. 8 \nBroj telefon: 056/745-591"));
        mapaPitanjaOdgovora.put("Pošta na opštini Milići", new PitanjeOdgovorModel("Pošta na opštini Milići", "Pošte Srpske: \nRadno vrijeme: pon-pet: 07:00-15:00 \nsubota: 07:00-13:00 \nnedelja: zatvoreno \nAdresa: Trg rudara br. 10 \nBroj telefona: 056/745-132"));
        mapaPitanjaOdgovora.put("Autobuske linije koje prolaze kroz opštinu Milići", new PitanjeOdgovorModel("Autobuske linije koje prolaze kroz opštinu Milići", "Linija: Han Pijesak-Bijeljina: 07:30 \nLinija Bijeljina-Istočno Sarajevo: 09:00 \nVišegrad-Bijeljina: 09:00 \nLinija: Brčko-Istočno Sarajevo: 10:00 \nIstočno Sarajevo-Beograd: 10:30 \nBeograd-Istočno Sarajevo: 10:30 \nIstočno Sarajevo-Srebrenica: 12:00 \nIstočno Sarajevo-Beograd: 13:10 \nIstočno Sarajevo-Novi Sad: 13:30 \nIstočno Sarajevo-Beograd: 14:00 \nBeograd-Istočno Sarajevo: 14:20 \nBijeljina-Višegrad: 14:30 \nSrebrenica-Istočno Sarajevo: 15:10 \nBeograd-Istočno Sarajevo: 16:10 \nIstočno Sarajevo-Novi Sad: 16:30 \nNovi Sad-Istočno Sarajevo: 16:40 \nIstočno Sarajevo-Beograd: 18:00 \nBijeljina-Han Pijesak: 18:10"));
        mapaPitanjaOdgovora.put("Hitne službe na opštini Milići", new PitanjeOdgovorModel("Hitne službe na opštini Milići", "Policija: 122 \nVatrogasna služba: 123 \nHitna služba: 124"));
        mapaPitanjaOdgovora.put("Godišnji događaji na opštini Milići", new PitanjeOdgovorModel("Godišnji događaji na  opštini Milići", "Božićno selo: 4, 5, 6, 7 januar. \nDoček Srpske Nove godine: 13. januar \nMemorijalni turnir u mlaom fudbalu 24. januar \nJulsko-Avgustovski dani kulture i sporta: 11. jul - 31. avgust \nJagnjijada Derventa prva subota septembra \n"));
        // Dodajte još pitanja i odgovora prema potrebi...

        return new PitajAdapter(requireContext(), listaPitanja, mapaPitanjaOdgovora);
    }
}