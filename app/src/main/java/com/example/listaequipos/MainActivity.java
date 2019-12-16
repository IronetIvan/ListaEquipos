package com.example.listaequipos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.listaequipos.paquetes.AdaptadorEquipos;
import com.example.listaequipos.paquetes.AdaptadorLigas;
import com.example.listaequipos.utils.DataSet;
import com.example.listaequipos.utils.Equipo;
import com.example.listaequipos.utils.liga;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorLigas.OnLigaListener {
    RecyclerView recylerLigas, recylerEquipos;
    AdaptadorLigas adaptadorLigas;
    ArrayList<liga> listaLiga;
    ArrayList<Equipo> listaEquipos;
    AdaptadorEquipos adaptadorEquipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        configRecyclerLigas();
        configRecycledEquipos();
        acciones();
    }

    private void configRecycledEquipos() {
        recylerEquipos.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recylerEquipos.setAdapter(adaptadorEquipos);
    }

    private void acciones() {
    }


    private void configRecyclerLigas() {
        recylerLigas.setAdapter(adaptadorLigas);
        recylerLigas.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
    }

    private void instancias() {
        recylerEquipos = findViewById(R.id.recyclerEquipos);
        recylerLigas = findViewById(R.id.recyclerLigas);
        listaLiga = DataSet.newInstance().getLigas();
        listaEquipos = new ArrayList<>();
        adaptadorLigas = new AdaptadorLigas(listaLiga, MainActivity.this);
        adaptadorEquipos = new AdaptadorEquipos(listaEquipos, MainActivity.this);

    }

    @Override
    public void onLigaSelected(liga liga) {

        switch (liga.getNombre()){
            case "La Liga":
                listaEquipos = DataSet.newInstance().getEquiposEsp();
                break;
            case "Serie A":
                    listaEquipos = DataSet.newInstance().getEquiposIta();
                break;

            case "Premier":
                listaEquipos = DataSet.newInstance().getEquiposPremier();
                break;

        }
        adaptadorEquipos = new AdaptadorEquipos(listaEquipos,MainActivity.this );
        recylerEquipos.setAdapter(adaptadorEquipos);
    }
}
