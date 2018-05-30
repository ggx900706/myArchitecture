package com.ggx.myarchetecture.view.activity.time;

import android.content.Intent;
import android.view.View;

import com.ggx.myarchetecture.BR;
import com.ggx.myarchetecture.R;
import com.ggx.myarchetecture.app.Application;
import com.ggx.myarchetecture.base.view.BaseVMActivity;
import com.ggx.myarchetecture.databinding.ActivityMainBinding;
import com.ggx.myarchetecture.module.viewmodule.TimeModule;
import com.ggx.myarchetecture.view.activity.douban.DouBanMainActivity;

import static com.data.net.Client.ClientConfig.URL_DOUBAN;

//由于这个页面只有一个网络业务，比较简单，因此直接用viewModule进行操作
//网络通讯内容：调用淘宝服务器，获取当前时间，
public class MainVMActivity extends BaseVMActivity<ActivityMainBinding, TimeModule> {

    //module
    TimeModule timeModule;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.time;
    }

    @Override
    public TimeModule initViewModel() {
        timeModule = new TimeModule(this);
        return timeModule;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void jumpDouBan(View view) {
        startActivity(new Intent(this, DouBanMainActivity.class));
    }
}
