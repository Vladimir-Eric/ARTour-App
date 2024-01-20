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
        destinations.add(new Destination(1, "Spomenik palim Srpskim borcima Milići", R.drawable.slika_spomenik11, "U odbrambeno-otadžbinskom ratu"));
        destinations.add(new Destination(2, "Spomen ploča palim Srpskim borcima Bukovičko brdo", R.drawable.spomenik_bukovica1, "Milići"));
        destinations.add(new Destination(3, "Spomen ploča palim Srpskim borcima Buljevići", R.drawable.spomen_ploca_buljevici1, "Buljevići"));
        destinations.add(new Destination(4, "Spomen česma palim Srpskim borcima Mišići", R.drawable.slika, "Mišići"));
        destinations.add(new Destination(5, "Spomen kosturnica i česma poginulim partizanima Derventa", R.drawable.slika, "Derventa"));
        destinations.add(new Destination(6, "Spomenik palim borcima", R.drawable.spomenik_drugi_svjetski_rat1, "U Drugom svjetskom ratu"));
        destinations.add(new Destination(7, "Narodna biblioteka Milići", R.drawable.slika, "Narodna biblioteka"));
        destinations.add(new Destination(8, "Muzej rudarstva na otvorenom", R.drawable.muzej21, "Postaka muzeja na otvorenom"));
        destinations.add(new Destination(9, "Muzej rudarstva", R.drawable.muzej11, "Muzej rudarstva"));
        destinations.add(new Destination(10, "Rajkov toranj", R.drawable.rajkov_toranj1, "Najpoznatija lokacija na opštini Milići"));
        destinations.add(new Destination(11, "Stećci", R.drawable.stecak_milici1, "Na teritoriji opštine Milići nalazi se nekoliko nekropola stećaka"));
        destinations.add(new Destination(12, "Tvrđava grad Komić", R.drawable.komic_grad1, "Grad tvrđava"));
        destinations.add(new Destination(13, "Ukleti Jerinin grad", R.drawable.gerovi1, "Područje na kom se nalazi Jerinin grad"));
        destinations.add(new Destination(14, "Crkva Svetog Nikole", R.drawable.crkva_milici1, "Milići"));
        destinations.add(new Destination(15, "Crkva Svete Trojice", R.drawable.slika, "Derventa"));
        destinations.add(new Destination(16, "Crkva Svetog Prokopija ", R.drawable.crkva_dukici1, "Dukići"));
        destinations.add(new Destination(17, "Crkva Svetog Ilije", R.drawable.crkva_kasaba1, "Nova Kasaba"));
        destinations.add(new Destination(18, "Crkva Svetih Apostola Petra i Pavla", R.drawable.crkva_koprivno1, "Koprivno"));
        destinations.add(new Destination(19, "Crkva Svetog Joakima i Ane", R.drawable.crkva_vuksic_polje1, "Vukšić Polje"));
        destinations.add(new Destination(20, "Musa pašina Džamija", R.drawable.musa_pasina_dzamija1, "Musa Pašina džamija Nova Kasaba"));
        destinations.add(new Destination(21, "Park srpskih velikana", R.drawable.park_srpskih_velikana1, "Park Srpskih velikana"));
        destinations.add(new Destination(22, "Park ruskih velikana", R.drawable.park_ruskih_velikana1, "Park Ruskih velikana"));
        destinations.add(new Destination(23, "Park Evropskih velikana", R.drawable.park_evropskih_velikana1, "Park Evropskih velikana"));
        destinations.add(new Destination(24, "Park Indijskih velikana", R.drawable.park_indijskih_velikana1, "Park Indijskih velikana"));
        destinations.add(new Destination(25, "Park Kineskih velikana", R.drawable.park_kineskih_velikana1, "Park Kineskih velikana"));
        destinations.add(new Destination(26, "Botanički rezervat 'Tisovljak' ", R.drawable.panciceva_omorika1, "Stanište Pančićeve omorike"));
        destinations.add(new Destination(27, "Bazeni Milići", R.drawable.bazeni1, "Odmorite se i opustite na bazenima"));
        destinations.add(new Destination(28, "Rudnik boksita", R.drawable.boksit1, "Nekada najveći rudarski kop Evrope"));
        destinations.add(new Destination(29, "Sportski centar", R.drawable.sportski_centar1, "Vrijeme je za sport!"));
        // Dodajte остале дестинације...

        return destinations;
    }
}