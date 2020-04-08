package edu.pam.tugas_rancang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTripActivity extends AppCompatActivity {

    /* Widgets */
    EditText tripNameData;
    EditText tripDescData;
    Button tripAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        this.tripNameData = findViewById(R.id.trip_name_input);
        this.tripDescData = findViewById(R.id.trip_desc_input);
        this.tripAddButton = findViewById(R.id.trip_add_button);
    }

    public void tripAddOnClick(View view){
        Intent intent = new Intent();
        intent.putExtra("tripNameExtra", this.tripNameData.getText().toString());
        intent.putExtra("tripDescExtra", this.tripDescData.getText().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
