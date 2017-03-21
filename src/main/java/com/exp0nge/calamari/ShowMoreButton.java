package com.exp0nge.calamari;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ShowMoreButton extends android.support.v7.widget.AppCompatButton implements View.OnClickListener {
    private enum STATE {COLLAPSED, EXPANDED}

    ;
    private STATE state;
    private int originalHeight;


    public ShowMoreButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ShowMoreButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShowMoreButton(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.state = STATE.COLLAPSED;
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        View view = v.getRootView().findViewById(
                getResources()
                        .getIdentifier(this.getTag().toString(), "id", getContext()
                                .getPackageName()));
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (this.state == STATE.COLLAPSED) {
            this.originalHeight = params.height;
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            this.setText(R.string.show_less);
            this.state = STATE.EXPANDED;
        } else {
            params.height = this.originalHeight;
            this.setText(R.string.show_more);
            this.state = STATE.COLLAPSED;
        }
        view.setLayoutParams(params);
    }
}