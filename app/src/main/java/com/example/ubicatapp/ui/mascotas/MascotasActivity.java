package com.example.ubicatapp.ui.mascotas;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ubicatapp.R;
import com.example.ubicatapp.api.ApiClient;
import com.example.ubicatapp.models.Mascota;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MascotasActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_mascotas);

        rv = findViewById(R.id.rvMascotas);

        rv.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences sp = getSharedPreferences("ubicat", MODE_PRIVATE);
        String token = sp.getString("token","");



        ApiClient.getMyApiClient().misMascotas("Bearer " + token).enqueue(new Callback<List<Mascota>>() {
            @Override
            public void onResponse(Call<List<Mascota>> call, Response<List<Mascota>> response) {
                List<Mascota> lista = response.body();
                rv.setAdapter(new MascotaAdapter(lista));

            }

            @Override
            public void onFailure(Call<List<Mascota>> call, Throwable t) { }
        });
    }
}