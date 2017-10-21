package com.lyl.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;

import com.lyl.administrator.lyl.R;

/**
 * Created by $lyl on 2017/10/20.
 */

public class HorizontalProgressBarWithProgress extends ProgressBar {

    private static final int DEFAULT_TEXT_SIZE = 10;//sp

    private static final int DEFAULT_TEXT_COLOR = Color.BLUE;

    public static final int DEFAULT_COLOR_UNREACH = Color.GRAY;

    public static final int DEFAULT_HEIGHT_UNREACH = 2;//dp

    public static final int DEFAULT_COLOR_REACH = Color.BLUE;

    public static final int DEFAULT_HEIGHT_REACH = 2;//dp

    public static final int DEFAULT_TEXT_OFFSET = 10;//dp

    protected int mTextSize = sp2px(DEFAULT_TEXT_SIZE);
    protected int mTextColor = DEFAULT_TEXT_COLOR;
    protected int mUnReachColor = DEFAULT_COLOR_UNREACH;
    protected int mUnReachHeight = dp2px(DEFAULT_HEIGHT_UNREACH);
    protected int mReachColor = DEFAULT_COLOR_REACH;
    protected int mReachHeight = dp2px(DEFAULT_HEIGHT_REACH);
    protected int mTextOffset = dp2px(DEFAULT_TEXT_OFFSET);

    protected Paint mPaint;
    protected int mRealWidth;

    public HorizontalProgressBarWithProgress(Context context) {
        this(context, null);
    }

    public HorizontalProgressBarWithProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalProgressBarWithProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        obtainStyleAttrs(attrs);
    }

    private void obtainStyleAttrs(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs,
                R.styleable.HorizontalProgressBarWithProgress);
        mTextSize = (int) array.getDimension(R.styleable.HorizontalProgressBarWithProgress_progress_textSize, DEFAULT_TEXT_SIZE);
        mTextColor = array.getColor(R.styleable.HorizontalProgressBarWithProgress_progress_textColor, DEFAULT_TEXT_COLOR);
        mReachColor = array.getColor(R.styleable.HorizontalProgressBarWithProgress_progress_reach_color, DEFAULT_COLOR_REACH);
        mReachHeight = (int) array.getDimension(R.styleable.HorizontalProgressBarWithProgress_progress_reach_height, DEFAULT_HEIGHT_REACH);
        mUnReachColor = array.getColor(R.styleable.HorizontalProgressBarWithProgress_progress_unreach_color, DEFAULT_COLOR_UNREACH);
        mUnReachHeight = (int) array.getDimension(R.styleable.HorizontalProgressBarWithProgress_progress_unreach_height, DEFAULT_HEIGHT_UNREACH);
        mTextOffset = array.getDimensionPixelOffset(R.styleable.HorizontalProgressBarWithProgress_progress_offset, DEFAULT_TEXT_OFFSET);

        array.recycle();
        mPaint.setTextSize(mTextSize);

    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //int widthMode = MeasureSpec.getMode(widthMeasureSpec); 水平的先不用
        int widthValue = MeasureSpec.getSize(widthMeasureSpec);

        int height = measureHeight(heightMeasureSpec);

        setMeasuredDimension(widthValue,height);
        mRealWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    }

    private int measureHeight(int heightMeasureSpec) {
        int result = 0;
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightValue = MeasureSpec.getSize(heightMeasureSpec);


        if( heightMode == MeasureSpec.EXACTLY){
            result = heightValue;
        }else {
            int textHeight = (int) (mPaint.descent() - mPaint.ascent());

            result = getPaddingTop() + getPaddingBottom()
                    +Math.max(Math.max(mReachHeight,mUnReachHeight),Math.abs(textHeight));
        }

        if (heightMode == MeasureSpec.AT_MOST){
            result = Math.min(result,heightValue);
        }
        return result;
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft(),getHeight()/2);

        boolean noNeedUnreach = false;
        float radio = getProgress() *1.0f / getMax();
        String text = getProgress() + "%";
        float progressX = radio * mRealWidth;
        int textWidth = (int) mPaint.measureText(text);

        if(progressX + textWidth > mRealWidth){
            progressX = mRealWidth -textWidth;
            noNeedUnreach = true;
        }

        float endX =  progressX - mTextOffset/2;
        if (endX >0){
            mPaint.setColor(mReachColor);
            mPaint.setStrokeWidth(mReachHeight);
            canvas.drawLine(0,0,endX,0,mPaint);
        }

        //draw text;
        mPaint.setColor(mTextColor);
        int y = (int) (-(mPaint.descent() + mPaint.ascent()) /2);
        canvas.drawText(text,progressX,y,mPaint);

        //draw unreach

        if(! noNeedUnreach){
            float start = progressX + textWidth + mTextOffset/2;
            mPaint.setColor(mUnReachColor);
            mPaint.setStrokeWidth(mUnReachColor);
            canvas.drawLine(start,0,mRealWidth,0,mPaint);
        }


        canvas.restore();


    }

    protected int dp2px(int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal,
                getResources().getDisplayMetrics());
    }

    protected int sp2px(int spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal,
                getResources().getDisplayMetrics());
    }


}
