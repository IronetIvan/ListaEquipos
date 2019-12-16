package com.example.listaequipos.paquetes;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listaequipos.R;
import com.example.listaequipos.utils.Equipo;

import java.util.ArrayList;

public class AdaptadorEquipos extends RecyclerView.Adapter<AdaptadorEquipos.MiHolder> {

    ArrayList<Equipo> lista;
    Context context;

    public AdaptadorEquipos(ArrayList<Equipo> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemequipo_layout,parent,false);
        MiHolder holder = new MiHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {

        final Equipo equipo = lista.get(position);
        holder.getImagen().setImageResource(equipo.getEscudo());
        holder.getNombre().setText(equipo.getNombre());



    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MiHolder extends RecyclerView.ViewHolder{

        TextView nombre;
        ImageView imagen;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textoEquipo);
            imagen = itemView.findViewById(R.id.imagenEquipo);
        }

        public TextView getNombre() {
            return nombre;
        }

        public ImageView getImagen() {
            return imagen;
        }
    }
}
