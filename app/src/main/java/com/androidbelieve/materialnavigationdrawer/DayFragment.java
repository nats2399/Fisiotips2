package com.androidbelieve.materialnavigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;


public class DayFragment extends android.support.v4.app.Fragment implements View.OnClickListener{

    ImageButton d1,d2,d3,d4,d5;
    int rnd1, rnd2, rnd3, rnd4, rnd5;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d("entré", "frag");
        Random r = new Random();
        rnd1 = (r.nextInt(41 - 1) + 1);

        do {
            rnd2 = (r.nextInt(41 - 1) + 1);
        }
        while (rnd1 == rnd2);

        do {
            Log.d("entré", "wh2");
            rnd3 = (r.nextInt(41 - 1) + 1);
        }
        while (rnd3 == rnd2 || rnd3 == rnd1);

        do {
            Log.d("entré", "wh3");
            rnd4 = (r.nextInt(41 - 1) + 1);
        }
        while (rnd4 == rnd2 || rnd4 == rnd1 || rnd4 == rnd3);

        do {
            Log.d("entré", "wh4");
            rnd5 = (r.nextInt(41 - 1) + 1);
        }
        while (rnd5 == rnd2 || rnd5 == rnd1 || rnd5 == rnd3 || rnd5 == rnd4);
        /*Log.d(String.valueOf(rnd1),String.valueOf(rnd2));
        Log.d(String.valueOf(rnd3),String.valueOf(rnd4));
        Log.d(String.valueOf(rnd5),"fin");
        Intent i = new Intent(db.con,DesEjercicio_Activity.class);
        Exercise ejercicio = db.traeEjercicio(rnd1);
        String toString = ejercicio.toString();
        i.putExtra("toString",toString);
        i.putExtra("Dia","1");
        startActivity(i);*/

        final View fragmentView = inflater.inflate(R.layout.fragment_day,
                container, false);

        d1 = (ImageButton) fragmentView.findViewById(R.id.imageButton);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // Pass the fragmentView through to the handler
                // so that findViewById can be used to get a handle on
                // the fragments own views.

                Intent i = new Intent(v.getContext(),DesEjercicio_Activity.class);
                //Exercise ejercicio = db.traeEjercicio(rnd1);
                /*String toString = ejercicio.toString();
                i.putExtra("toString",toString);
                i.putExtra("Dia","1");*/
                startActivity(i);
            }
        });
        return fragmentView;
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

