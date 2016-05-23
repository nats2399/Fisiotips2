package com.androidbelieve.materialnavigationdrawer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static com.androidbelieve.materialnavigationdrawer.R.layout.fragment_ejercicios;


public class EjerciciosFragment extends android.support.v4.app.Fragment {

    private DBHandler db;

    View view;

    ImageView img;

    TextView tv1, tv2, tv3;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        this.db = DBHandler.getInstance();

        view = inflater.inflate(fragment_ejercicios, container, false);

        Bundle bundle = getArguments();
        int id = bundle.getInt("id");




        Exercise traeEjercicio = this.db.traeEjercicio(id);

        this.cambiaTexto(traeEjercicio, db.con);
        return view;


    }

    private void cambiaTexto(Exercise ex1, Context context) {

        tv1 = (TextView) view.findViewById(R.id.textView5);
        tv1.setWidth(20);
        tv1.setText((CharSequence) ex1.getNombre());

        tv2 = (TextView) view.findViewById(R.id.textView6);
        tv2.setWidth(20);
        tv2.setText((CharSequence) ex1.getDes());

        tv3 = (TextView) view.findViewById(R.id.textView7);
        tv3.setWidth(30);
        tv3.setText((CharSequence) "Tip:"+ex1.getTip());

        int resID = getResources().getIdentifier(ex1.getImg() , "drawable", context.getPackageName());
        img = (ImageView) view.findViewById(resID);

    }



}

