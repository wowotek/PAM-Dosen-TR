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

public class TourListAdapter extends RecyclerView.Adapter<TourListAdapter.ViewHolder>{
    private ArrayList<Tour> ToursData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public TourListAdapter(Context context, ArrayList<Tour> data) {
        this.mInflater = LayoutInflater.from(context);
        this.ToursData = data;
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
        holder.tourNameData.setText(ToursData.get(position).getName());
        holder.tourDescData.setText(ToursData.get(position).getDesc());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return ToursData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tourNameData;
        TextView tourDescData;

        ViewHolder(View itemView) {
            super(itemView);
            tourNameData = itemView.findViewById(R.id.tour_name);
            tourDescData = itemView.findViewById(R.id.tour_desc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Tour getItem(int id) {
        return ToursData.get(id);
    }

    // delete previous data, and update with the new one
    public void updateList(ArrayList<Tour> newData){
        this.ToursData = newData;
        this.notifyDataSetChanged();
        notifyDataSetChanged();
    }

    // add / apppend new data to the list
    public void appendList(Tour data){
        this.ToursData.add(data);
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
