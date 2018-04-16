package com.qingyun.yikezhong.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qingyun.yikezhong.MainActivity;
import com.qingyun.yikezhong.R;
import com.qingyun.yikezhong.utils.OptionUtil;

public class IndexActivity extends AppCompatActivity {

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    handler.sendEmptyMessageDelayed(1,1000);
                    break;
                case 1:
                    Intent intent = new Intent(IndexActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        OptionUtil.getChenjin(this,this);
        handler.sendEmptyMessageDelayed(0,1000);
    }
}
