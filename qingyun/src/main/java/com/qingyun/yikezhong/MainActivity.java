package com.qingyun.yikezhong;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;
import com.qingyun.yikezhong.fragment.DuanZiFragment;
import com.qingyun.yikezhong.fragment.RecommendFragment;
import com.qingyun.yikezhong.fragment.VideoFragment;
import com.qingyun.yikezhong.utils.OptionUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView recommendIvFx;
    private SimpleDraweeView recommendIvCh;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView menu;
    private BottomTabBar tobarLb;
    private TextView tvTitleName;
    private SimpleDraweeView mainPersonHead;
    private TextView mainPersonName;
    private TextView mainPersonTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OptionUtil.getChenjin(this,this);
        View inflate = View.inflate(MainActivity.this, R.layout.head, null);
        recommendIvCh = (SimpleDraweeView)findViewById(R.id.recommend_iv_ch);
        recommendIvFx = (ImageView)findViewById(R.id.recommend_iv_fx);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_na);
        navigationView = (NavigationView) findViewById(R.id.nav);
        tobarLb = (BottomTabBar)findViewById(R.id.tobar_lb);
        tvTitleName = (TextView)findViewById(R.id.tv_title_name);
        LinearLayout headerView = (LinearLayout) navigationView.getHeaderView(0);
        mainPersonHead = (SimpleDraweeView)headerView.findViewById(R.id.main_person_head);
        mainPersonName = (TextView)headerView.findViewById(R.id.main_person_name);
        mainPersonTitle = (TextView)headerView.findViewById(R.id.main_person_title);

        mainPersonHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "头部", Toast.LENGTH_SHORT).show();
            }
        });
        mainPersonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "名字", Toast.LENGTH_SHORT).show();
            }
        });
        mainPersonTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "标题", Toast.LENGTH_SHORT).show();
            }
        });
        tobarLb.init(getSupportFragmentManager())    //bottomTabBar是找到的控件的名字
                .setImgSize(50,50)
                .setFontSize(12)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem(getResources().getString(R.string.app_tuijian),R.drawable.tuijian2, R.drawable. tuijian1,RecommendFragment.class)
                .addTabItem(getResources().getString(R.string.app_dunazi),R.drawable.duanzi2,R.drawable.duanzi1, DuanZiFragment.class)
                .addTabItem(getResources().getString(R.string.app_video),R.drawable.shipin2,R.drawable.shipin1, VideoFragment.class)
                .isShowDivider(true)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                        switch (position){
                            case 0:
                                tvTitleName.setText("推荐");
                                break;
                            case 1:
                                tvTitleName.setText("段子");
                                break;
                            case 2:
                                tvTitleName.setText("视频");
                                break;
                        }

                    }
                });
        recommendIvCh.setOnClickListener(this);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //item.setChecked(true);
                if (item.getTitle().equals("我的关注")){
                    Toast.makeText(MainActivity.this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                }else if(item.getTitle().equals("我的收藏")){
                    Toast.makeText(MainActivity.this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                }else if(item.getTitle().equals("搜索好友")){
                    Toast.makeText(MainActivity.this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                }else if(item.getTitle().equals("消息通知")){
                    Toast.makeText(MainActivity.this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                }

                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.recommend_iv_ch://点击菜单，跳出侧滑菜单
                if (drawerLayout.isDrawerOpen(navigationView)){
                    drawerLayout.closeDrawer(navigationView);
                }else{
                    drawerLayout.openDrawer(navigationView);
                }
                break;
        }
    }
    public void getHead(View view) {
        Toast.makeText(this, "头部", Toast.LENGTH_SHORT).show();
    }


}
