package edu.pam.tugas_rancang.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.pam.tugas_rancang.R;
import edu.pam.tugas_rancang.entity.Budget;
import edu.pam.tugas_rancang.entity.Trip;

public class BudgetListAdapter extends RecyclerView.Adapter<BudgetListAdapter.ViewHolder>{
    private ArrayList<Budget> budgetsData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public BudgetListAdapter(Context context, ArrayList<Budget> data) {
        this.mInflater = LayoutInflater.from(context);
        this.budgetsData = data;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.budget_list_row_layout, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @SuppressLint("SetTextI18n") // suppress double conversion to string
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.budgetTags.setText(budgetsData.get(position).getTag());
        holder.budgetName.setText(budgetsData.get(position).getName());
        holder.budgetAmount.setText("Rp " + String.valueOf(budgetsData.get(position).getBudget()) + " ,-");
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return budgetsData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView budgetTags;
        TextView budgetName;
        TextView budgetAmount;

        ViewHolder(View itemView) {
            super(itemView);
            budgetTags = itemView.findViewById(R.id.budget_tag);
            budgetName = itemView.findViewById(R.id.budget_name);
            budgetAmount = itemView.findViewById(R.id.budget_amount);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Budget getItem(int id) {
        return budgetsData.get(id);
    }

    // delete previous data, and update with the new one
    void updateList(ArrayList<Budget> newData){
        this.budgetsData = newData;
        this.notifyDataSetChanged();
        notifyDataSetChanged();
    }

    // add / apppend new data to the list
    public void appendList(Budget data){
        this.budgetsData.add(data);
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
