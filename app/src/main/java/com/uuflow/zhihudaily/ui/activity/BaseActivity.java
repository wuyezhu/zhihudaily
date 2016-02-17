package com.uuflow.zhihudaily.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * @author yelin.wu 16/2/17 下午4:23.
 * @description
 */
public class BaseActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void startActivity(Class targetActivity){
        Intent intent = new Intent(this,targetActivity);
        startActivity(intent);
    }

    protected void startActivity(Class targetActivity,Bundle data){
        Intent intent = new Intent(this,targetActivity);
        intent.putExtras(data);
        startActivity(intent);
    }

    protected String getPreString(String key){
        Bundle extras = getIntent().getExtras();
        return (String) extras.get(key);
    }

}
