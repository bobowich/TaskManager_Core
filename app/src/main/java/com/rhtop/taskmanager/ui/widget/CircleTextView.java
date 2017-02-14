package com.rhtop.taskmanager.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.rhtop.taskmanager.R;

/**
 * Created by bobowich
 * Time: 2017/2/13.
 */

public class CircleTextView extends View {
    //当前View的默认大小
    private int size;

    //圆形的Paint
    private Paint circlePaint;

    //字体的Paint
    private Paint textPaint;

    //默认圆形的颜色
    private static final int DEFAULT_CIRCLE_COLOR = Color.parseColor("red");

    //默认文字的颜色
    private static final int DEFAULT_TEXT_COLOR = Color.parseColor("white");

    //默认文字的大小
    private static final float DEFAULT_TEXT_SIZE = 60.0f;

    //默认文字和圆形的大小比率
    private static final float DEFAULT_CIRCLE_TEXT_RATIO = 5.0f;

    //默认文字
    private static final String DEFAULT_TEXT_CONTENT = "姓名";

    //圆形的颜色
    private int circleColor;

    //文字的内容
    private String textContent;

    //文字的颜色
    private int textColor;

    //字体的大小
    private float textSize;

    //circle:text 圆形半径与字体大小的比率
    private float circleTextRatio;



    public CircleTextView(Context context) {
        this(context,null);
    }

    public CircleTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CircleTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CircleTextView, defStyleAttr, defStyleRes);
        circleColor = ta.getColor(R.styleable.CircleTextView_circleColor, DEFAULT_CIRCLE_COLOR);
        textContent = TextUtils.isEmpty(ta.getString(R.styleable.CircleTextView_textContent))?DEFAULT_TEXT_CONTENT
                :ta.getString(R.styleable.CircleTextView_textContent);
        textColor = ta.getColor(R.styleable.CircleTextView_textColor, DEFAULT_TEXT_COLOR);
        textSize = ta.getDimension(R.styleable.CircleTextView_textSize, DEFAULT_TEXT_SIZE);
        circleTextRatio = ta.getFloat(R.styleable.CircleTextView_circleTextRatio, DEFAULT_CIRCLE_TEXT_RATIO);
        ta.recycle();
        init();
    }

    private void init() {
        //初始化圆形画笔
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(circleColor);

        //初始化文字画笔
        textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setStrokeWidth(2);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);

        //初始化view的大小
        size = (int) (textSize * circleTextRatio);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //用于测量文字内容的宽高
        Rect textBound = new Rect();

        int width = getWidth();
        int height = getHeight();
        int radius = width/2;
        canvas.drawCircle(width / 2, height / 2, radius, circlePaint);
        textPaint.getTextBounds(textContent, 0, textContent.length(), textBound);
        canvas.drawText(textContent, width / 2 - textBound.width() / 2,
                height / 2 + textBound.height() / 2, textPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int viewSize = Math.min(getAdjustdSize(widthMeasureSpec), getAdjustdSize(heightMeasureSpec));
        //保证图形为正方形
        setMeasuredDimension(viewSize,viewSize);
    }

    /**
     * 修正自定义View 的大小问题，直接继承自View的自定义View，如果不处理MeasureSpec.AT_MOST的
     * 情况，与MATCH_PARENT效果相同
     * @param measureSpec
     * @return 修正过后的大小
     */
    public int getAdjustdSize(int measureSpec) {

        int result;
        int specSize = MeasureSpec.getSize(measureSpec);
        int specMode = MeasureSpec.getMode(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = size;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(size,specSize);
            }
        }
        return result;
    }
}
