package com.qingyun.yikezhong.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.xiaohe.base.baseview.BaseMvpFragment;
import com.qingyun.yikezhong.R;
import com.qingyun.yikezhong.bean.RecommendLunBean;
import com.qingyun.yikezhong.presenter.RecommendLunPresenter;
import com.qingyun.yikezhong.view.RecommendView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 亓志伟 on 2018/4/13.
 */

public class RecommendFragment extends BaseMvpFragment<RecommendFragment,RecommendLunPresenter> implements RecommendView.getMainKiss {

    private Banner recommendBanLun;
    private RecommendLunPresenter recommendLunPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getContext(), R.layout.fragment_recommend, null);
        recommendBanLun = (Banner)inflate.findViewById(R.id.recommend_ban_lun);
        recommendLunPresenter.getFragmentDataURL("https://www.zhaoapi.cn/quarter/getAd");
        return inflate;
    }

    @Override
    public RecommendLunPresenter initPresenter() {
        recommendLunPresenter = new RecommendLunPresenter(this);
        return recommendLunPresenter;
    }

    @Override
    public void getPresenterData(RecommendLunBean recommendLunBean) {

        List<String> list=new ArrayList<>();
        for (int i = 0; i < recommendLunBean.getData().size(); i++) {
            list.add(recommendLunBean.getData().get(i).getIcon());
        }
        recommendBanLun.setImages(list);
        recommendBanLun.setDelayTime(3000);
        recommendBanLun.isAutoPlay(true);
        recommendBanLun.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(getContext()).load(path).into(imageView);
//                imageView.setImageURI(Uri.parse((String) path));
            }
        });
        recommendBanLun.start();

    }
}