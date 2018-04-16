package com.qingyun.yikezhong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiaohe.base.baseview.BaseMvpFragment;
import com.qingyun.yikezhong.R;
import com.qingyun.yikezhong.adapter.VidioFragmentAdapter;
import com.qingyun.yikezhong.bean.HotVidioBean;
import com.qingyun.yikezhong.fragment.vidio.FuJinVidioFragment;
import com.qingyun.yikezhong.fragment.vidio.HotVidioFragment;
import com.qingyun.yikezhong.presenter.VidioPresenter;
import com.qingyun.yikezhong.view.VidioView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 亓志伟 on 2018/4/13.
 */

public class VideoFragment extends Fragment {

    private TabLayout tab_FindFragment_title;                            //定义TabLayout
    private ViewPager vp_FindFragment_pager;                             //定义viewPager
    private FragmentPagerAdapter fAdapter;                               //定义adapter

    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表

    private HotVidioFragment hotRecommendFragment;              //热门推荐fragment
    private FuJinVidioFragment hotCollectionFragment;            //热门收藏fragment

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getContext(), R.layout.fragment_video, null);
        initControls(inflate);
        return inflate;
    }

    private void initControls(View view) {

        tab_FindFragment_title = (TabLayout)view.findViewById(R.id.tab_FindFragment_title);
        vp_FindFragment_pager = (ViewPager)view.findViewById(R.id.vp_FindFragment_pager);

        //初始化各fragment
        hotRecommendFragment = new HotVidioFragment();
        hotCollectionFragment = new FuJinVidioFragment();

        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(hotRecommendFragment);
        list_fragment.add(hotCollectionFragment);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("热门");
        list_title.add("附近");

        //设置TabLayout的模式
        tab_FindFragment_title.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(0)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(1)));

        fAdapter = new VidioFragmentAdapter(getActivity().getSupportFragmentManager(),list_fragment,list_title);

        //viewpager加载adapter
        vp_FindFragment_pager.setAdapter(fAdapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);
        //tab_FindFragment_title.set
    }

}
