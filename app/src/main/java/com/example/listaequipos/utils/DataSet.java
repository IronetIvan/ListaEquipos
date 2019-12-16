package com.example.listaequipos.utils;

import android.provider.ContactsContract;

import com.example.listaequipos.R;

import java.util.ArrayList;

public class DataSet {

    public static DataSet newInstance(){
        DataSet dataSet = new DataSet();
        return dataSet;
    }

    public ArrayList getLigas(){
        ArrayList datos = new ArrayList();
        datos.add(new liga("La Liga", R.drawable.laliga));
        datos.add(new liga("Premier", R.drawable.premiere));
        datos.add(new liga("Serie A", R.drawable.calcio));

        return datos;
    }
    public ArrayList getEquiposEsp(){
        ArrayList datos = new ArrayList();
        datos.add(new Equipo("Real Madrid", R.drawable.madrid));
        datos.add(new Equipo("Barca", R.drawable.barsa));
        return datos;
    }
    public ArrayList getEquiposPremier(){
        ArrayList datos = new ArrayList();
        datos.add(new Equipo("Liverpool", R.drawable.liverpool));
        datos.add(new Equipo("Manchester", R.drawable.manchester));
        return datos;
    }
    public ArrayList getEquiposIta(){
        ArrayList datos = new ArrayList();
        datos.add(new Equipo("Juventus", R.drawable.juventus));
        datos.add(new Equipo("Inter Milan", R.drawable.inter));
        return datos;
    }
}
