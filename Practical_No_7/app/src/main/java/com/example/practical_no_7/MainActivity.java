package com.example.practical_no_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button b1,b2,b3;
    TextView txt1;
    String fileName="LabFile.txt";
    String message;
    FileOutputStream fos;
    FileInputStream fin;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.edt1);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        txt1=findViewById(R.id.txtVw);

        b2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        message=e1.getText().toString();
                        try {
                            fos=openFileOutput(fileName,MODE_PRIVATE);
                            fos.write(message.getBytes());
                            fos.close();
                            Toast.makeText(MainActivity.this, "File Written and Saved Successfully!", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            fin=openFileInput(fileName);
                            int c;
                            String temp="";
                            while((c=fin.read())!=1)
                            {
                                temp=temp+ Character.toString((char) c);
                            }
                            txt1.setText(temp);
                            Toast.makeText(MainActivity.this, "File Read and Saved Successfully!", Toast.LENGTH_SHORT).show();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        b3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        file=new File(getFilesDir(),fileName);
                        if(file.exists())
                        {
                            deleteFile(fileName);
                            Toast.makeText(MainActivity.this, "File Deleted Successfully!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "File does not exist!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }
}
