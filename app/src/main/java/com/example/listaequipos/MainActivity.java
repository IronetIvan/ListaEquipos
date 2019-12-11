package com.example.listaequipos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.listaequipos.paquetes.AdaptadorLigas;
import com.example.listaequipos.utils.liga;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recylerLigas, recylerEquipos;
    AdaptadorLigas adaptadorLigas;
    ArrayList<liga> listaLiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        configRecyclerLigas();
        rellenarLigas();
        acciones();
    }

    private void acciones() {
    }

    private void rellenarLigas() {
        listaLiga.add(new liga("La Liga", R.drawable.laliga));
        listaLiga.add(new liga("Premier", R.drawable.premiere));
        listaLiga.add(new liga("Serie A", R.drawable.calcio));
        adaptadorLigas.notifyDataSetChanged();
    }

    private void configRecyclerLigas() {
        recylerLigas.setAdapter(adaptadorLigas);
        recylerLigas.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
    }

    private void instancias() {
        recylerEquipos = findViewById(R.id.recyclerEquipos);
        recylerLigas = findViewById(R.id.recyclerLigas);
        listaLiga = new ArrayList();
        adaptadorLigas = new AdaptadorLigas(listaLiga, getApplicationContext());
    }

}
