package com.example.practical_no_11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText inpuText;
    TextView response;
    Button saveButton,readButton;
    private String filename="SampleFile.txt";
    private String filepath="MyFileStorage";
    File myExternalFile;
    String myData="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inpuText = findViewById(R.id.myInputText);
        response = findViewById(R.id.response);
        saveButton = findViewById(R.id.saveExternalStorage);

        saveButton.setOnClickListener(
                new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View v) {
                        try {
                            FileOutputStream fos = new FileOutputStream(myExternalFile);
                            fos.write(inpuText.getText().toString().getBytes());
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        inpuText.setText("");
                        response.setText("SampleFile.txt saved to External Storage....");
                    }
                }
        );

        readButton = findViewById(R.id.getExternalStorage);
        readButton.setOnClickListener(
                new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View v) {
                        FileInputStream fis = null;
                        try {
                            fis = new FileInputStream(myExternalFile);

                            DataInputStream in = new DataInputStream(fis);
                            BufferedReader br = new BufferedReader(new InputStreamReader(in));
                            String strLine;

                            while ((strLine = br.readLine()) != null) {
                                myData = myData + strLine;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        inpuText.setText(myData);
                        response.setText("SampleFile.txt data retrieved from Internal Storage...");
                    }
                }
        );

        if(!isExternalStorageAvailable()||isExternalStorageReadOnly())
        {
            saveButton.setEnabled(false);
        }
        else
        {
            myExternalFile=new File(getExternalFilesDir(filepath),filename);
        }
    }

    private static boolean isExternalStorageReadOnly(){
        String extStorageState= Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState))
        {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable(){
        String exStorageState=Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(exStorageState)){
            return true;
        }
        return false;
    }
}
