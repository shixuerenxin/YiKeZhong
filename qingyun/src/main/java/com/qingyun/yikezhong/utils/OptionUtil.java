package com.qingyun.yikezhong.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by 亓志伟 on 2018/4/16.
 */

public class OptionUtil {

    private int dioayong;

    public OptionUtil() {
    }

    public OptionUtil(int dioayong) {
        this.dioayong = dioayong;
    }
    public static void getChenjin(Activity context, AppCompatActivity appCompatActivity){
        if (Build.VERSION.SDK_INT >= 21) {
            int option = getOption(6);
            View decorView = context.getWindow().getDecorView();
            decorView.setSystemUiVisibility(option);
            context.getWindow().setStatusBarColor(Color.TRANSPARENT);//设置statusbar为透明色
            context.getWindow().setNavigationBarColor(Color.TRANSPARENT);//设置NavigationBar为透明色
        }
        ActionBar actionBar = appCompatActivity.getSupportActionBar();
        actionBar.hide();

    }
    public static int getOption(int type) {
        int option = 0;
        switch (type) {
            case 0:
                //隐藏statusbar的效果,当与用户交互时flag失效
                option= View.SYSTEM_UI_FLAG_FULLSCREEN;
                break;
            case 1:
                //隐藏导航栏,当与用户交互时(如拖动)该flag失效
                option= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                break;
            case 2:
                //全部隐藏都不透明,当有用户交互,比如点击拖动。flag就会失效
                option= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN;
                break;
            case 3:
                //为设置statusbar实现透明铺垫,将statusbar移动到图层的最上面,
                // 当设置statusbar为透明色的时候就可以实现沉浸效果
                // 再调用setStatusBarColor
                // 整个statusbar显示为透明色
                option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                break;
            case 4://半透明效果
                //这个模式也是为实现透明做铺垫,将statusbar,Navigationbar 移动到图层的最上面,
                // 当设置statusbar,NavigationBar设置为透明色的时候就可以实现沉浸效果
                // 再调用setStatusBarColor,setNavigationBarColor,设置为透明色。即可
                option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                break;
            case 5:
                //隐藏导航栏,有SYSTEM_UI_FLAG_IMMERSIVE,
                // 拖动时隐藏导航栏的flag依然有效。
                // 没有SYSTEM_UI_FLAG_IMMERSIVE,隐藏导航栏的flag立刻失效
                //SYSTEM_UI_FLAG_IMMERSIVE_STICKY和SYSTEM_UI_FLAG_IMMERSIVE效果相同,
                // 只是几秒钟后隐藏导航栏的flag 又会生效
                //这时候如果设置setStatusBarColor颜色为透明色,
                // statusbar只会显示为白色。。因为最下面的底色不透明
                option= View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                break;
            case 6:
                //综合应用,当交互时导航栏,statusbar出现。失去焦点时消失
                option=View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
                break;

            default:
                //隐藏statusbar的效果,当与用户交互时flag失效
                option= View.SYSTEM_UI_FLAG_FULLSCREEN;
                break;
        }
        return option;
    }
}
