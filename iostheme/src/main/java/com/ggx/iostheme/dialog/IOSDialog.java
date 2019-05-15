package com.ggx.iostheme.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.ggx.iostheme.R;
import com.ggx.iostheme.button.IOSButton;

/**
 * Created by ggx on 2019/2/12.
 */

/**
 * Simple dialog
 * usage:
 * new IOSDialog.Builder()
 * .setTitle("title")
 * .setMessage("message")
 * .setLeftBtn("left text", View.OnClickListener)
 * .setCenterBtn("center text", View.OnClickListener)
 * .setRightBtn("right text", View.OnClickListener)
 * .show(activity);
 * <p>
 * List dialog
 * usage:
 */
public abstract class IOSDialog extends DialogFragment {
    View parentView, sap1, sap2;
    TextView titleTV;
    TextView contentTV;
    IOSButton leftBtn, centerBtn, rightBtn;

    String titleStr;
    String messageStr = null;
    String leftBtnTextStr;
    String rightBtnTextStr;
    String centerBtnTextStr;

    View.OnClickListener leftBtnOnClick;
    View.OnClickListener rightBtnOnClick;
    View.OnClickListener centerBtnOnClick;

    boolean leftBtnShow = false;
    boolean rightBtnShow = false;
    boolean centerBtnShow = false;

    ListAdapter adapter;

    Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    protected void setLeftBtn(String text, View.OnClickListener onClickListener) {
        leftBtnShow = true;
        leftBtnTextStr = text;
        leftBtnOnClick = onClickListener;
    }

    protected void setRightBtn(String text, View.OnClickListener onClickListener) {
        rightBtnShow = true;
        rightBtnTextStr = text;
        rightBtnOnClick = onClickListener;
    }

    protected void setCenterBtn(String text, View.OnClickListener onClickListener) {
        centerBtnShow = true;
        centerBtnTextStr = text;
        centerBtnOnClick = onClickListener;
    }

    protected void setMessage(String message) {
        this.messageStr = message;
    }

    protected void setTitle(String title) {
        this.titleStr = title;
    }

    protected void addButton(String text, View.OnClickListener onClickListener) {

    }

    protected void setAdapter(ListAdapter adapter) {
        this.adapter = adapter;
    }
}
