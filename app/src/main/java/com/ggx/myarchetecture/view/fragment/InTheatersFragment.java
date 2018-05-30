package com.ggx.myarchetecture.view.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.data.usecase.film.GetTop250FilmListUseCase;
import com.ggx.myarchetecture.R;
import com.ggx.myarchetecture.base.view.BaseFragment;
import com.ggx.myarchetecture.databinding.FragmentTop250Binding;

import butterknife.BindView;

/**
 * Created by ggx on 2018/5/20.
 */

public class InTheatersFragment extends BaseFragment {

    @BindView(R.id.top250F_gv)
    GridView gridView;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_top250;
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
