package kr.sylark.recyclerviewtestapp;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class ItemView extends LinearLayout {
    public ItemView(Context context) {
        super(context);
    }

    public ItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private View icon;
    private View check;
    private View name;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        icon = findViewById(kr.pe.sylark.recyclerviewtestapp.R.id.icon);
        check = findViewById(kr.pe.sylark.recyclerviewtestapp.R.id.check);
        name = findViewById(kr.pe.sylark.recyclerviewtestapp.R.id.name);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);



    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        int[] loc = new int[2];
        this.getLocationOnScreen(loc);

        int[] checkLoc = new int[2];
        check.getLocationOnScreen(checkLoc);

        int[] nameLoc = new int[2];
        name.getLocationOnScreen(nameLoc);

        int height = check.getMeasuredHeight();
        int offsetY = (int) (height * 0.5f);

        if(checkLoc[1] - loc[1] < offsetY) {
            offsetY = checkLoc[1] - loc[1];
        }

        check.setTranslationY(-offsetY);


        Log.d("AAAAAAAA" ,+ loc[1] + " " + checkLoc[1] + " " +  nameLoc[1] + " " + height);



    }
}
