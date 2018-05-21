package com.ggx.myarchetecture.view.view.adapter;

import android.content.Context;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ggx.myarchetecture.BR;
import com.ggx.myarchetecture.R;
import com.ggx.myarchetecture.databinding.ItemFilmBinding;
import com.ggx.myarchetecture.module.viewmodule.film.simple.SimpleFilmModule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggx on 2018/5/19.
 */

public class FilmAdapter extends BaseAdapter {

    Context context;
    List<SimpleFilmModule> list;

    public FilmAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setFilmList(List<SimpleFilmModule> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ItemFilmBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_film, viewGroup, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.setVariable(BR.item, list.get(i));
        return binding.getRoot();
    }
}
