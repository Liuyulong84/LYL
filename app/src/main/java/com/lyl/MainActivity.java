package com.lyl;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lyl.administrator.lyl.R;
import com.lyl.net.Activity_net;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int count = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.test);
        //--------------------------------------------------------
        final Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                count ++;
                mHandler.postDelayed(this, 10);
                if(count == 100){
                    mHandler.removeCallbacks(this);
                }
            }
        }, 100);

        //---------------------------------------------------------
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

            }
        };

        Timer timer = new Timer();
        timer.schedule(task,100L);

        //---------------------------------------------------------
        //http://blog.csdn.net/ly502541243/article/details/52062179
        //所以到了这里，我们解决了开始的疑惑，为什么在post中传了个Runnable还是在主线程中可以更新UI。
//        已经大概梳理了一下Handler的消息机制，以及post方法和我们常用的sendMessage方法的区别。来总结一下，主要涉及四个类Handler、Message、MessageQueue、Looper：
//
//        新建Handler，通过sendMessage或者post发送消息，Handler调用sendMessageAtTime将Message交给MessageQueue
//
//        MessageQueue.enqueueMessage方法将Message以链表的形式放入队列中
//
//        Looper的loop方法循环调用MessageQueue.next()取出消息，并且调用Handler的dispatchMessage来处理消息
//
//        在dispatchMessage中，分别判断msg.callback、mCallback也就是post方法或者构造方法传入的不为空就执行他们的回调，如果都为空就执行我们最常用重写的handleMessage。
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);//在子线程有一段耗时操作,比如请求网络
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("This is post");//更新UI
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        initCustomViewLearning();
        initHttpStudy();

    }

    private void initHttpStudy() {
        findViewById(R.id.goWebview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Activity_net.class));
            }
        });
    }

    private void initCustomViewLearning() {
        findViewById(R.id.custom_view_learning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Main2Activity.class));
            }
        });
    }


}
