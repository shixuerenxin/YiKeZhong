package com.qingyun.yikezhong.presenter;

import com.example.xiaohe.base.presenter.BaseMvpPresenter;
import com.qingyun.yikezhong.bean.HotVidioBean;
import com.qingyun.yikezhong.bean.RecommendLunBean;
import com.qingyun.yikezhong.fragment.RecommendFragment;
import com.qingyun.yikezhong.fragment.VideoFragment;
import com.qingyun.yikezhong.fragment.vidio.HotVidioFragment;
import com.qingyun.yikezhong.model.HotVidioModel;
import com.qingyun.yikezhong.model.RecommendModel;
import com.qingyun.yikezhong.view.RecommendView;
import com.qingyun.yikezhong.view.VidioView;

import java.util.Map;

/**
 * Created by 亓志伟 on 2018/4/14.
 */

public class VidioPresenter extends BaseMvpPresenter<HotVidioFragment> implements VidioView.getPresenterKiss {
    private HotVidioFragment myMainFragment;

    public VidioPresenter(HotVidioFragment myMainFragment) {
        this.myMainFragment = myMainFragment;
    }
    public void getFragmentDataURL(String url, Map<String,String> map){
        HotVidioModel myFragmentModel = new HotVidioModel(this);
        myFragmentModel.getMainDataURL(url,map);
    }

    @Override
    public void getModelData(HotVidioBean recommendLunBean) {
        myMainFragment.getPresenterData(recommendLunBean);
    }
}
