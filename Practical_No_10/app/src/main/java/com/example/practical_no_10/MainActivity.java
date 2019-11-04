package com.example.practical_no_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    GridView gridViews;
    String[] numbersArray;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViews=findViewById(R.id.gv);
        numbersArray=new String[]{
                "One","Tow","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen"
        };

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,numbersArray);
        gridViews.setAdapter(adapter);
        gridViews.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String clickedItemValue= Arrays.asList(numbersArray).get(position);
                        Toast.makeText(MainActivity.this, "Position : "+position+" Value : "+clickedItemValue, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
