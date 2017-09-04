package com.forrest.test.leaktest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Lenovo on 2017/9/1.
 */

public class OtherActivity extends Activity {
    Button btn;
    static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        btn.setText("other" + count);

        btn.postDelayed(new Runnable() {
            @Override
            public void run() {
                count++;
                btn.setText("other" + count);
                Log.d("leak-test", "other" + count);
                Toast.makeText(OtherActivity.this, "other" + count, Toast.LENGTH_SHORT).show();
                Log.d("leak-test", "view" + btn.getClass().toString());
            }
        }, 60000);

    }
}
