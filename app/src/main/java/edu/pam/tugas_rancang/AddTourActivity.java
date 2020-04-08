package edu.pam.tugas_rancang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTourActivity extends AppCompatActivity {

    /* Widgets */
    EditText tourNameData;
    EditText tourDescData;
    Button tourAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tour);

        this.tourNameData = findViewById(R.id.tour_name_input);
        this.tourDescData = findViewById(R.id.tour_desc_input);
        this.tourAddButton = findViewById(R.id.tour_add_btn);
    }

    public void tourAddOnClick(View view){
        Intent intent = new Intent();
        intent.putExtra("tourName", this.tourNameData.getText());
        intent.putExtra("tourDesc", this.tourDescData.getText());
        setResult(1, intent);
        finish();
    }
}
