package com.ggx.myarchetecture.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ggx.myarchetecture.R;
import com.ggx.myarchetecture.databinding.ActivityMainBinding;
import com.ggx.myarchetecture.module.viewmodule.TimeModule;
import com.ggx.myarchetecture.presenter.time.TimePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;

    //databinding
    ActivityMainBinding activityMainBinding;

    //presenter
    TimePresenter timePresenter;

    //module
    TimeModule timeModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //butterknife
        ButterKnife.bind(this);
        //presenter
        timePresenter = new TimePresenter();
        //lifecycle
        getLifecycle().addObserver(timePresenter);
        //module
        timeModule = new TimeModule();
        //databinding
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setTime(timeModule);
    }

    public void getTime(View view) {
        Log.e("------", "get time");
        timePresenter.getTime(timeModule);
    }

    public void clear(View view) {
        tv.setText("clear");
    }
}
