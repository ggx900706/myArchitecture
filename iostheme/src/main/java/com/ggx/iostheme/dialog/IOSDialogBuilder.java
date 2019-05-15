package com.ggx.iostheme.dialog;

import android.app.Activity;
import android.support.annotation.IntDef;
import android.view.View;

/**
 * Created by ggx on 2019/2/12.
 */

public class IOSDialogBuilder {
    public static final int Dialog_Text = 0;
    public static final int Dialog_List = 1;
    public static final int Dialog_From_Bottom = 2;
    public static final int Dialog_Text_Vertical = 3;

    Activity activity;

    @IntDef({Dialog_Text, Dialog_List, Dialog_From_Bottom, Dialog_Text_Vertical})
    public @interface IOSDialogType {
    }

    private IOSDialog iosDialog;

    public IOSDialogBuilder(Activity activity) {
        this(Dialog_Text, activity);
    }

    public IOSDialogBuilder(@IOSDialogType int type, Activity activity) {
        this.activity = activity;
        switch (type) {
            case Dialog_Text:
                this.iosDialog = new IOSDialogText();
                break;
            case Dialog_List:
                this.iosDialog = new IOSDialogList();
                break;
            case Dialog_From_Bottom:
                this.iosDialog = new IOSDialogList();
                break;
            case Dialog_Text_Vertical:
                this.iosDialog = new IOSDialogText();
                ((IOSDialogText) iosDialog).setVertical(true);
                break;
        }
        if (this.iosDialog != null)
            iosDialog.setActivity(activity);
    }

    public IOSDialogBuilder setLeftBtn(String text, View.OnClickListener onClickListener) {
        if (onClickListener == null)
            onClickListener = defaultOnclickedListener;
        iosDialog.setLeftBtn(text, onClickListener);
        return this;
    }

    //AlertDialog.setPositiveButton
    public IOSDialogBuilder setPositiveButton(String text, View.OnClickListener onClickListener) {
        return this.setLeftBtn(text, onClickListener);
    }

    public IOSDialogBuilder setRightBtn(String text, View.OnClickListener onClickListener) {
        if (onClickListener == null)
            onClickListener = defaultOnclickedListener;
        iosDialog.setRightBtn(text, onClickListener);
        return this;
    }

    public IOSDialogBuilder setNegativeButton(String text, View.OnClickListener onClickListener) {
        return this.setRightBtn(text, onClickListener);
    }

    public IOSDialogBuilder setCenterBtn(String text, View.OnClickListener onClickListener) {
        if (onClickListener == null)
            onClickListener = defaultOnclickedListener;
        iosDialog.setCenterBtn(text, onClickListener);
        return this;
    }

    public IOSDialogBuilder setNeutralButton(String text, View.OnClickListener onClickListener) {
        return this.setCenterBtn(text, onClickListener);
    }

    public IOSDialogBuilder setMessage(String message) {
        iosDialog.setMessage(message);
        return this;
    }

    public IOSDialogBuilder setTitle(String title) {
        iosDialog.setTitle(title);
        return this;
    }

    public void show() {
        iosDialog.show(activity.getFragmentManager(), "dialog");
    }

    private View.OnClickListener defaultOnclickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            iosDialog.dismiss();
        }
    };

    public IOSDialogBuilder addButton(String text, View.OnClickListener onClickListener) {
        if (iosDialog instanceof IOSDialogList) {
            iosDialog.addButton(text, onClickListener);
        }
        return this;
    }

    public IOSDialogBuilder buildSimpleErrorDialog(String message) {
        return this.setLeftBtn("确定", null).setMessage(message).setTitle("提示");
    }
}
