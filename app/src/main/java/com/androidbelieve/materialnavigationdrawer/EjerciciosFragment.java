package com.androidbelieve.materialnavigationdrawer;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class EjerciciosFragment extends android.support.v4.app.Fragment {

    private DBHandler db;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, DBHandler db)
    {
        this.db = db;
        Exercise traeEjercicio = this.db.traeEjercicio(2);

        Log.d("Llegó",traeEjercicio.toString());
        return inflater.inflate(R.layout.fragment_ejercicios,null);


    }




}

