package com.example.practical_no_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Life Cycle","OnCreate Method Called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Life Cycle","OnStart Method Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Life Cycle","OnResume Method Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Life Cycle","OnPause Method Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Life Cycle","OnStop Method Called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Life Cycle","OnRestart Method Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Life Cycle","OnDestroy Method Called");
    }
}
