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
        destinations.add(new Destination(1, "Spomenik palim srpskim borcima", R.drawable.slika, "U odbrambeno-otadžbinskom ratu"));
        destinations.add(new Destination(2, "Spomenik palim borcima", R.drawable.slika, "U Drugom svjetskom ratu"));
        destinations.add(new Destination(3, "Muzej rudarstva", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(4, "Muzej rudarstva na otvorenom", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(5, "Rajkov toranj", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(6, "Stećci", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(7, "Tvrđava grad Komić", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(8, "Jerinin grad", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(9, "Crkva Svetog Nikole", R.drawable.slika, "Milići"));
        destinations.add(new Destination(10, "Crkva Svetog Ilije", R.drawable.slika, "Kasaba"));
        destinations.add(new Destination(11, "Crkva Svetog Apostola Petra i Pavla", R.drawable.slika, "Koprivno"));
        destinations.add(new Destination(12, "Crkva Svetog Joakima i Ane", R.drawable.slika, "Vukšić Polje"));
        destinations.add(new Destination(13, "Musa pašina Džamija", R.drawable.slika, "Kasaba"));
        destinations.add(new Destination(14, "Park srpskih velikana", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(15, "Park ruskih velikana", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(16, "Park Evropskih velikana", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(17, "Park Kineskih velikana", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(18, "Park Indijskih velikana", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(19, "Botanički rezervat 'Tisovljak' ", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(20, "Bazeni Milići", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(21, "Rudnik boksita", R.drawable.slika, "Opis destinacije"));
        destinations.add(new Destination(22, "Sportski centar", R.drawable.slika, "Opis destinacije"));
        // Dodajte остале дестинације...

        return destinations;
    }
}