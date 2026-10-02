package com.example.ubicatapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ubicatapp.R;
import com.example.ubicatapp.ui.login.LoginActivity;
import com.example.ubicatapp.ui.mascotas.MascotasActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnMisMascotas;
    private Button btnRegistrarMascota;
    private Button btnEscanearQR;
    private Button btnReportar;
    private Button btnPerfil;
    private Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnMisMascotas = findViewById(R.id.btnMisMascotas);
        btnRegistrarMascota = findViewById(R.id.btnRegistrarMascota);
        btnEscanearQR = findViewById(R.id.btnEscanearQR);
        btnReportar = findViewById(R.id.btnReportar);
        btnPerfil = findViewById(R.id.btnPerfil);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        btnMisMascotas.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    MascotasActivity.class
            );

            startActivity(intent);
        });

        btnRegistrarMascota.setOnClickListener(v -> {
            // Lo implementamos después
        });

        btnEscanearQR.setOnClickListener(v -> {
            // Lo implementamos después
        });

        btnReportar.setOnClickListener(v -> {
            // Lo implementamos después
        });

        btnPerfil.setOnClickListener(v -> {
            // Lo implementamos después
        });

        btnCerrarSesion.setOnClickListener(v -> {

            SharedPreferences sp =
                    getSharedPreferences("ubicat", MODE_PRIVATE);

            sp.edit()
                    .remove("token")
                    .apply();

            Intent intent = new Intent(
                    MainActivity.this,
                    LoginActivity.class
            );

            startActivity(intent);

            finish();
        });
    }
}