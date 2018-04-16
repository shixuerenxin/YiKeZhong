package com.qingyun.yikezhong.model;

import android.os.Handler;

import com.example.xiaohe.base.bean.BaseObserver;
import com.example.xiaohe.base.util.RetrofitAndOkhttpAndRxAndriodUtil;
import com.google.gson.Gson;
import com.qingyun.yikezhong.bean.HotVidioBean;
import com.qingyun.yikezhong.bean.RecommendLunBean;
import com.qingyun.yikezhong.presenter.RecommendLunPresenter;
import com.qingyun.yikezhong.view.RecommendView;

import java.util.HashMap;

/**
 * Created by 亓志伟 on 2018/4/14.
 */

public class RecommendModel implements RecommendView.getModelKiss {
    private RecommendLunPresenter myFragmentPresenter;
    private Handler handler=new Handler();

    public RecommendModel(RecommendLunPresenter myFragmentPresenter) {
        this.myFragmentPresenter = myFragmentPresenter;
    }

    @Override
    public void getMainDataURL(String url) {
        RetrofitAndOkhttpAndRxAndriodUtil.get(url)
                .subscribe(new BaseObserver() {
                    @Override
                    public void onSuccess(final String result) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Gson gson = new Gson();
                                final RecommendLunBean recommendLunBean = gson.fromJson(result, RecommendLunBean.class);

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        myFragmentPresenter.getModelData(recommendLunBean);
                                    }
                                });


                            }
                        }).start();

                    }
                });
    }
}
