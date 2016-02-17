package com.uuflow.zhihudaily.utils;

import android.widget.Toast;

import com.uuflow.zhihudaily.config.UUApplication;

/**
 * @author yelin.wu 16/2/17 下午1:21.
 * @description
 */
public class ToastUtil {

    public static void showLongToast(String msg){
        Toast.makeText(UUApplication.getContext(),msg,Toast.LENGTH_LONG).show();
    }

    public static void showShortToast(String msg){
        Toast.makeText(UUApplication.getContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
