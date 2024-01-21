package com.example.artour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

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
        backButton.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());

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
                znamenitostImageView.setImageResource(R.drawable.stecak_milici);
                znamenitostTextView.setText(getString(R.string.dest9));
                break;
            case 10:
                znamenitostImageView.setImageResource(R.drawable.komic_grad);
                znamenitostTextView.setText(getString(R.string.dest10));
                break;
            case 11:
                znamenitostImageView.setImageResource(R.drawable.gerovi);
                znamenitostTextView.setText(getString(R.string.dest11));
                break;
            case 12:
                znamenitostImageView.setImageResource(R.drawable.dom_rudara);
                znamenitostTextView.setText(getString(R.string.dest12));
                break;
            case 13:
                znamenitostImageView.setImageResource(R.drawable.biblioteka);
                znamenitostTextView.setText(getString(R.string.dest13));
                break;
            case 14:
                znamenitostImageView.setImageResource(R.drawable.muzej);
                znamenitostTextView.setText(getString(R.string.dest14));
                break;
            case 15:
                znamenitostImageView.setImageResource(R.drawable.muzej1);
                znamenitostTextView.setText(getString(R.string.dest15));
                break;
            case 16:
                znamenitostImageView.setImageResource(R.drawable.rajkov_toranj);
                znamenitostTextView.setText(getString(R.string.dest16));
                break;
            case 17:
                znamenitostImageView.setImageResource(R.drawable.crkva_milici);
                znamenitostTextView.setText(getString(R.string.dest17));
                break;
            case 18:
                znamenitostImageView.setImageResource(R.drawable.crkva_derventa);
                znamenitostTextView.setText(getString(R.string.dest18));
                break;
            case 19:
                znamenitostImageView.setImageResource(R.drawable.crkva_dukici);
                znamenitostTextView.setText(getString(R.string.dest19));
                break;
            case 20:
                znamenitostImageView.setImageResource(R.drawable.crkva_nova_kasaba);
                znamenitostTextView.setText(getString(R.string.dest20));
                break;
            case 21:
                znamenitostImageView.setImageResource(R.drawable.crkva_koprivno);
                znamenitostTextView.setText(getString(R.string.dest21));
                break;
            case 22:
                znamenitostImageView.setImageResource(R.drawable.crkva_vuksic_polje);
                znamenitostTextView.setText(getString(R.string.dest22));
                break;
            case 23:
                znamenitostImageView.setImageResource(R.drawable.musa_pasina_dzamija);
                znamenitostTextView.setText(getString(R.string.dest23));
                break;
            case 24:
                znamenitostImageView.setImageResource(R.drawable.park_srpskih_velikana);
                znamenitostTextView.setText(getString(R.string.dest24));
                break;
            case 25:
                znamenitostImageView.setImageResource(R.drawable.park_ruskih_velikana);
                znamenitostTextView.setText(getString(R.string.dest25));
                break;
            case 26:
                znamenitostImageView.setImageResource(R.drawable.park_evropskih_velikana);
                znamenitostTextView.setText(getString(R.string.dest26));
                break;
            case 27:
                znamenitostImageView.setImageResource(R.drawable.park_indijskih_velikana);
                znamenitostTextView.setText(getString(R.string.dest27));
                break;
            case 28:
                znamenitostImageView.setImageResource(R.drawable.park_kineskih_velikana);
                znamenitostTextView.setText(getString(R.string.dest28));
                break;
            case 29:
                znamenitostImageView.setImageResource(R.drawable.panciceva_omorika);
                znamenitostTextView.setText(getString(R.string.dest29));
                break;
            case 30:
                znamenitostImageView.setImageResource(R.drawable.boksit);
                znamenitostTextView.setText(getString(R.string.dest30));
                break;
            case 31:
                znamenitostImageView.setImageResource(R.drawable.bazeni);
                znamenitostTextView.setText(getString(R.string.dest31));
                break;
            case 32:
                znamenitostImageView.setImageResource(R.drawable.sportski_centar);
                znamenitostTextView.setText(getString(R.string.dest32));
                break;
            // Dodajte ostale destinacije...
            default:
                // Defaultne slike i tekstovi
                znamenitostImageView.setImageResource(R.drawable.default_image);
                znamenitostTextView.setText(getString(R.string.default_opis));
        }

        return view;
    }
}