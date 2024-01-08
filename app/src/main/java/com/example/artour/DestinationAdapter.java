package com.example.artour;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.ViewHolder> {

    private final List<Destination> destinationList;
    private final OnDestinationClickListener onDestinationClickListener;

    public DestinationAdapter(List<Destination> destinationList, OnDestinationClickListener onDestinationClickListener) {
        this.destinationList = destinationList;
        this.onDestinationClickListener = onDestinationClickListener;
    }

    public interface OnDestinationClickListener {
        void onDestinationClick(int destinationId);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_destination, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Destination destination = destinationList.get(position);

        // Postavljanje podataka u ViewHolder
        holder.destinationTitle.setText(destination.getTitle());
        holder.destinationImage.setImageResource(destination.getImageResource());
        holder.destinationDescription.setText(destination.getDescription());

        holder.itemView.setOnClickListener(view -> {
            if (onDestinationClickListener != null) {
                onDestinationClickListener.onDestinationClick(destination.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return destinationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView destinationImage;
        public TextView destinationTitle;
        public TextView destinationDescription;

        public ViewHolder(View view) {
            super(view);
            destinationImage = view.findViewById(R.id.destinationImage);
            destinationTitle = view.findViewById(R.id.destinationTitle);
            destinationDescription = view.findViewById(R.id.destinationDescription);
        }
    }
}
