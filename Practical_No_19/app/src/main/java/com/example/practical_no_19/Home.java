package com.example.practical_no_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout=findViewById(R.id.logout);
        logout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
                        SharedPreferences.Editor e=sharedPreferences.edit();
                        e.clear();
                        e.commit();

                        startActivity(new Intent(Home.this,MainActivity.class));
                        finish();
                    }
                }
        );
    }
}
