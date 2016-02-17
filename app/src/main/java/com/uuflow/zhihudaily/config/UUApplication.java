package com.uuflow.zhihudaily.config;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author yelin.wu 16/2/17 下午1:21.
 * @description
 */
public class UUApplication extends Application{

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        Fresco.initialize(sContext);
    }

    public static Context getContext(){
        return sContext;
    }
}
