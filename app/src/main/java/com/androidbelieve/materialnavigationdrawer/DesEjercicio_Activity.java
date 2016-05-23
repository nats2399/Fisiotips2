package com.androidbelieve.materialnavigationdrawer;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class DesEjercicio_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Intent myIntent = getIntent();
        String firstKeyName = myIntent.getStringExtra("toString"); // will return "FirstKeyValue"
        String secondKeyName= myIntent.getStringExtra("Dia"); // will return "SecondKeyValue"
        Log.d(firstKeyName,secondKeyName);*/

        setContentView(R.layout.activity_des_ejercicio_);
    }



}
