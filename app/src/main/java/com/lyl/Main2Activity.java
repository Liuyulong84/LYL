package com.lyl;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.lyl.administrator.lyl.R;
import com.lyl.customview.CircleProgress;
import com.lyl.customview.HorizontalProgressBarWithProgress;

public class Main2Activity extends AppCompatActivity {

    public static final int PROGRESS_MSG = 1;

    private HorizontalProgressBarWithProgress mProgressBar;
    private CircleProgress mCircleBar;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (mProgressBar.getProgress() >= 100){
                mHandler.removeMessages(PROGRESS_MSG);
            }
            switch (msg.what){
                case PROGRESS_MSG:
                    mProgressBar.setProgress(mProgressBar.getProgress() + 1);
                    mCircleBar.setProgress(mProgressBar.getProgress() + 1);
                    mHandler.sendEmptyMessageDelayed(PROGRESS_MSG ,100);
                    break;

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mProgressBar = (HorizontalProgressBarWithProgress) findViewById(R.id.lyl_progress);
        mCircleBar = (CircleProgress) findViewById(R.id.lyl_progress_circle);
        mProgressBar.setProgress(30);
        mCircleBar.setProgress(40);
        mHandler.sendEmptyMessage(PROGRESS_MSG);
    }

}
