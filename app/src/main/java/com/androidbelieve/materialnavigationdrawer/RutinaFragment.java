package com.androidbelieve.materialnavigationdrawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class RutinaFragment extends android.support.v4.app.Fragment {

    DBHandler db;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState,DBHandler db)
    {
        this.db = db;
        return inflater.inflate(R.layout.fragment_rutina,null);

    }




}
