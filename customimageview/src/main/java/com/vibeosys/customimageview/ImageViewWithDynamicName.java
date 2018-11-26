package com.vibeosys.customimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by akshay on 07-05-2016.
 */
public class ImageViewWithDynamicName extends LinearLayout {

    private ImageView mImageView;
    private TextView mTextView;
    private String mImageName;
    private Context mContext;

    public ImageViewWithDynamicName(Context context) {
        super(context);
    }

    public ImageViewWithDynamicName(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs);
    }

    public ImageViewWithDynamicName(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {

        inflate(mContext, R.layout.image_with_name_layout, this);
        TypedArray array = mContext.obtainStyledAttributes(attributeSet, R.styleable.ImageViewWithDynamicName);
        mImageView = (ImageView) findViewById(R.id.imgImage);
        mTextView = (TextView) findViewById(R.id.imgText);
        mImageName = array.getString(R.styleable.ImageViewWithDynamicName_imageImgText);

        mTextView.setText(mImageName);
        mTextView.setTextColor(array.getColor(R.styleable.ImageViewWithDynamicName_textImgColour, Color.BLACK));
        mTextView.setBackgroundColor(array.getColor(R.styleable.ImageViewWithDynamicName_textImgBackgroundColour, Color.WHITE));
        mTextView.setVisibility(INVISIBLE);

        mImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setVisibility(VISIBLE);
            }
        });
    }

    public void setImageText(String string) {
        mImageName = string;
        //invalidate();
    }
}