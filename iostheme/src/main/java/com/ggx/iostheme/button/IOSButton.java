package com.ggx.iostheme.button;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.ggx.iostheme.R;

/**
 * Created by ggx on 2019/2/12.
 */

public class IOSButton extends android.support.v7.widget.AppCompatTextView {
    public IOSButton(Context context) {
        super(context);
        init(context);
    }

    public IOSButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public IOSButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.setTextColor(getResources().getColor(R.color.color_actionsheet_blue));
    }
}
