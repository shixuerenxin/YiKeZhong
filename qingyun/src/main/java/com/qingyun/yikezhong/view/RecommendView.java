package com.qingyun.yikezhong.view;

import com.qingyun.yikezhong.bean.RecommendLunBean;

/**
 * Created by 亓志伟 on 2018/4/14.
 */

public class RecommendView {

    public interface getModelKiss{
        void getMainDataURL(String url);
    }
    public interface getPresenterKiss{
        void getModelData(RecommendLunBean recommendLunBean);
    }
    public interface getMainKiss{
        void getPresenterData(RecommendLunBean recommendLunBean);
    }

}
