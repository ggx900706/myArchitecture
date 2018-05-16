package com.ggx.myarchetecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ggx.myarchetecture.presenter.time.TimePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements TimePresenter.IMainActivityInterface {

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
    }

    @Override
    public void getTimeSucces(String str) {
        tv.setText(str);
    }

    @OnClick(R.id.btn)
    public void getTime() {
        timePresenter.getTime();
    }
}
