package com.lyl.net;

import android.os.Handler;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by $lyl on 2017/10/21.
 */

public class NetThread extends Thread{

    private String url;
    private WebView mWebView;
    private Handler mHandler;

   NetThread(String url,WebView webView ,Handler handler){
       this.url = url;
       this.mWebView = webView;
       this.mHandler = handler;
   }

    @Override
    public void run() {

        try {
            mWebView.getSettings().setJavaScriptEnabled(true);
            URL httpUrl = new URL(url);
            HttpURLConnection  conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setReadTimeout(5000);
            conn.setRequestMethod("GET");
            final StringBuffer stringBuffer = new StringBuffer();

            BufferedReader reader = new BufferedReader( new InputStreamReader(conn.getInputStream()));
            String str;
            while ((str = reader.readLine()) != null){
                stringBuffer.append(str);
            }

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mWebView.loadDataWithBaseURL(url,stringBuffer.toString(),
                                      "text/html","charset=utf-8",null);
                }
            });

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
