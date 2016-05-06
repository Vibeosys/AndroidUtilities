package com.vibeosys.customimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by akshay on 06-05-2016.
 */
public class ImageViewWithBorder extends ImageView {

    private Context mContext;
    private Paint mBorderColour;
    private float borderPadding;

    public ImageViewWithBorder(Context context) {
        super(context);
        mContext = context;
    }

    public ImageViewWithBorder(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs);
    }

    public ImageViewWithBorder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        final TypedArray typedArray = mContext.obtainStyledAttributes(attributeSet, R.styleable.ImageViewWithBorder);

        mBorderColour = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBorderColour.setColor(typedArray.getColor(R.styleable.ImageViewWithBorder_borderColour, Color.BLACK));
        borderPadding = typedArray.getDimension(R.styleable.ImageViewWithBorder_borderPadding, 3);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(borderPadding, borderPadding, getMeasuredWidth() - borderPadding,
                borderPadding, mBorderColour);
        canvas.drawLine(borderPadding, borderPadding, borderPadding, getMeasuredHeight()
                - borderPadding, mBorderColour);
        canvas.drawLine(borderPadding, getMeasuredHeight() - borderPadding, getMeasuredWidth()
                - borderPadding, getMeasuredHeight() - borderPadding, mBorderColour);
        canvas.drawLine(getMeasuredWidth() - borderPadding, borderPadding, getMeasuredWidth()
                - borderPadding, getMeasuredHeight() - borderPadding, mBorderColour);
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
    }
}
