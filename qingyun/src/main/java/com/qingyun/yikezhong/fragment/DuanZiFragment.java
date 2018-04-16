package com.qingyun.yikezhong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qingyun.yikezhong.R;

/**
 * Created by 亓志伟 on 2018/4/13.
 */

public class DuanZiFragment extends Fragment {

    private Toolbar mainTlCl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getContext(), R.layout.fragment_duanzi, null);
        inflate.findViewById(R.id.recommend_iv_ch);

        return inflate;
    }
}
