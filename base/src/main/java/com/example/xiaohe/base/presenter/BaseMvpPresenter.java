package com.example.xiaohe.base.presenter;

import android.content.Context;

/**
 * Created by xiaohe on 2018/4/13.
 */

public class BaseMvpPresenter<T> {
    //MyMainFragment
    //MainActivity
    //Integer
    private T mView;

    public void attach(T mView) {
        this.mView = mView;
    }

    public void dettach() {
        mView = null;
    }
}
