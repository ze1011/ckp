package com.vg.ckp;

import android.app.Application;
import android.content.res.Configuration;

import com.avos.avoscloud.AVOSCloud;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ScreenAdapterTools.init(this);
    
        // 启用北美节点, 需要在 initialize 之前调用
        AVOSCloud.useAVCloudCN();
    
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"p5jzJC8dodMhxjhWVo7PC93V-gzGzoHsz","uxXmwK7r2dtjLMe5EU3JFkPq");
        //AVOSCloud.setDebugLogEnabled(true);
    }

    //旋转适配,如果应用屏幕固定了某个方向不旋转的话(比如qq和微信),下面可不写.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ScreenAdapterTools.getInstance().reset(this);
    }
}
