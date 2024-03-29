package com.example.practical_no_8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    String[] listItem;
    ArrayAdapter<String> adapter;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        listItem=getResources().getStringArray(R.array.array_technology);

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,listItem);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String value=adapter.getItem(position);
                        Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
