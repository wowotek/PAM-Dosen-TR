package edu.pam.tugas_rancang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import edu.pam.tugas_rancang.adapter.TourListAdapter;
import edu.pam.tugas_rancang.entity.Tour;

public class TourManagementActivity extends AppCompatActivity implements TourListAdapter.ItemClickListener {
    TourListAdapter tourListAdapter;
    ArrayList<Tour> toursData = new ArrayList<>();

    /* Widgets */
    RecyclerView tourListView;
    Button tourAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_management);

        // Prepare Widgets
        this.tourListView = findViewById(R.id.tourList);
        this.tourAddButton = findViewById(R.id.tour_add_btn);

        this.tourListView.setLayoutManager(new LinearLayoutManager(this));
        this.tourListAdapter = new TourListAdapter(this, this.toursData);

    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
