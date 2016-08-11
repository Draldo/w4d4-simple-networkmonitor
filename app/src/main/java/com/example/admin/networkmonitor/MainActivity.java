package com.example.admin.networkmonitor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "TAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                Snackbar.make(view, "Connected to WIFI", Snackbar.LENGTH_LONG).show();
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                Snackbar.make(view, "Connected to Mobile Network", Snackbar.LENGTH_LONG).show();
            }
        } else {
            Snackbar.make(view, "Not Connected at all", Snackbar.LENGTH_LONG).show();
        }
    }
}
