package com.example.practical_no_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button button;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        button=findViewById(R.id.button);
        sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);

        //if SharedPerferences have username and password

        if(sharedPreferences.contains("username") && sharedPreferences.contains("passworrd"))
        {
            Intent intent=new Intent(MainActivity.this,Home.class);
            startActivity(intent);
            finish();
        }

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loginCheck();
                    }
                }
        );
    }

    private void loginCheck()
    {
        //check username and password
        if(username.getText().toString().equals("Programmer") && password.getText().toString().equals("Programmer"))
        {
            SharedPreferences.Editor edit=sharedPreferences.edit();
            edit.putString("username","Programmer");
            edit.putString("password","Programmer");
            edit.commit();
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,Home.class));
            finish();
        }
        else
        {
            Toast.makeText(this, "Incorrect Login Details", Toast.LENGTH_SHORT).show();
        }
    }
}
