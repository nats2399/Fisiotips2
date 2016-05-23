package com.androidbelieve.materialnavigationdrawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DayFragment extends android.support.v4.app.Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_day, container, false);
        TextView ejer1 = (TextView) view.findViewById(R.id.Ejercicio1);
        ejer1.setText("hola");
        return inflater.inflate(R.layout.fragment_day,null);

    }




}

