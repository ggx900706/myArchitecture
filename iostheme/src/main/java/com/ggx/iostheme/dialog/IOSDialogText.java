package com.ggx.iostheme.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ggx.iostheme.R;

/**
 * Created by ggx on 2019/2/12.
 */

public class IOSDialogText extends IOSDialog {
    boolean vertical = false;

    public IOSDialogText() {

    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        parentView = inflater.inflate(vertical ? R.layout.dialog_center_text_vertical : R.layout.dialog_center_text, container, false);
        contentTV = parentView.findViewById(R.id.centerDialog_text);
        titleTV = parentView.findViewById(R.id.centerDialog_title);
        leftBtn = parentView.findViewById(R.id.centerDialog_leftBtn);
        rightBtn = parentView.findViewById(R.id.centerDialog_rightBtn);
        centerBtn = parentView.findViewById(R.id.centerDialog_centerBtn);
        sap1 = parentView.findViewById(R.id.centerDialog_sap1);
        sap2 = parentView.findViewById(R.id.centerDialog_sap2);

        if (messageStr == null)
            contentTV.setVisibility(View.GONE);
        else {
            contentTV.setText(messageStr);
            contentTV.setVisibility(View.VISIBLE);
        }
        titleTV.setText(titleStr);

        //render buttons
        if ((!leftBtnShow) && (!rightBtnShow) && (!centerBtnShow)) {
            leftBtn.setVisibility(View.VISIBLE);
            leftBtn.setText("返回");
            leftBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        } else {
            if (leftBtnShow) {
                leftBtn.setVisibility(View.VISIBLE);
                leftBtn.setText(leftBtnTextStr);
                leftBtn.setOnClickListener(v -> {
                    leftBtnOnClick.onClick(v);
                    dismiss();
                });
            } else {
                leftBtn.setVisibility(View.GONE);
            }
            if (rightBtnShow) {
                rightBtn.setVisibility(View.VISIBLE);
                rightBtn.setText(rightBtnTextStr);
                rightBtn.setOnClickListener(v -> {
                    rightBtnOnClick.onClick(v);
                    dismiss();
                });
            } else {
                rightBtn.setVisibility(View.GONE);
            }
            if (centerBtnShow) {
                centerBtn.setVisibility(View.VISIBLE);
                centerBtn.setText(centerBtnTextStr);
                centerBtn.setOnClickListener(v -> {
                    centerBtnOnClick.onClick(v);
                    dismiss();
                });
            } else {
                centerBtn.setVisibility(View.GONE);
            }
        }

        //render saperaters
        sap1.setVisibility(View.GONE);
        sap2.setVisibility(View.GONE);

        if (leftBtnShow) {
            if (rightBtnShow || centerBtnShow) {
                sap1.setVisibility(View.VISIBLE);
            } else {
                sap1.setVisibility(View.GONE);
            }
        }
        if (centerBtnShow) {
            if (rightBtnShow) {
                sap2.setVisibility(View.VISIBLE);
            } else {
                sap2.setVisibility(View.GONE);
            }
        }
        return parentView;
    }
}
