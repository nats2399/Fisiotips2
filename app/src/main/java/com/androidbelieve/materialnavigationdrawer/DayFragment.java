package com.androidbelieve.materialnavigationdrawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class DayFragment extends android.support.v4.app.Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_day, container, false);
        TextView ejer1 = (TextView) view.findViewById(R.id.Ejercicio1);
        ejer1.setText("hola");
        return inflater.inflate(R.layout.fragment_day,null);
    ImageButton d1,d2,d3,d4;
    int rnd1 = 0, rnd2 = 0, rnd3 = 0, rnd4 = 0;
    TextView tv1, tv2, tv3, tv4;
    Exercise ex1, ex2, ex3, ex4;
    DBHandler db;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View fragmentView = inflater.inflate(R.layout.fragment_day,
                container, false);
        db = DBHandler.getInstance();
        if(rnd1 == 0 || rnd2 == 0 || rnd3 == 0 || rnd4 == 0)
        {
            Random r = new Random();
            rnd1 = (r.nextInt(41 - 1) + 1);

            do {
                rnd2 = (r.nextInt(41 - 1) + 1);
            }
            while (rnd1 == rnd2);

    }




}

