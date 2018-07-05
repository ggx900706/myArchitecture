package com.ggx.myarchetecture.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ggx.myarchetecture.R;
import com.ggx.myarchetecture.observable.common.ICommonHttpInterface;
import com.ggx.myarchetecture.presenter.time.TimePresenter;
import com.ggx.myarchetecture.view.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements TimePresenter.IMainActivityInterface, ICommonHttpInterface {

    @BindView(R.id.tv)
    TextView tv;

    TimePresenter timePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        timePresenter = new TimePresenter();
        timePresenter.setView(this);
        timePresenter.setICommonHttpInterface(this);
        getLifecycle().addObserver(timePresenter);
    }

    @Override
    public void getTimeSucces(String str) {
        tv.setText(str);
    }

    @OnClick(R.id.btn)
    public void getTime() {
        timePresenter.getTime();
    }

    @OnClick(R.id.clrBtn)
    public void clear() {
        tv.setText("clear");
    }

    @Override
    public void onSuccess(String result) {
        Log.e("------", "get result : " + result);
    }

    @Override
    public void onException(Throwable throwable) {
        throwable.printStackTrace();
        Log.e("------", "get error : " + throwable.toString());
    }
}
