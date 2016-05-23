package com.androidbelieve.materialnavigationdrawer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class DesEjerciciosFragment extends Fragment {
    private ArrayList <Drawable> imagencitas;
    String myInt;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState,
                             String descr, String tip, String imagen)
    {


        return inflater.inflate(R.layout.fragment_welcome,null);

    }

}
