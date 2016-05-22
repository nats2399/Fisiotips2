package com.androidbelieve.materialnavigationdrawer;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class DesEjerciciosFragment extends Fragment {
    private ArrayList <Drawable> imagencitas;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState,
                             String descr, String tip, String imagen)
    {
        final View view = inflater.inflate(R.layout.fragment_desejercicio, container, false);
        TextView tvDes = (TextView) view.findViewById(R.id.descripcion);

        int height_in_pixels = tvDes.getLineCount() * tvDes.getLineHeight(); //approx height text
        tvDes.setHeight(height_in_pixels);

        TextView tvTip = (TextView) view.findViewById(R.id.tip);

        tvTip.setHeight(height_in_pixels);

        tvDes.setText(descr);
        tvTip.setText(tip);


        ImageView imageVw = (ImageView) view.findViewById(R.id.imageEx);


        return inflater.inflate(R.layout.fragment_welcome,null);

    }

}
