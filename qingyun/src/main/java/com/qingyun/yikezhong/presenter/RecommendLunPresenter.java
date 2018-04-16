package com.qingyun.yikezhong.presenter;

import android.support.v7.view.menu.BaseMenuPresenter;

import com.example.xiaohe.base.presenter.BaseMvpPresenter;
import com.qingyun.yikezhong.bean.RecommendLunBean;
import com.qingyun.yikezhong.fragment.RecommendFragment;
import com.qingyun.yikezhong.model.RecommendModel;
import com.qingyun.yikezhong.view.RecommendView;

/**
 * Created by 亓志伟 on 2018/4/14.
 */

public class RecommendLunPresenter extends BaseMvpPresenter<RecommendFragment> implements RecommendView.getPresenterKiss {

    private RecommendFragment myMainFragment;

    public RecommendLunPresenter(RecommendFragment myMainFragment) {
        this.myMainFragment = myMainFragment;
    }
    public void getFragmentDataURL(String url){
        RecommendModel myFragmentModel = new RecommendModel(this);
        myFragmentModel.getMainDataURL(url);
    }
    @Override
    public void getModelData(RecommendLunBean recommendLunBean) {
        myMainFragment.getPresenterData(recommendLunBean);
    }
}
