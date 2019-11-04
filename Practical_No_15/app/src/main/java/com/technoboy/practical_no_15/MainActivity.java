package com.technoboy.practical_no_15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    dbhelper db;
    EditText name,house;
    Button show,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new dbhelper(this);
        name=findViewById(R.id.gotname);
        house=findViewById(R.id.gothouse);
        show=findViewById(R.id.btnshow);
        add=findViewById(R.id.btninsert);

        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean result = db.add(name.getText().toString().trim(), house.getText().toString());
                        if(result==true)
                        {
                            message("Success","Data Inserted Successfully");
                        }
                        else
                        {
                            message("Error","Unable to Insert Data");
                        }
                    }
                }
        );

        show.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor data=db.show();
                        if(data.getCount()==0)
                        {
                            message("Error","No data found in Database");
                        }
                        StringBuffer bufferdata=new StringBuffer();
                        while (data.moveToNext())
                        {
                            bufferdata.append(data.getString(0)+" --> "+data.getString(1)+" --> "+data.getString(2)+"\n");
                        }
                        message("Data",bufferdata.toString());
                    }
                }
        );
    }

    public void message(String Title,String Message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true)
                .setTitle(Title)
                .setMessage(Message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
