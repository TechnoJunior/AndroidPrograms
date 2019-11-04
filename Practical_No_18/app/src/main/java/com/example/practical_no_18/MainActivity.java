package com.example.practical_no_18;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnExpand, btnRotate, btnMove;
    Animation animExpand, animRotate, animMove;
    ImageView imageView;
    private Bitmap bmp;
    private Bitmap operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExpand=findViewById(R.id.btnExpand);
        btnRotate=findViewById(R.id.btnRotate);
        btnMove=findViewById(R.id.btnMove);

        imageView=findViewById(R.id.imageView);
        BitmapDrawable abmp= (BitmapDrawable) imageView.getDrawable();
        bmp=abmp.getBitmap();

        //Expand
        animExpand= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.expand);
        btnExpand.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.setVisibility(View.VISIBLE);
                        imageView.startAnimation(animExpand);
                    }
                }
        );

        //Rotate
        animRotate=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        btnRotate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.startAnimation(animRotate);
                    }
                }
        );

        //Move
        animMove=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        btnMove.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.startAnimation(animMove);
                    }
                }
        );
    }
}
