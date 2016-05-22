package com.androidbelieve.materialnavigationdrawer;

import android.graphics.Matrix;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class estiramientoimagen extends AppCompatActivity {

    ScaleGestureDetector SGD;
    ImageView img;
    Matrix matrix;
    Float scale = 1f;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estiramientoimagen);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        img = (ImageView) findViewById(R.id.imageViewestira);
        matrix = new Matrix();
        SGD = new ScaleGestureDetector(this, new ScaleListener());

    }



    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener
    {
        public boolean onScale(ScaleGestureDetector detector)
        {
            scale = scale * detector.getScaleFactor();
            scale = Math.max(0.1f,Math.min(scale,5f));
            matrix.setScale(scale,scale);
            img.setImageMatrix(matrix);
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        SGD.onTouchEvent(event);
        return true;
    }


    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "estiramientoimagen Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.androidbelieve.materialnavigationdrawer/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }


    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "estiramientoimagen Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.androidbelieve.materialnavigationdrawer/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
