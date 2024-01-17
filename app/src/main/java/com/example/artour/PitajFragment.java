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
        listaPitanja.add("Pumpe na opštini Milići");
        listaPitanja.add("Apoteke na opštini Milići");
        listaPitanja.add("Banke na opštini Milići");
        listaPitanja.add("Pekare na opštini Milići");
        listaPitanja.add("Restorani na opštini Milići:");
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
        mapaPitanjaOdgovora.put("Restorani na opštini Milići:", new PitanjeOdgovorModel("Restorani na opštini Milići:", "Restoran Express: \nRadno vrijeme: pon-sub: 07:00-22:00 \nnedjelja: zatvoreno \nAdresa: Trg rudara 3 \nBroj telefona: 056/741-387 \n\nKošnica: \nRadno vrijeme: pon-sub: 07:00-23:00 \nnedjelja: zatvoreno \nAdresa: Vuka Karadžića br. \nBroj telefona:066/766-700"));
        mapaPitanjaOdgovora.put("Marketi na opštini Milići", new PitanjeOdgovorModel("Marketi na opštini Milići", "ZMarketi: \nRadno vrijeme: pon-sub: 07:00-21:30 \nnedelja: 07:00-14:00 \nAdresa: Vuka Karadžića br.4 \nBroj telefona: 056/740-005 \n\nTrgovina Riva: \nRadno vrijeme: pon-sub: 07:00-21:00 \nnedelja: 07:00-14:00 \nAdresa: Trg rudara br. \nBroj telefona: \n\nTrgovina Maja: \nRadno vrijeme: pon-sub: 07:00-21:00 \nnedelja: 07:00-14:00 \nAdresa: Trg rudara br. \bBroj telefona: \n\nTrgovina San: \nRadno vrijeme: pon-subota: 07:00-21:00\nnedelja: 07:00-14:00 \nAdresa: Petra Petrovića Njegoša \nBroj telefona: 065/548-801"));
        mapaPitanjaOdgovora.put("Kafići na opštini Milići", new PitanjeOdgovorModel("Kafići na opštini Milići", "Kod Putina: \nRadno vrijeme: pon-nedelja: 07:00-22:00\nAdresa: Trg rudara br. \nBroj telefon: 056/740-674 \n\nKafe bar Itinere: \nRadno vrijeme: pon-nedelja: 07:00-23:00\nAdresa: Petra Petrovića Njegoša \nBroj telefon: 066/196-444 \n\nKafe bar Itinere2: \nRadno vrijeme: pon-nedelja: 07:00-00:00\nAdresa: Vuka Karadžića br. 10 \nBroj telefon: 066/196-444 \n\nKafe bar Sport: \nRadno vrijeme: pon-nedelja: 07:00-23:00\nAdresa: Vuka Karadžića br. 8 \nBroj telefon: 056/745-591"));
        mapaPitanjaOdgovora.put("Pošta na opštini Milići", new PitanjeOdgovorModel("Pošta na opštini Milići", "Pošte Srpske: \nRadno vrijeme: pon-pet: 07:00-15:00 \nsubota: 07:00-13:00 \nnedelja: zatvoreno \nAdresa: Trg rudara br. 10 \nBroj telefona: 056/745-132"));
        mapaPitanjaOdgovora.put("Autobuske linije koje prolaze kroz opštinu Milići", new PitanjeOdgovorModel("Autobuske linije koje prolaze kroz opštinu Milići", "Međunarodne linije: \nBeograd: 11:10; 13:00; 14:20; 15:30; 17:30; 00:30; \nIstočno Sarajevo: 08:50; 09:50; 11:35; 12:35; 13:15; 14:20; 16:10; 17:30; 02:10; 03:15; \nSarajevo: 06:35; \nSrebrenica: 11:40; \nVlasenica: 06:35; 07:40; 08:50; 09:50; 11:30; 11:35; 12:30; 13:15; 13:25; 13:35; 14:20; 15:10; 15:20; 16:10; 16:30; 17:20; 18:10\nBijeljina: 07:50; 09:30 12:35; 14:55; 18:35;\nBrčko: 14:55;\nZvornik: 07:50; 10:05; 11:10; 12:30; 13:00; 14:20; 14:55; 15:30; 16:30; 17:30; 18:15; 18:35;\nTrebinje: 16:35;\nNovi Sad: 10:05; 16:30; 02:300\nVišegrad: 14:30\n\nMeđugradske linije: \nNova Kasaba: 05:50; 06:20; 12:20; 13:25; 14:20; 15:30; 17:30; \nKonjević Polje: 06:20; 13:25; \nSopotnik: 13:25; \nAvdagina Njiva: 14:20; Derventa: 05:50; 06:20; 06:45; 12:20; 13:25; 14:20; 15:30; 17:30; 18:20; \nŽutica: 06:20; 06:45; 13:25; 14:20; 18:20; \nŠtedrić: 06:45; 13:25; \nBakići: 17:30; \nPajići: 06:45; 13:25; Vukovići: 07:10; 11:50; 14:20; 17:30; \n\nSezonske linije: \nBudva: 07:30; \nPetrovac:22:30 \nUlcinj: 23:50;"));
        mapaPitanjaOdgovora.put("Hitne službe na opštini Milići", new PitanjeOdgovorModel("Hitne službe na opštini Milići", "Policija: 122; \nVatrogasna služba: 123; \nSlužba hitne pomoći: 124; \n\nBIHAMK info centar: 1325; \nBIHAMK pozivi iz inostranstva: 033/282-100; \n\nAuto moto savez Republike Srpske: 1285; \nAMSRS pozivi iz inostranstva: +387 051/341-285;"));
        mapaPitanjaOdgovora.put("Godišnji događaji na opštini Milići", new PitanjeOdgovorModel("Godišnji događaji na  opštini Milići", "Božićno selo: 4, 5, 6, 7 januar; \nDoček Srpske Nove godine: 13. januar; \nMemorijalni turnir u malom fudbalu 15.-19. januar; \nDan opštine Milići: 31. mart; \nJulsko-Avgustovski dani kulture i sporta: 11. jul - 31. avgust; \nJagnjijada Derventa prva subota septembra; \nDan kompanije Boksit: 16. decembar;"));
        // Dodajte još pitanja i odgovora prema potrebi...

        return new PitajAdapter(requireContext(), listaPitanja, mapaPitanjaOdgovora);
    }
}