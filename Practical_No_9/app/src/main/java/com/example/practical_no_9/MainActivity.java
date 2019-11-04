package com.example.practical_no_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnEnter;
    EditText edURLName;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnter=findViewById(R.id.button);
        edURLName=findViewById(R.id.ed_URL_Name);
        webView=findViewById(R.id.webview);

        webView.setWebViewClient(new MyBrowser());
        btnEnter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url=edURLName.getText().toString();
                        webView.getSettings().setLoadsImagesAutomatically(true);
                        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                        webView.loadUrl(url);
                    }
                }
        );
    }
}
