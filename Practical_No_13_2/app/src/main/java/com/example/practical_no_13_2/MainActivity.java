package com.example.practical_no_13_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    int progressStatusCounter=0;
    TextView textView;
    Handler progressHandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.horizontalProgressBar);
        textView=findViewById(R.id.textView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatusCounter<100)
                {
                    progressStatusCounter+=2;
                    progressHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatusCounter);
                            textView.setText("Status : "+progressStatusCounter+"/"+progressBar.getMax());
                        }
                    });
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
