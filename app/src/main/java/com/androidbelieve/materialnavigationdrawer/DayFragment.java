package com.androidbelieve.materialnavigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class DayFragment extends android.support.v4.app.Fragment implements View.OnClickListener{

    ImageButton d1,d2,d3,d4;
    int rnd1 = 0, rnd2 = 0, rnd3 = 0, rnd4 = 0;
    TextView tv1, tv2, tv3, tv4;
    Exercise ex1, ex2, ex3, ex4;
    DBHandler db;
    View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_day,container, false);
        db = DBHandler.getInstance();
        if(rnd1 == 0 || rnd2 == 0 || rnd3 == 0 || rnd4 == 0)
        {
            Random r = new Random();
            rnd1 = (r.nextInt(41 - 1) + 1);

            do {
                rnd2 = (r.nextInt(41 - 1) + 1);
            }
            while (rnd1 == rnd2);

            do {

                rnd3 = (r.nextInt(41 - 1) + 1);
            }
            while (rnd3 == rnd2 || rnd3 == rnd1);

            do {

                rnd4 = (r.nextInt(41 - 1) + 1);
            }
            while (rnd4 == rnd2 || rnd4 == rnd1 || rnd4 == rnd3);
        }

        //tv1.setText(ex1.getNombre());
        /*Log.d(String.valueOf(rnd1),String.valueOf(rnd2));
        Log.d(String.valueOf(rnd3),String.valueOf(rnd4));
        Log.d(String.valueOf(rnd5),"fin");
        Intent i = new Intent(db.con,DesEjercicio_Activity.class);
        Exercise ejercicio = db.traeEjercicio(rnd1);
        String toString = ejercicio.toString();
        i.putExtra("toString",toString);
        i.putExtra("Dia","1");
        startActivity(i);*/



        d1 = (ImageButton) view.findViewById(R.id.imageButton);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // Pass the fragmentView through to the handler
                // so that findViewById can be used to get a handle on
                // the fragments own views.

                Fragment someFragment = new EjerciciosFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("id",rnd1);
                someFragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.containerView, someFragment ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });
        d2 = (ImageButton) view.findViewById(R.id.imageButton2);
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // Pass the fragmentView through to the handler
                // so that findViewById can be used to get a handle on
                // the fragments own views.

                Fragment someFragment = new EjerciciosFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.containerView, someFragment ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });

        d3 = (ImageButton) view.findViewById(R.id.imageButton3);
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // Pass the fragmentView through to the handler
                // so that findViewById can be used to get a handle on
                // the fragments own views.

                Fragment someFragment = new EjerciciosFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.containerView, someFragment ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });

        d4 = (ImageButton) view.findViewById(R.id.imageButton3);
        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // Pass the fragmentView through to the handler
                // so that findViewById can be used to get a handle on
                // the fragments own views.

                Fragment someFragment = new EjerciciosFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.containerView, someFragment ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();

            }
        });
        this.chageText();
        return view;
    }

    private void chageText() {
        ex1 = db.traeEjercicio(rnd1);
        tv1 = (TextView) view.findViewById(R.id.Ejercicio1);
        tv1.setWidth(20);
        tv1.setText((CharSequence) ex1.getNombre());

        ex2 = db.traeEjercicio(rnd2);
        tv2 = (TextView) view.findViewById(R.id.Ejercicio2);
        tv2.setWidth(20);
        tv2.setText((CharSequence) ex2.getNombre());

        ex3 = db.traeEjercicio(rnd3);
        tv3 = (TextView) view.findViewById(R.id.Ejercicio3);
        tv3.setWidth(20);
        tv3.setText((CharSequence) ex3.getNombre());

        ex4 = db.traeEjercicio(rnd4);
        tv4 = (TextView) view.findViewById(R.id.Ejercicio4);
        tv4.setWidth(20);
        tv4.setText((CharSequence) ex4.getNombre());
    }

    @Override
    public void onClick(View v) {
/*
        DBHandler db = DBHandler.getInstance();
        Log.d("estoy","Acá");
        switch (v.getId())
        {
            case R.id.imageButton:
                /*Intent myIntent = new Intent(db.con, DesEjercicio_Activity.class);
                startActivity(myIntent);
                Log.d("Entré","");
                break;
            case R.id.button6:
                break;
        }
*/
    }
}
