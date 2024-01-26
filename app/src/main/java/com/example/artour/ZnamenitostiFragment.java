package com.example.artour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

public class ZnamenitostiFragment extends Fragment {

    private static final String ARG_DESTINATION_ID = "destinationId";

    public ZnamenitostiFragment() {
        // Prazan konstruktor
    }

    public static ZnamenitostiFragment newInstance(int destinationId) {
        ZnamenitostiFragment fragment = new ZnamenitostiFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_DESTINATION_ID, destinationId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_znamenitosti, container, false);

        ImageView znamenitostImageView = view.findViewById(R.id.znamenitostImageView);
        TextView znamenitostTextView = view.findViewById(R.id.znamenitostTextView);
        Button backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, new DestinationsFragment());
            transaction.commit();
        });


        // Dohvati destinationId
        assert getArguments() != null;
        int destinationId = getArguments().getInt(ARG_DESTINATION_ID);

        // Postavi slike i tekstove na osnovu destinationId
        switch (destinationId) {
            case 1:
                znamenitostImageView.setImageResource(R.drawable.slika_spomenik1);
                znamenitostTextView.setText(getString(R.string.dest1));
                break;
            case 2:
                znamenitostImageView.setImageResource(R.drawable.spomen_cesma_misici);
                znamenitostTextView.setText(getString(R.string.dest2));
                break;
            case 3:
                znamenitostImageView.setImageResource(R.drawable.spomenik_bukovica);
                znamenitostTextView.setText(getString(R.string.dest3));
                break;
            case 4:
                znamenitostImageView.setImageResource(R.drawable.spomenik_zutica);
                znamenitostTextView.setText(getString(R.string.dest4));
                break;
            case 5:
                znamenitostImageView.setImageResource(R.drawable.spomen_ploca_buljevici);
                znamenitostTextView.setText(getString(R.string.dest5));
                break;
            case 6:
                znamenitostImageView.setImageResource(R.drawable.spomen_cesma_derventa);
                znamenitostTextView.setText(getString(R.string.dest6));
                break;
            case 7:
                znamenitostImageView.setImageResource(R.drawable.spomen_kosturnica);
                znamenitostTextView.setText(getString(R.string.dest7));
                break;
            case 8:
                znamenitostImageView.setImageResource(R.drawable.spomenik_drugi_svjetski_rat);
                znamenitostTextView.setText(getString(R.string.dest8));
                break;
            case 9:
                znamenitostImageView.setImageResource(R.drawable.kapela_milici);
                znamenitostTextView.setText(getString(R.string.dest9));
                break;
            case 10:
                znamenitostImageView.setImageResource(R.drawable.stecak_milici);
                znamenitostTextView.setText(getString(R.string.dest10));
                break;
            case 11:
                znamenitostImageView.setImageResource(R.drawable.komic_grad);
                znamenitostTextView.setText(getString(R.string.dest11));
                break;
            case 12:
                znamenitostImageView.setImageResource(R.drawable.gerovi);
                znamenitostTextView.setText(getString(R.string.dest12));
                break;
            case 13:
                znamenitostImageView.setImageResource(R.drawable.dom_rudara);
                znamenitostTextView.setText(getString(R.string.dest13));
                break;
            case 14:
                znamenitostImageView.setImageResource(R.drawable.biblioteka);
                znamenitostTextView.setText(getString(R.string.dest14));
                break;
            case 15:
                znamenitostImageView.setImageResource(R.drawable.otvoreni_muzej0);
                znamenitostTextView.setText(getString(R.string.dest15));
                break;
            case 16:
                znamenitostImageView.setImageResource(R.drawable.muzej1);
                znamenitostTextView.setText(getString(R.string.dest16));
                break;
            case 17:
                znamenitostImageView.setImageResource(R.drawable.rajkov_toranj);
                znamenitostTextView.setText(getString(R.string.dest17));
                break;
            case 18:
                znamenitostImageView.setImageResource(R.drawable.crkva_milici);
                znamenitostTextView.setText(getString(R.string.dest18));
                break;
            case 19:
                znamenitostImageView.setImageResource(R.drawable.crkva_derventa);
                znamenitostTextView.setText(getString(R.string.dest19));
                break;
            case 20:
                znamenitostImageView.setImageResource(R.drawable.crkva_dukici);
                znamenitostTextView.setText(getString(R.string.dest20));
                break;
            case 21:
                znamenitostImageView.setImageResource(R.drawable.crkva_nova_kasaba);
                znamenitostTextView.setText(getString(R.string.dest21));
                break;
            case 22:
                znamenitostImageView.setImageResource(R.drawable.crkva_koprivno);
                znamenitostTextView.setText(getString(R.string.dest22));
                break;
            case 23:
                znamenitostImageView.setImageResource(R.drawable.crkva_vuksic_polje);
                znamenitostTextView.setText(getString(R.string.dest23));
                break;
            case 24:
                znamenitostImageView.setImageResource(R.drawable.musa_pasina_dzamija);
                znamenitostTextView.setText(getString(R.string.dest24));
                break;
            case 25:
                znamenitostImageView.setImageResource(R.drawable.park_srpskih_velikana);
                znamenitostTextView.setText(getString(R.string.dest25));
                break;
            case 26:
                znamenitostImageView.setImageResource(R.drawable.park_ruskih_velikana);
                znamenitostTextView.setText(getString(R.string.dest26));
                break;
            case 27:
                znamenitostImageView.setImageResource(R.drawable.park_evropskih_velikana);
                znamenitostTextView.setText(getString(R.string.dest27));
                break;
            case 28:
                znamenitostImageView.setImageResource(R.drawable.park_indijskih_velikana);
                znamenitostTextView.setText(getString(R.string.dest28));
                break;
            case 29:
                znamenitostImageView.setImageResource(R.drawable.park_kineskih_velikana);
                znamenitostTextView.setText(getString(R.string.dest29));
                break;
            case 30:
                znamenitostImageView.setImageResource(R.drawable.panciceva_omorika);
                znamenitostTextView.setText(getString(R.string.dest30));
                break;
            case 31:
                znamenitostImageView.setImageResource(R.drawable.boksit);
                znamenitostTextView.setText(getString(R.string.dest31));
                break;
            case 32:
                znamenitostImageView.setImageResource(R.drawable.crvene_stijene);
                znamenitostTextView.setText(getString(R.string.dest32));
                break;
            case 33:
                znamenitostImageView.setImageResource(R.drawable.bazeni);
                znamenitostTextView.setText(getString(R.string.dest33));
                break;
            case 34:
                znamenitostImageView.setImageResource(R.drawable.sportski_centar);
                znamenitostTextView.setText(getString(R.string.dest34));
                break;
            default:
                // Defaultne slike i tekstovi
                znamenitostImageView.setImageResource(R.drawable.default_image);
                znamenitostTextView.setText(getString(R.string.default_opis));
        }

        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager2);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());

        if(destinationId == 1){
        viewPagerAdapter.addSlide(R.drawable.slika_spomenik1, "Tekst 1");
        viewPagerAdapter.addSlide(R.drawable.spomenik_milici0, "Tekst 2");
        viewPagerAdapter.addSlide(R.drawable.spomenik_milici00, "Tekst 3");
        viewPagerAdapter.addSlide(R.drawable.spomenik_milici000, "Tekst 4");
        viewPagerAdapter.addSlide(R.drawable.spomenik_milici0000, "Tekst 1");
        viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 2) {
            viewPagerAdapter.addSlide(R.drawable.spomen_cesma_misici1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.spomen_misici0, "Tekst 2");
            viewPagerAdapter.addSlide(R.drawable.spomen_misici00, "Tekst 3");
            viewPagerAdapter.addSlide(R.drawable.spomen_misici00, "Tekst 4");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 3) {
            viewPagerAdapter.addSlide(R.drawable.spomenik_bukovica, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 4) {
            viewPagerAdapter.addSlide(R.drawable.zutica0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.zutica2, "Tekst 2");
            viewPagerAdapter.addSlide(R.drawable.zutica3, "Tekst 3");
            viewPagerAdapter.addSlide(R.drawable.zutica4, "Tekst 4");
            viewPagerAdapter.addSlide(R.drawable.zutica5, "Tekst 5");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 5) {
            viewPagerAdapter.addSlide(R.drawable.spomen_ploca_buljevici1, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 6) {
            viewPagerAdapter.addSlide(R.drawable.spomen_derventa0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.spomen_derventa000, "Tekst 2");
            viewPagerAdapter.addSlide(R.drawable.spomen_derventa0000, "Tekst 3");
            viewPagerAdapter.addSlide(R.drawable.spomen_derventa00, "Tekst 4");
            viewPagerAdapter.addSlide(R.drawable.spomen_derventa00000, "Tekst 5");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 7) {
            viewPagerAdapter.addSlide(R.drawable.spomen_kosturnica0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.spomen_kosturnica00, "Tekst 2");
            viewPagerAdapter.addSlide(R.drawable.spomen_kosturnica000, "Tekst 3");
            viewPagerAdapter.addSlide(R.drawable.spomen_kosturnica0000, "Tekst 4");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 8) {
            viewPagerAdapter.addSlide(R.drawable.drugi_svjetski_rat, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.drugi_svjetski_rat0, "Tekst 2");
            viewPagerAdapter.addSlide(R.drawable.drugi_svjetski_rat00, "Tekst 3");
            viewPagerAdapter.addSlide(R.drawable.drugi_svjetski_rat000, "Tekst 4");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 9) {
            viewPagerAdapter.addSlide(R.drawable.kapela_milici, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 10) {
            viewPagerAdapter.addSlide(R.drawable.stecak_milici1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.stecak00, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 11) {
            viewPagerAdapter.addSlide(R.drawable.komic_grad1, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 12) {
            viewPagerAdapter.addSlide(R.drawable.gerovi1, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 13) {
            viewPagerAdapter.addSlide(R.drawable.dom_rudara1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.dom_rudara0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.dom_rudara00, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.dom_rudara000, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 14) {
            viewPagerAdapter.addSlide(R.drawable.biblioteka1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.biblioteka0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.biblioteka00, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 15) {
            viewPagerAdapter.addSlide(R.drawable.otvoreni_muzej0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.muzej21, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.buldozer0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.damper0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.busilica, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.rudarska_lokomotiva0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.utovarivac0, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 16) {
            viewPagerAdapter.addSlide(R.drawable.muzej11, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.muzej0, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 17) {
            viewPagerAdapter.addSlide(R.drawable.rajkov_toranj1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.rajkov_toranj0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.rajkova_toranj00, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.rajkov_toranj000, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.rajkov_toranj0000, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 18) {
            viewPagerAdapter.addSlide(R.drawable.crkva_milici1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.milici0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.milici00, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.milici000, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.milici0000, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 19) {
            viewPagerAdapter.addSlide(R.drawable.crkva_derventa1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.derventa0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.derventa00, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.derventa000, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 20) {
            viewPagerAdapter.addSlide(R.drawable.crkva_dukici1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.dukici0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.dukici00, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 21) {
            viewPagerAdapter.addSlide(R.drawable.crkva_nova_kasaba, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 22) {
            viewPagerAdapter.addSlide(R.drawable.crkva_koprivno1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.koprivno0, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 23) {
            viewPagerAdapter.addSlide(R.drawable.crkva_vuksic_polje1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.vuksic_polje00, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 24) {
            viewPagerAdapter.addSlide(R.drawable.musa_pasina_dzamija1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.dzamija0, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 25) {
            viewPagerAdapter.addSlide(R.drawable.park_srpskih_velikana1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.princip, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.bircanin, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.milankovic, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.sv_sava, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.tesla, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.aleksa, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 26) {
            viewPagerAdapter.addSlide(R.drawable.park_ruskih_velikana1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.putin, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.gagarin, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.dostojevski, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.petar_veliki, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.sv_sergej, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 27) {
            viewPagerAdapter.addSlide(R.drawable.park_evropskih_velikana1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.aristotel, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.da_vinci, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.mocart, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.sekspir, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.pikaso, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.njutn, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.ajnstajn, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.kiri, "Tekst 1");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 28) {
            viewPagerAdapter.addSlide(R.drawable.park_indijskih_velikana1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.park_indijskih_velikana0, "Tekst 2");
            viewPagerAdapter.addSlide(R.drawable.park_indijskih_velikana00, "Tekst 3");
            viewPagerAdapter.addSlide(R.drawable.park_indijskih_velikana000, "Tekst 4");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 29) {
            viewPagerAdapter.addSlide(R.drawable.park_kineskih_velikana1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.park_kineskih_velikana0, "Tekst 2");
            viewPagerAdapter.addSlide(R.drawable.park_kineskih_velikana00, "Tekst 3");
            viewPagerAdapter.addSlide(R.drawable.park_kineskih_velikana000, "Tekst 4");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 30) {
            viewPagerAdapter.addSlide(R.drawable.panciceva_omorika1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.panciceva_omorika0, "Tekst 2");
            viewPagerAdapter.addSlide(R.drawable.panciceva_omorika00, "Tekst 3");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 31) {
            viewPagerAdapter.addSlide(R.drawable.boksit1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.podbracan0, "Tekst 2");
            viewPagerAdapter.addSlide(R.drawable.podbracan00, "Tekst 3");
            viewPagerAdapter.addSlide(R.drawable.podbracan000, "Tekst 4");
            viewPagerAdapter.addSlide(R.drawable.podbracan0000, "Tekst 5");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 32) {
            viewPagerAdapter.addSlide(R.drawable.crvene_stijene0, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.crvene_stijene00, "Tekst 2");
            viewPagerAdapter.addSlide(R.drawable.crvene_stijene000, "Tekst 3");
            viewPagerAdapter.addSlide(R.drawable.crvene_stijene0000, "Tekst 4");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 33) {
            viewPagerAdapter.addSlide(R.drawable.bazeni1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.bazeni0, "Tekst 2");
            viewPagerAdapter.addSlide(R.drawable.bazeni00, "Tekst 3");
            viewPagerAdapter.addSlide(R.drawable.bazeni000, "Tekst 4");
            viewPager2.setAdapter(viewPagerAdapter);
        }else if (destinationId == 34) {
            viewPagerAdapter.addSlide(R.drawable.sportski_centar1, "Tekst 1");
            viewPagerAdapter.addSlide(R.drawable.sportski_centar00, "Tekst 2");
            viewPagerAdapter.addSlide(R.drawable.sportski_centar000, "Tekst 3");
            viewPager2.setAdapter(viewPagerAdapter);
        }

        return view;
    }
}