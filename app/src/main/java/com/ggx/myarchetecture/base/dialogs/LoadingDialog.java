package com.ggx.myarchetecture.base.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.ggx.myarchetecture.R;

/**
 * Created by len on 2018/5/29.
 */

public class LoadingDialog extends Dialog {
    public LoadingDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);

        setCancelable(false);
    }
}
