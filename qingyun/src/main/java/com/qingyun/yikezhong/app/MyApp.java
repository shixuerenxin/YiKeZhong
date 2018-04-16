package com.qingyun.yikezhong.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * Created by 亓志伟 on 2018/4/14.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
      /*  ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setBitmapMemoryCacheParamsSupplier(bitmapCacheParamsSupplier)
                .setCacheKeyFactory(cacheKeyFactory)
                .setDownsampleEnabled(true)
                .setWebpSupportEnabled(true)
                .setEncodedMemoryCacheParamsSupplier(encodedCacheParamsSupplier)
                .setExecutorSupplier(executorSupplier)
                .setImageCacheStatsTracker(imageCacheStatsTracker)
                .setMainDiskCacheConfig(mainDiskCacheConfig)
                .setMemoryTrimmableRegistry(memoryTrimmableRegistry)
                .setNetworkFetchProducer(networkFetchProducer)
                .setPoolFactory(poolFactory)
                .setProgressiveJpegConfig(progressiveJpegConfig)
                .setRequestListeners(requestListeners)
                .setSmallImageDiskCacheConfig(smallImageDiskCacheConfig)
                .build();
        Fresco.initialize(this, config);*/
        Fresco.initialize(this);
    }
}
