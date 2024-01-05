package com.example.artour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DestinationsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destinations, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        List<Destination> destinationList = createDestinationList();
        DestinationAdapter adapter = new DestinationAdapter(destinationList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Destination> createDestinationList() {
        List<Destination> destinations = new ArrayList<>();
        destinations.add(new Destination(1, "Destinacija1", R.drawable.slika, "Opis destinacije 1"));
        destinations.add(new Destination(2, "Destinacija2", R.drawable.slika, "Opis destinacije 2"));
        destinations.add(new Destination(3, "Destinacija3", R.drawable.slika, "Opis destinacije 3"));
        destinations.add(new Destination(4, "Destinacija4", R.drawable.slika, "Opis destinacije 4"));
        // Dodajte остале дестинације...

        return destinations;
    }
}
