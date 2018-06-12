package com.ggx.myarchetecture.base.view;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ggx on 2018/5/19.
 */

public abstract class BaseFragment extends Fragment {

    /*
    * butterknife需要的属性
    * */
    private Unbinder unbinder;

    /*
    * 原来的onCreateView函数
    * 包装后添加了butterknife的使用
    * 如果不需要就直接在子类重写onCreateView
    * */
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(), null);
        bindView(view);
        init(view);
        return view;
    }

    /*
    * onCreateView拆分成了两个函数
    * init初始化一些控件属性之类的
    * 原来写在onCreateView里面的东西可以写在这个里面
    * */
    public void init(View view) {
    }

    /*
    * onCreateView拆分成了两个函数
    * getLayoutID返回R.layout.id
    * 不用进行其他操作
    * */
    public abstract int getLayoutID();

    /*
    * 重写onDestory
    * 加上了unbinder
    * 如果没有用到butterknife则用不到这个
    * */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null)
            unbinder.unbind();
    }

    /*
    * butterknife的初始化
    * */
    private void bindView(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    /*
    * butterknife的销毁
    * */
    private void unbindView() {
        unbinder.unbind();
    }

    /*
    * 我自己需要的函数
    * */
    public abstract void onRefresh();
}
