package com.example.artour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {

    private List<Slide> slides = new ArrayList<>();
    private Context context;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    public void addSlide(int image, String text) {
        slides.add(new Slide(image, text));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Slide slide = slides.get(position);
        holder.imageView.setImageResource(slide.getImage());
        holder.textView.setText(slide.getText());
    }

    @Override
    public int getItemCount() {
        return slides.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.menu_heading);
            textView = itemView.findViewById(R.id.viewPagerTekst);
        }
    }
}