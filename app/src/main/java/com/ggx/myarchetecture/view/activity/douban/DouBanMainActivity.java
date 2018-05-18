package com.ggx.myarchetecture.view.activity.douban;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ggx.myarchetecture.R;
import com.ggx.myarchetecture.app.Application;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.data.net.Client.ClientConfig.URL_TAOBAO_DUISHI;

public class DouBanMainActivity extends AppCompatActivity {

    @BindView(R.id.doubanActivity_searctET)
    EditText editText;

    @BindView(R.id.doubanActivity_tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.doubanActivity_vp)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dou_ban_main);
        ButterKnife.bind(this);

        Application.changeURL(URL_TAOBAO_DUISHI);
    }

    public void search(View view) {

    }
}
