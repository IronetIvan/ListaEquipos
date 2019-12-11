package com.example.listaequipos.paquetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listaequipos.R;
import com.example.listaequipos.utils.liga;

import java.util.List;

public class AdaptadorLigas extends RecyclerView.Adapter<AdaptadorLigas.miHolder> {
    List<liga> listaLigas;
    Context context;
    OnLigaListener listener;

    public AdaptadorLigas(List<liga> listaLigas, Context context) {
        this.listaLigas = listaLigas;
        this.context = context;
    }

    @NonNull
    @Override
    public miHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemliga_layout, parent, false);
        miHolder holder = new miHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull miHolder holder, int position) {
        final liga liga = listaLigas.get(position);
        holder.getImagenLiga().setImageResource(liga.getLogo());
        holder.getTextoLiga().setText(liga.getNombre());
        holder.getTextoLiga().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onLigaSelected(liga);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaLigas.size();
    }

    public interface OnLigaListener{
        void onLigaSelected(liga liga);
    }

    class miHolder extends RecyclerView.ViewHolder{

        private ImageView imagenLiga;
        private TextView textoLiga;

        public miHolder(@NonNull View itemView) {
            super(itemView);
            imagenLiga = itemView.findViewById(R.id.imagenLiga);
            textoLiga = itemView.findViewById(R.id.textoLiga);
        }

        public ImageView getImagenLiga() {
            return imagenLiga;
        }

        public TextView getTextoLiga() {
            return textoLiga;
        }
    }
}
