package com.zhjohow.androidnews.app;

import com.zhjohow.androidnews.BuildConfig;
import com.zhjohow.common.baseapp.BaseApplication;
import com.zhjohow.common.commonutils.LogUtils;

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
