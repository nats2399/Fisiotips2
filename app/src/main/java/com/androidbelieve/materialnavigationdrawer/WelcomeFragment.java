package com.androidbelieve.materialnavigationdrawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WelcomeFragment extends android.support.v4.app.Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        TextView tv = (TextView) view.findViewById(R.id.textView2);
        int height_in_pixels = tv.getLineCount() * tv.getLineHeight(); //approx height text
        tv.setHeight(height_in_pixels);

        return inflater.inflate(R.layout.fragment_welcome,null);

    }

}
