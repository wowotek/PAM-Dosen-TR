package edu.pam.tugas_rancang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import edu.pam.tugas_rancang.adapter.TripListAdapter;
import edu.pam.tugas_rancang.entity.Trip;

public class TripManagementActivity extends AppCompatActivity implements TripListAdapter.ItemClickListener{
    TripListAdapter tripListAdapter;
    ArrayList<Trip> tripData = new ArrayList<>();

    /* Widgets */
    RecyclerView tripListView;
    Button tripAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_management);

        // Prepare Widgets
        this.tripListView = findViewById(R.id.tripList);
        this.tripAddButton = findViewById(R.id.tripNewButton);

        // Prepare Adapters
        this.tripListView.setLayoutManager(new LinearLayoutManager(this));
        this.tripListAdapter = new TripListAdapter(this, this.tripData);
        this.tripListAdapter.setClickListener(this);
        this.tripListView.setAdapter(this.tripListAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    public void newTripOnClick(View view){
        Intent i = new Intent(this, AddTourActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                this.tripListAdapter.appendList(
                        new Trip(this.tripData.size()+1, data.getStringExtra("tourNameExtra"), data.getStringExtra("tourDescExtra"))
                );
                this.tourListAdapter.notifyDataSetChanged();
            }
        }
    }
}
