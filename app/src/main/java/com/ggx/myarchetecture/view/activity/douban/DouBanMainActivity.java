package com.ggx.myarchetecture.view.activity.douban;

import android.app.Fragment;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ggx.myarchetecture.R;
import com.ggx.myarchetecture.app.Application;
import com.ggx.myarchetecture.base.view.BaseFragment;
import com.ggx.myarchetecture.view.fragment.InTheatersFragment;
import com.ggx.myarchetecture.view.fragment.Top250Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    List<String> tabList;
    //    List<Fragment> fragmentList;
    List<View> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dou_ban_main);
        ButterKnife.bind(this);

        tabList = new ArrayList<>();
        tabList.add(getString(R.string.douban_tab_on_theaters));
        tabList.add("top250");
        tabLayout.setupWithViewPager(viewPager);

        fragmentList = new ArrayList<>();
//        fragmentList.add(new InTheatersFragment());
//        fragmentList.add(new Top250Fragment());
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < tabList.size(); i++) {
            TextView textView = new TextView(this);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            textView.setLayoutParams(layoutParams);
            textView.setText("tab" + i);
            textView.setBackgroundColor(random.nextInt(0xFFFFFF) + 0xFF000000);
            fragmentList.add(textView);
        }

        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Application.changeURL(URL_TAOBAO_DUISHI);
    }

    PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(fragmentList.get(position));
            return fragmentList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabList.get(position);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
