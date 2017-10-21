package com.lyl.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.lyl.administrator.lyl.R;

/**
 * Created by $lyl on 2017/10/21.
 */

public class CircleProgress extends HorizontalProgressBarWithProgress {

    private int mRadius = dp2px(30);
    private int mMaxPaintWidth;

    public CircleProgress(Context context) {
        this(context, null);
    }

    public CircleProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mReachHeight = (int) (mUnReachHeight * 2.5);
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.CircleProgress);
        mRadius = (int) array.getDimension(R.styleable.CircleProgress_radius, mRadius);

        array.recycle();

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mMaxPaintWidth = Math.max(mReachHeight, mUnReachHeight);

        int spec = mRadius * 2 + mMaxPaintWidth + getPaddingLeft() + getPaddingRight();

        int width = resolveSize(spec, widthMeasureSpec);
        int height = resolveSize(spec, heightMeasureSpec);

        int realWidth = Math.min(width, height);

        setMeasuredDimension(realWidth, realWidth);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        //

        String text = getProgress() + "%";
        float textWidth = mPaint.measureText(text);
        float textHeight = (mPaint.descent() + mPaint.ascent()) / 2;

        canvas.save();

        canvas.translate(getPaddingLeft() + mMaxPaintWidth / 2, getPaddingTop() + mMaxPaintWidth / 2);

        mPaint.setStyle(Paint.Style.STROKE);

        //draw UnreachedBar
        mPaint.setStrokeWidth(mMaxPaintWidth);
        mPaint.setColor(mUnReachColor);

        canvas.drawCircle(mRadius, mRadius, mRadius, mPaint);

        //draw reachedBar

        mPaint.setColor(mReachColor);
        mPaint.setStrokeWidth(mReachHeight);

        int sweepAngle = (int) (getProgress() * 1.0f / getMax() * 360);
        canvas.drawArc(new RectF(0, 0, mRadius * 2, mRadius * 2),0,sweepAngle,false,mPaint);

        //draw text
        mPaint.setColor(mTextColor);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(text,mRadius - textWidth/2 ,mRadius - textHeight,mPaint);

        canvas.restore();
    }
}
