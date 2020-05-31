package com.example.sinoaecstudentgroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int i= 6;
    @SuppressLint("HandlerLeak")
    Handler hand = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            i--;
            if (i>=0){
                mDroup.setText("倒计时"+i+"");
            }else if (i == 3){
                String str = "https://newoss.zhulong.com/ad/202004/13/41/100541b4f5xqxtiyrgsgqz.jpg";
                Glide.with(MainActivity.this).load(str).into(mVp);
            }else if (i == 0){
                timer.cancel();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }
    };

    private Timer timer;
    private TextView mDroup;
    private TextView mTitle;
    private ImageView mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTitle = findViewById(R.id.title);
        mVp = findViewById(R.id.vp);
        mDroup = findViewById(R.id.droup);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                hand.sendEmptyMessage(1);
            }
        };
        timer = new Timer();
        timer.schedule(timerTask,0,1000);

        mDroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
