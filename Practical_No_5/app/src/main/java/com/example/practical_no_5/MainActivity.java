package com.example.practical_no_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    float a;
    EditText usd,bdt;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usd=findViewById(R.id.usd);
        bdt=findViewById(R.id.bdt);
        usd.setInputType(InputType.TYPE_CLASS_NUMBER);
        bdt.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    void convertUsdToBdt()
    {
        double a=Integer.parseInt(usd.getText().toString());
        double result=a*73;
        bdt.setText(String.valueOf(result));
    }

    void convertBdtToUsd()
    {
        double a=Integer.parseInt(bdt.getText().toString());
        double result=a/73;
        usd.setText(String.valueOf(result));
    }

    public void reset(View view)
    {
        usd.setText("");
        bdt.setText("");
    }

    public void click(View view)
    {
        convertUsdToBdt();
    }
    public void click2(View view)
    {
        convertBdtToUsd();
    }
}
