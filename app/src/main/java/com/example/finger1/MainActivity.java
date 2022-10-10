package com.example.finger1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private PermissionsDelegate permissionsDelegate = new PermissionsDelegate(this);;
    private boolean hasPermission = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (OpenCVLoader.initDebug()) {
            Log.d(TAG, "Open CV LOADEDDDDDDDDD");
        } else {
            Log.d(TAG, "Open CV FAILEEEEEEEDDD");
        }

        hasPermission = permissionsDelegate.hasPermissions();
        if (!hasPermission) {
            permissionsDelegate.requestPermissions();
        }
    }
}