package com.ggx.iostheme.dialog;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.ggx.iostheme.R;
import com.ggx.iostheme.button.IOSButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggx on 2019/2/12.
 */

public class IOSDialogList extends IOSDialog {
    ScrollView scrollView;
    LinearLayout linearLayout;

    List<IOSButton> iosButtons = new ArrayList<>();
    int width;

    public IOSDialogList() {

    }

    @Override
    public void setActivity(Activity activity) {
        super.setActivity(activity);
        WindowManager wm = activity.getWindowManager();
        width = wm.getDefaultDisplay().getWidth() - 40;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        parentView = inflater.inflate(R.layout.dialog_center_list, container, false);
        titleTV = parentView.findViewById(R.id.centerDialog_title);
        contentTV = parentView.findViewById(R.id.centerDialog_text);
        centerBtn = parentView.findViewById(R.id.centerDialog_centerBtn);
        scrollView = parentView.findViewById(R.id.centerDialog_sv);
        linearLayout = parentView.findViewById(R.id.centerDialog_ll);

        if (messageStr == null)
            contentTV.setVisibility(View.GONE);
        else {
            contentTV.setText(messageStr);
            contentTV.setVisibility(View.VISIBLE);
        }
        titleTV.setText(titleStr);
        for (int i = 0; i < iosButtons.size(); i++) {
            View view = new View(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, 1);
            view.setLayoutParams(layoutParams);
            view.setBackgroundColor(activity.getResources().getColor(R.color.text_color_light_gray));
            linearLayout.addView(view);
            IOSButton iosButton = iosButtons.get(i);
            linearLayout.addView(iosButton);
        }

        //render buttons
        centerBtn.setVisibility(View.VISIBLE);
        centerBtn.setText("返回");
        centerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        parentView.setMinimumWidth(width);
        return parentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.windowAnimations = R.style.dialogWindowAnim;
        layoutParams.gravity = Gravity.BOTTOM;
    }

    @Override
    protected void setLeftBtn(String text, View.OnClickListener onClickListener) {
        addButton(text, onClickListener);
    }

    @Override
    protected void setRightBtn(String text, View.OnClickListener onClickListener) {
        addButton(text, onClickListener);
    }

    @Override
    protected void addButton(String text, View.OnClickListener onClickListener) {
        IOSButton iosButton = new IOSButton(activity);
        iosButton.setText(text);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, 50);
        iosButton.setLayoutParams(layoutParams);
        iosButton.setGravity(Gravity.CENTER);
        iosButton.setOnClickListener(v -> {
            onClickListener.onClick(v);
            dismiss();
        });
        iosButtons.add(iosButton);
    }
}
