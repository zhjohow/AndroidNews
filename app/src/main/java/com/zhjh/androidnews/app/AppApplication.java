package com.zhjh.androidnews.app;

import com.zhjh.androidnews.BuildConfig;
import com.zhjh.common.baseapp.BaseApplication;
import com.zhjh.common.commonutils.LogUtils;

/**
 * APPLICATION
 */
public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger
        LogUtils.logInit(BuildConfig.LOG_DEBUG);
    }
}
