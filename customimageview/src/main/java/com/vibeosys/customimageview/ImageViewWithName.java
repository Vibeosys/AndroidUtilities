package com.vibeosys.customimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by akshay on 06-05-2016.
 */
public class ImageViewWithName extends LinearLayout {

    private ImageView mImageView;
    private TextView mTextView;
    private String mImageName;
    private Context mContext;

    public ImageViewWithName(Context context) {
        super(context);
    }

    public ImageViewWithName(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs);
    }

    public ImageViewWithName(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {

        inflate(mContext, R.layout.image_with_name_layout, this);
        TypedArray array = mContext.obtainStyledAttributes(attributeSet, R.styleable.ImageViewWithName);
        mImageView = (ImageView) findViewById(R.id.imgImage);
        mTextView = (TextView) findViewById(R.id.imgText);
        mImageName = array.getString(R.styleable.ImageViewWithName_imageText);

        mTextView.setText(mImageName);
        mTextView.setTextColor(array.getColor(R.styleable.ImageViewWithName_textColour, Color.BLACK));
        mTextView.setBackgroundColor(array.getColor(R.styleable.ImageViewWithName_textBackgroundColour, Color.WHITE));
    }

    public void setImageText(String string) {
        mImageName = string;
        //invalidate();
    }
}
