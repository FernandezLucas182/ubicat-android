package com.example.ubicatapp.ui.login;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ubicatapp.R;
import com.example.ubicatapp.api.ApiClient;
import com.example.ubicatapp.models.LoginResponse;
import com.example.ubicatapp.ui.mascotas.MascotasActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPass;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> login());
    }

    private void login() {

        String email = etEmail.getText().toString();
        String pass  = etPass.getText().toString();

        ApiClient.getMyApiClient()
                .login(email, pass)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()) {

                            String token = response.body().getToken();

                            SharedPreferences sp = getSharedPreferences("ubicat", MODE_PRIVATE);
                            sp.edit().putString("token", token).apply();

                            startActivity(new Intent(LoginActivity.this, MascotasActivity.class));
                            finish();
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Credenciales inválidas", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

}
