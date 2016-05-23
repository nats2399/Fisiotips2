package com.androidbelieve.materialnavigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class EjerciciosFragment extends android.support.v4.app.Fragment implements OnClickListener {

    Button d1,d2,d3,d4,d5;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View myView = inflater.inflate(R.layout.fragment_ejercicios,null);
        d1 = (Button) myView.findViewById(R.id.button5);
        d1.setOnClickListener(this);

        Bundle bundle = getArguments();
        int id = bundle.getInt("id");
        Log.d("id",String.valueOf(id));
        /*d2 = (Button) myView.findViewById(R.id.button6);
        d2.setOnClickListener(this);

        d3 = (Button) myView.findViewById(R.id.button7);
        d3.setOnClickListener(this);

        d4 = (Button) myView.findViewById(R.id.button8);
        d4.setOnClickListener(this);

        d5 = (Button) myView.findViewById(R.id.button9);
        d5.setOnClickListener(this);*/
        return myView;
    }


    @Override
    public void onClick(View v) {
        DBHandler db = DBHandler.getInstance();
        switch (v.getId())
        {
            case R.id.button5:
                Fragment someFragment = new DayFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.containerView, someFragment ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
                break;

            case R.id.button6:
                break;
        }
    }
}

