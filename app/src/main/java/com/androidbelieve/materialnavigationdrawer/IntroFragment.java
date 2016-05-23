package com.androidbelieve.materialnavigationdrawer;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class IntroFragment extends android.support.v4.app.Fragment {

    Button d1;
    Button d2;
    Intent intent1;
    Intent intent2;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View myView = inflater.inflate(R.layout.fragment_intro,null);

        intent1 = new Intent(getActivity(), intro2.class);

        d1 = (Button) myView.findViewById(R.id.button2);
        d1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent1);
            }
        });


        intent2 = new Intent(getActivity(), intro1.class);

        d2 = (Button) myView.findViewById(R.id.button);
        d2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent2);
            }
        });

        return myView;

    }





}
