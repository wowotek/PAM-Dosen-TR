package edu.pam.tugas_rancang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.pam.tugas_rancang.R;
import edu.pam.tugas_rancang.entity.Tour;
import edu.pam.tugas_rancang.entity.Trip;

public class TripListAdapter extends RecyclerView.Adapter<TripListAdapter.ViewHolder>{
    private ArrayList<Trip> TripsData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public TripListAdapter(Context context, ArrayList<Trip> data) {
        this.mInflater = LayoutInflater.from(context);
        this.TripsData = data;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.tour_list_row_layout, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tripNameData.setText(TripsData.get(position).getName());
        holder.tripDescData.setText(TripsData.get(position).getDescription());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return TripsData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tripNameData;
        TextView tripDescData;

        ViewHolder(View itemView) {
            super(itemView);
            tripNameData = itemView.findViewById(R.id.trip_name);
            tripDescData = itemView.findViewById(R.id.trip_desc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Trip getItem(int id) {
        return TripsData.get(id);
    }

    // delete previous data, and update with the new one
    void updateList(ArrayList<Trip> newData){
        this.TripsData = newData;
        this.notifyDataSetChanged();
        notifyDataSetChanged();
    }

    // add / apppend new data to the list
    public void appendList(Trip data){
        this.TripsData.add(data);
        this.notifyDataSetChanged();
        notifyDataSetChanged();
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
