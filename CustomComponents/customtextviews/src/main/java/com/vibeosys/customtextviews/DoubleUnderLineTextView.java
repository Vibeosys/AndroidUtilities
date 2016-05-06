package com.vibeosys.customtextviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by akshay on 06-05-2016.
 */
public class DoubleUnderLineTextView extends TextView {

    private Paint mLinePaint;
    private int mLineSpace;
    private Context mContext;

    public DoubleUnderLineTextView(Context context) {
        super(context);
        mContext = context;
    }

    public DoubleUnderLineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs);
    }

    public DoubleUnderLineTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        final TypedArray a = mContext.obtainStyledAttributes(attributeSet, R.styleable.DoubleUnderLineTextView);
        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setColor(a.getColor(R.styleable.DoubleUnderLineTextView_underlineColor, Color.BLACK));
        mLineSpace = (int) a.getDimension(R.styleable.DoubleUnderLineTextView_underlineSpace, 2);
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = (getPaddingBottom() == 0) ? 2 : getPaddingBottom();
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), mLinePaint);
        canvas.drawLine(0, getMeasuredHeight() - mLineSpace, getMeasuredWidth(), getMeasuredHeight() - mLineSpace, mLinePaint);
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
    }
}
