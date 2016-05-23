package com.androidbelieve.materialnavigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class RutinaFragment extends android.support.v4.app.Fragment {

    Intent intent,intent1,intent2;
    Button d1,d2;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View myView =  inflater.inflate(R.layout.fragment_rutina,null);
        intent1 = new Intent(getActivity(), calentamiento.class);

        d1 = (Button) myView.findViewById(R.id.button3);
        d1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent1);
            }
        });


        intent2 = new Intent(getActivity(), estiramientos.class);

        d2 = (Button) myView.findViewById(R.id.button4);
        d2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent2);
            }
        });

        return myView;
    }
}
