package com.example.artour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DestinationsFragment extends Fragment implements DestinationAdapter.OnDestinationClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destinations, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        List<Destination> destinationList = createDestinationList();
        DestinationAdapter adapter = new DestinationAdapter(destinationList, this); // Dodajte "this" kao OnDestinationClickListener
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void onDestinationClick(int destinationId) {
        openZnamenitostiFragment(destinationId);
    }

    private void openZnamenitostiFragment(int destinationId) {
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, ZnamenitostiFragment.newInstance(destinationId));
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private List<Destination> createDestinationList() {
        List<Destination> destinations = new ArrayList<>();
        destinations.add(new Destination(1, "Spomenik palim Srpskim borcima Milići", R.drawable.slika, "U odbrambeno-otadžbinskom ratu"));
        destinations.add(new Destination(2, "Spomen ploča palim Srpskim borcima Derventa", R.drawable.slika, "Derventa"));
        destinations.add(new Destination(3, "Spomen ploča palim Srpskim borcima Bukovičko brdo", R.drawable.slika, "Milići"));
        destinations.add(new Destination(4, "Spomen ploča palim Srpskim borcima Buljevići", R.drawable.slika, "Buljevići"));
        destinations.add(new Destination(5, "Spomen česma palim Srpskim borcima Mišići", R.drawable.slika, "Mišići"));
        destinations.add(new Destination(6, "Spomen kosturnica poginulim partizanima Derventa", R.drawable.slika, "Derventa"));
        destinations.add(new Destination(7, "Spomenik palim borcima", R.drawable.slika, "U Drugom svjetskom ratu"));
        destinations.add(new Destination(8, "Narodna biblioteka Milići", R.drawable.slika, "Milići"));
        destinations.add(new Destination(9, "Muzej rudarstva", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(10, "Muzej rudarstva na otvorenom", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(11, "Rajkov toranj", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(12, "Stećci", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(13, "Tvrđava grad Komić", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(14, "Ukleti Jerinin grad", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(15, "Crkva Svetog Nikole", R.drawable.slika, "Milići"));
        destinations.add(new Destination(16, "Crkva Svete Trojice", R.drawable.slika, "Derventa"));
        destinations.add(new Destination(17, "Crkva Svetog Prokopija ", R.drawable.slika, "Dukići"));
        destinations.add(new Destination(18, "Crkva Svetog Ilije", R.drawable.slika, "Kasaba"));
        destinations.add(new Destination(19, "Crkva Svetih Apostola Petra i Pavla", R.drawable.slika, "Koprivno"));
        destinations.add(new Destination(20, "Crkva Svetog Joakima i Ane", R.drawable.slika, "Vukšić Polje"));
        destinations.add(new Destination(21, "Musa pašina Džamija", R.drawable.slika, "Kasaba"));
        destinations.add(new Destination(22, "Park srpskih velikana", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(23, "Park ruskih velikana", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(24, "Park Evropskih velikana", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(25, "Park Kineskih velikana", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(26, "Park Indijskih velikana", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(27, "Botanički rezervat 'Tisovljak' ", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(28, "Bazeni Milići", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(29, "Rudnik boksita", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(30, "Sportski centar", R.drawable.slika, "Opis destinacije"));
        // Dodajte остале дестинације...

        return destinations;
    }
}