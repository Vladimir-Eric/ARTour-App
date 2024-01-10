package com.example.artour;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class PitajAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listaPitanja;
    private HashMap<String, PitanjeOdgovorModel> mapaPitanjaOdgovora;

    public PitajAdapter(Context context, List<String> listaPitanja, HashMap<String, PitanjeOdgovorModel> mapaPitanjaOdgovora) {
        this.context = context;
        this.listaPitanja = listaPitanja;
        this.mapaPitanjaOdgovora = mapaPitanjaOdgovora;
    }

    @Override
    public int getGroupCount() {
        return listaPitanja.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1; // Svako pitanje ima jedan odgovor
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listaPitanja.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mapaPitanjaOdgovora.get(listaPitanja.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String pitanje = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);
        }

        TextView txtPitanje = convertView.findViewById(R.id.txtPitanje);
        txtPitanje.setText(pitanje);

        return convertView;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        PitanjeOdgovorModel model = (PitanjeOdgovorModel) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView txtOdgovor = convertView.findViewById(R.id.txtOdgovor);
        txtOdgovor.setText(model.getOdgovor());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}