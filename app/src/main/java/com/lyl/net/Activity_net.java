package com.lyl.net;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.lyl.administrator.lyl.R;

public class Activity_net extends AppCompatActivity {

    private WebView webView;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);

        webView = (WebView) findViewById(R.id.webView);
        handler = new Handler();
        new NetThread("https://www.baidu.com",webView,handler).start();
    }
}
