package com.ggx.myarchetecture.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.data.usecase.film.GetTop250FilmListUseCase;
import com.ggx.myarchetecture.R;
import com.ggx.myarchetecture.base.view.BaseFragment;
import com.ggx.myarchetecture.databinding.FragmentTop250Binding;

/**
 * Created by ggx on 2018/5/20.
 */

public class InTheatersFragment extends BaseFragment {

    GetTop250FilmListUseCase useCase;

    FragmentTop250Binding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_top250, container, false);
        return binding.getRoot();
    }

    @Override
    public void onRefresh() {

    }
}
