package com.qingyun.yikezhong.view;

import com.qingyun.yikezhong.bean.HotVidioBean;
import com.qingyun.yikezhong.bean.RecommendLunBean;

import java.util.Map;

/**
 * Created by 亓志伟 on 2018/4/14.
 */

public class VidioView {

    public interface getModelKiss{
        void getMainDataURL(String url, Map<String,String> map);
    }
    public interface getPresenterKiss{
        void getModelData(HotVidioBean recommendLunBean);
    }
    public interface getMainKiss{
        void getPresenterData(HotVidioBean recommendLunBean);
    }

}
