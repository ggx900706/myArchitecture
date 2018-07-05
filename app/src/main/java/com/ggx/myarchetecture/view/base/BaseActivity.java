package com.ggx.myarchetecture.view.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ggx.myapplication.executor.module.repository.ILoadDataInterface;
import com.ggx.myarchetecture.R;

/**
 * Created by ggx on 2018/7/5.
 */

public class BaseActivity extends AppCompatActivity implements ILoadDataInterface {
    private ProgressDialog progressDialog;

    @Override
    public void showLoadingDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage(getString(R.string.progress_dialog_loading));
            progressDialog.setTitle(getString(R.string.progress_dialog_loading_title));
        }
        if(!progressDialog.isShowing())
            progressDialog.show();
    }

    @Override
    public void hideLoadingDialog() {
        if(progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
