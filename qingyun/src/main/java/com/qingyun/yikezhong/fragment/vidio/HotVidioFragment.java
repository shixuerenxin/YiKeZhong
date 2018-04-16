package com.qingyun.yikezhong.fragment.vidio;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.xiaohe.base.baseview.BaseMvpFragment;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.qingyun.yikezhong.R;
import com.qingyun.yikezhong.adapter.HotVidioAdapter;
import com.qingyun.yikezhong.bean.HotVidioBean;
import com.qingyun.yikezhong.fragment.VideoFragment;
import com.qingyun.yikezhong.presenter.VidioPresenter;
import com.qingyun.yikezhong.view.VidioView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 亓志伟 on 2018/4/14.
 */

public class HotVidioFragment extends BaseMvpFragment<HotVidioFragment,VidioPresenter> implements VidioView.getMainKiss {

    private VidioPresenter vidioPresenter;
    private XRecyclerView hotVidioXrlvShow;
    private List<HotVidioBean.DataBean> list;
    private HotVidioAdapter hotVidioAdapter;
    private VidioPresenter vidioPresenter1;
    private int page=0;
    private Map<String, String> map;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = View.inflate(getContext(), R.layout.fragment_hot_video, null);
        initData(inflate);
        return inflate;
    }

    @Override
    public void onResume() {
        super.onResume();
        map = new HashMap<>();
        map.put("page",page+"");
        map.put("token","A6A04F4189646FDB70D40901D177A657");
        map.put("appVersion","123456");
//        map.put("source","android");
        //source=android
        vidioPresenter1.getFragmentDataURL("https://www.zhaoapi.cn/quarter/getHotVideos", map);
    }

    private void initData(final View inflate) {
        vidioPresenter1 = new VidioPresenter(this);

        hotVidioXrlvShow = (XRecyclerView)inflate.findViewById(R.id.hot_vidio_xrlv_show);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//不设置的话，图片闪烁错位，有可能有整列错位的情况。
        hotVidioXrlvShow.setLayoutManager(staggeredGridLayoutManager);
        list = new ArrayList<>();
        hotVidioAdapter = new HotVidioAdapter(getContext(), list);
        hotVidioXrlvShow.setAdapter(hotVidioAdapter);

        hotVidioAdapter.setOnClickLister(new HotVidioAdapter.OnClickLister() {
            @Override
            public void onClick(View view, String uri, String title) {
                Toast.makeText(getContext(), ""+uri, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), HotVidioShowActivity.class);
                intent.putExtra("ijkPlay",uri);
                intent.putExtra("title",title);
                startActivity(intent);
            }

        });
        hotVidioXrlvShow.setLoadingMoreEnabled(true);
        hotVidioXrlvShow.setPullRefreshEnabled(true);
        hotVidioXrlvShow.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                list.clear();
                page=0;
                map.put("page",page+"");
                vidioPresenter1.getFragmentDataURL("https://www.zhaoapi.cn/quarter/getHotVideos",map);
                hotVidioXrlvShow.refreshComplete();
            }

            @Override
            public void onLoadMore() {
//                list.clear();
                if (page>=0){
                    page+=1;
                    map.put("page",page+"");
                    vidioPresenter1.getFragmentDataURL("https://www.zhaoapi.cn/quarter/getHotVideos",map);
                }else {
                    Toast.makeText(getContext(), "加载结束", Toast.LENGTH_SHORT).show();
                }

                hotVidioXrlvShow.loadMoreComplete();
            }
        });
    }

    @Override
    public void getPresenterData(HotVidioBean recommendLunBean) {
        list.addAll(recommendLunBean.getData());
        hotVidioAdapter.notifyDataSetChanged();
    }

    @Override
    public VidioPresenter initPresenter() {
        vidioPresenter = new VidioPresenter(this);
        return vidioPresenter;
    }
}
