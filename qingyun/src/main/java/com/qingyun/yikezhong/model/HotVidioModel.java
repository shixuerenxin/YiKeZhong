package com.qingyun.yikezhong.model;

import android.os.Handler;
import android.os.Message;

import com.example.xiaohe.base.bean.BaseObserver;
import com.example.xiaohe.base.util.RetrofitAndOkhttpAndRxAndriodUtil;
import com.google.gson.Gson;
import com.qingyun.yikezhong.bean.HotVidioBean;
import com.qingyun.yikezhong.bean.RecommendLunBean;
import com.qingyun.yikezhong.presenter.VidioPresenter;
import com.qingyun.yikezhong.view.VidioView;

import java.util.Map;


/**
 * Created by 亓志伟 on 2018/4/14.
 */

public class HotVidioModel implements VidioView.getModelKiss {

    private Handler handler=new Handler();
    private VidioPresenter vidioPresenter;

    public HotVidioModel(VidioPresenter vidioPresenter) {
        this.vidioPresenter = vidioPresenter;
    }
    @Override
    public void getMainDataURL(String url, Map<String,String> map) {
        RetrofitAndOkhttpAndRxAndriodUtil.post(url,map)
                .subscribe(new BaseObserver() {
                    @Override
                    public void onSuccess(final String result) {

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Gson gson = new Gson();
                                final HotVidioBean recommendLunBean = gson.fromJson(result, HotVidioBean.class);
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        vidioPresenter.getModelData(recommendLunBean);
                                    }
                                });


                            }
                        }).start();

                    }
                });
    }
}
