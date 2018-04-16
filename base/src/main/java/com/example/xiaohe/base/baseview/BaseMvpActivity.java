package com.example.xiaohe.base.baseview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.xiaohe.base.presenter.BaseMvpPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaohe on 2018/4/13.
 */

public abstract class BaseMvpActivity<V,T extends BaseMvpPresenter<V>> extends AppCompatActivity {
    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V)this);
    }

    @Override
    protected void onDestroy() {
        presenter.dettach();
        super.onDestroy();
    }

    // 实例化presenter
    public abstract T initPresenter();
}
