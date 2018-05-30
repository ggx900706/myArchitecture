package com.ggx.myarchetecture.base.view;

import android.support.v7.app.AppCompatActivity;

import com.ggx.myarchetecture.base.dialogs.LoadingDialog;

/**
 * Created by ggx on 2018/5/29.
 */

public class BaseActivity extends AppCompatActivity {
    LoadingDialog loadingDialog;

    public void showLoadingDialog() {
        if (loadingDialog == null)
            loadingDialog = new LoadingDialog(this);
        if (!loadingDialog.isShowing())
            loadingDialog.show();
    }

    public void hideLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing())
            loadingDialog.dismiss();
    }
}
