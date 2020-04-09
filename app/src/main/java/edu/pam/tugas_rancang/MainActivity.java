package edu.pam.tugas_rancang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.provider.FontRequest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.pam.tugas_rancang.api.EndPoints;
import edu.pam.tugas_rancang.api.LoginResponse;
import edu.pam.tugas_rancang.api.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    Button loginButton;

    Retrofit retrofit;
    EndPoints endPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.login_username_input);
        passwordInput = findViewById(R.id.login_password_input);
        loginButton = findViewById(R.id.login_login_button);

        retrofit = RetrofitClient.getRetrofitclient();
        endPoints = retrofit.create(EndPoints.class);

////        Intent intent = new Intent(MainActivity.this, BudgetManagementActivity.class);
////        Intent resultIntent = new Intent();
////        setResult(1, resultIntent);
////        MainActivity.this.startActivity(intent);
////        finish();
    }

    public void loginOnClick(View view){
        endPoints.login(usernameInput.getText().toString(), passwordInput.getText().toString()).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Toast.makeText(MainActivity.this, response.body().getMsg(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}
