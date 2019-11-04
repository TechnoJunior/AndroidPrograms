package com.example.practical_no_4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button Login;
    private EditText Name,Password;
    private TextView Info;
    private int counter=3;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=findViewById(R.id.etName);
        Password=findViewById(R.id.etPassword);

        Login=findViewById(R.id.btnLogin);
        Info=findViewById(R.id.tvInfo);

        Info.setText("No of attempts remaining : "+counter);

        Login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        validate(Name.getText().toString(),Password.getText().toString());
                    }
                }
        );
    }
    private void validate(String UserName,String PassWord)
    {
        if(UserName.equals("admin") && PassWord.equals("admin"))
        {
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        else
        {
            counter--;
            Info.setText("No of attempts remaining : "+counter);
            if(counter==0)
            {
                Login.setEnabled(false);
            }
        }
    }
}
