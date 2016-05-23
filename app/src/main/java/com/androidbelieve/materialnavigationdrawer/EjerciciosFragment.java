package com.androidbelieve.materialnavigationdrawer;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class EjerciciosFragment extends android.support.v4.app.Fragment {

    //private DBHandler db;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //this.db = db;
        //Exercise traeEjercicio = this.db.traeEjercicio(2);

        //Log.d("Llegó",traeEjercicio.toString());

        View view = inflater.inflate(R.layout.fragment_day, container, false);

        TextView ejer1 = (TextView) view.findViewById(R.id.Ejercicio1);
        ejer1.setText("hola");
        return inflater.inflate(R.layout.fragment_day,null);


    }




}

