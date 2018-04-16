package com.qingyun.yikezhong.fragment.vidio;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dou361.ijkplayer.widget.IjkVideoView;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.qingyun.yikezhong.R;
import com.qingyun.yikezhong.utils.OptionUtil;

public class HotVidioShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_vidio_show);
        OptionUtil.getChenjin(this,this);
//        IjkVideoView hotVidioShowPlay = findViewById(R.id.hot_vidio_show_play);
/*View rootView = getLayoutInflater().from(this).inflate(R.layout.simple_player_view_player, null);
        setContentView(rootView);*/
        Intent intent = getIntent();
        String url = intent.getStringExtra("ijkPlay");
        String title = intent.getStringExtra("title");
        View rootView = getLayoutInflater().from(this).inflate(R.layout.simple_player_view_player, null);
        setContentView(rootView);

        PlayerView title1 = new PlayerView(this)
                .setTitle(title)
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(url)
                .startPlay();

    }
}
