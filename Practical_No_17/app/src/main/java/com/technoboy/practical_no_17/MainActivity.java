package com.technoboy.practical_no_17;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView=findViewById(R.id.videoView);
        play=findViewById(R.id.button);

        play.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String videopath="android.resource://com.technoboy.practical_no_17/"+R.raw.waterfall;
                        Uri uri= Uri.parse(videopath);
                        videoView.setVideoURI(uri);
                        videoView.start();
                        Toast.makeText(MainActivity.this, "Playing Video", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
