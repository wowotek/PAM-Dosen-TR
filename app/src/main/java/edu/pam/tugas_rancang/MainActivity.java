package edu.pam.tugas_rancang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.provider.FontRequest;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, BudgetManagementActivity.class);
        Intent resultIntent = new Intent();
        setResult(1, resultIntent);
        MainActivity.this.startActivity(intent);
        finish();
    }
}
