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
        /*
        * MVP框架只需要这一句，其他处理写在activity里面，需要setContentView(R.layout.activity_main);
        * */
        //presenter
        timePresenter = new TimePresenter();

        /*
        *
        * android lifecycle有关，暂时不知道怎么用，就给他暂时用来进行usecase的dispose
        * */
        //lifecycle
        getLifecycle().addObserver(timePresenter);

        /*
        *与dataBinding有关，如果使用，则不需要setContentView(R.layout.activity_main);
        * */
        //module
        timeModule = new TimeModule();
        //databinding
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setTime(timeModule);
    }

    public void getTime(View view) {
        timePresenter.getTime(timeModule);
    }

    public void clear(View view) {
        tv.setText("clear");
    }
}
