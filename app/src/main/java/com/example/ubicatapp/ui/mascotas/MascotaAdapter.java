package com.example.ubicatapp.ui.mascotas;

import android.util.Log;
import android.view.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ubicatapp.R;
import com.example.ubicatapp.models.Mascota;
import java.util.List;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.ViewHolder> {

    List<Mascota> lista;

    public MascotaAdapter(List<Mascota> lista) {
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mascota, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder h, int i) {
        Mascota m = lista.get(i);

        h.txtNombre.setText(m.getNombre());
        h.txtEstado.setText(m.getEstado());

        String urlFoto = m.getFotoUrl();

        Log.d("IMG_URL", "urlFoto = " + urlFoto);

        if (urlFoto != null && !urlFoto.trim().isEmpty()) {

            Glide.with(h.imgMascota.getContext())
                    .load(urlFoto)
                    .placeholder(R.drawable.ic_pet)
                    .error(R.drawable.ic_pet)
                    .into(h.imgMascota);

        } else {
            h.imgMascota.setImageResource(R.drawable.ic_pet);
        }
    }




    @Override
    public int getItemCount() { return lista.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre, txtEstado;
        ImageView imgMascota;

        public ViewHolder(View v) {
            super(v);
            txtNombre = v.findViewById(R.id.txtNombre);
            txtEstado = v.findViewById(R.id.txtEstado);
            imgMascota = v.findViewById(R.id.imgMascota);
        }
    }

}