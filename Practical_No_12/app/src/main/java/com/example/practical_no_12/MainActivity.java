package com.example.practical_no_12;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView textView,textView1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar=findViewById(R.id.ratingBar);
        textView=findViewById(R.id.textView);
        textView1=findViewById(R.id.textView1);
        button=findViewById(R.id.submitButton);
    }

    @SuppressLint("SetTextI18n")
    public void onSubmit(View view)
    {
        float ratingvalue=ratingBar.getRating();
        if(ratingvalue<2)
        {
            textView.setText("Rating "+ratingvalue+"\n is worst");
        }
        else if(ratingvalue<=3 && ratingvalue>=2)
        {
            textView.setText("Rating "+ratingvalue+"\n we will try better");
        }
        else if(ratingvalue>3 && ratingvalue<=4)
        {
            textView.setText("Rating "+ratingvalue+"\n It is good");
        }
        else if(ratingvalue>4)
        {
            textView.setText("Rating "+ratingvalue+"\n Excellent");
        }

        Toast.makeText(this, "Thanks for your Response", Toast.LENGTH_SHORT).show();
    }
}
