package edu.pam.tugas_rancang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        this.tourAddButton = findViewById(R.id.tourNewButton);

        this.tourListView.setLayoutManager(new LinearLayoutManager(this));
        this.tourListAdapter = new TourListAdapter(this, this.toursData);
        this.tourListAdapter.setClickListener(this);
        this.tourListView.setAdapter(this.tourListAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    public void newTourOnClick(View view){
        Intent intent = new Intent(TourManagementActivity.this, AddTourActivity.class);
        Intent resultIntent = new Intent();
        setResult(1, resultIntent);
        TourManagementActivity.this.startActivityForResult(intent, 1);
        finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, data.getStringExtra("tourName") + " " + data.getStringExtra("tourDesc"), Toast.LENGTH_LONG).show();
    }
}
