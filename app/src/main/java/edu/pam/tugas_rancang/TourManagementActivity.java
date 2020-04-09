package edu.pam.tugas_rancang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.pam.tugas_rancang.adapter.TourListAdapter;
import edu.pam.tugas_rancang.api.GetTourAllResponse;
import edu.pam.tugas_rancang.api.RetrofitClient;
import edu.pam.tugas_rancang.entity.Tour;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TourManagementActivity extends AppCompatActivity implements TourListAdapter.ItemClickListener {
    TourListAdapter tourListAdapter;
    ArrayList<Tour> toursData = new ArrayList<>();

    /* Widgets */
    RecyclerView tourListView;
    Button tourAddButton;

    /* Intents Related */
    String user_username;
    int user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_management);

        Intent intent = getIntent();
        user_username = intent.getStringExtra("user_username");
        user_id = intent.getIntExtra("user_id", 0);

        // Prepare Widgets
        this.tourListView = findViewById(R.id.tourList);
        this.tourAddButton = findViewById(R.id.tourNewButton);

        // Prepare Adapters
        this.tourListView.setLayoutManager(new LinearLayoutManager(this));
        this.tourListAdapter = new TourListAdapter(this, this.toursData);
        this.tourListAdapter.setClickListener(this);
        this.tourListView.setAdapter(this.tourListAdapter);

        RetrofitClient.getEndPoints().getTourAll().enqueue(new Callback<GetTourAllResponse>() {
            @Override
            public void onResponse(Call<GetTourAllResponse> call, Response<GetTourAllResponse> response) {
                ArrayList<Tour> tours = new ArrayList<>();
                for(Tour t: response.body().getTours()){
                    if(t.getUser_id() == user_id) {
                        tourListAdapter.appendList(t);
                    }
                }
                tourListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GetTourAllResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    public void newTourOnClick(View view){
        Intent i = new Intent(this, AddTourActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                this.tourListAdapter.appendList(
                        new Tour(this.toursData.size()+1, data.getStringExtra("tourNameExtra"), data.getStringExtra("tourDescExtra"), 0)
                );
                this.tourListAdapter.notifyDataSetChanged();
            }
        }
    }
}
