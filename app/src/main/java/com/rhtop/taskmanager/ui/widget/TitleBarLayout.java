package com.rhtop.taskmanager.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.rhtop.taskmanager.R;

/**
 * Created by bobowich
 * Time: 2017/2/14.
 */

public class TitleBarLayout extends FrameLayout implements View.OnClickListener {

    private TitleBarListener mListener;
    //默认标题字体大小
    private static final int DEFAULT_TITLE_TEXT_SIZE = 30;

    //默认功能按钮字体大小
    private static final int DEFAULT_FUNC_TEXT_SIZE = 28;

    //默认字体颜色
    private static final int DEFAULT_TEXT_COLOR = Color.parseColor("white");

    //默认标题文字
    private static final String DEFAULT_TITLE_TEXT="标题";

    //默认背景颜色
    private static final int DEFAULT_BG_COLOR = R.color.main_color;

    //默认功能按钮文字
    private static final String DEFAULT_FUNC_TEXT = "功能";

    //默认显示后退键,功能键
    private static final boolean DEFAULT_SHOW= true;
    //标题字体大小
    private float titleTextSize;

    //功能按钮字体大小
    private float funcTextSize;

    //字体颜色
    private int textColor;

    //标题字体内容
    private String titleText;

    //功能按钮文字内容
    private String funcText;

    //是否显示后退键
    private boolean isShowBackArrow;

    //是否显示功能按钮
    private boolean isShowFuncText;

    //背景颜色
    private int bgColor;


    private ImageView btBack;

    private TextView tvTitle;

    private TextView tvFunc;

    LayoutInflater inflater;

    Context mContext;

    public TitleBarLayout(Context context) {
        this(context, null);
    }

    public TitleBarLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.TitleBarLayout, defStyleAttr, 0);
        titleTextSize = ta.getDimension(R.styleable.TitleBarLayout_title_size
                , DEFAULT_TITLE_TEXT_SIZE);
        funcTextSize = ta.getDimension(R.styleable.TitleBarLayout_func_size, DEFAULT_FUNC_TEXT_SIZE);
        textColor = ta.getColor(R.styleable.TitleBarLayout_text_color, DEFAULT_TEXT_COLOR);
        titleText = ta.getString(R.styleable.TitleBarLayout_title_text_string);
        funcText = ta.getString(R.styleable.TitleBarLayout_func_text_string);
        isShowBackArrow = ta.getBoolean(R.styleable.TitleBarLayout_show_back_arrow, DEFAULT_SHOW);
        isShowFuncText = ta.getBoolean(R.styleable.TitleBarLayout_show_func_text, DEFAULT_SHOW);
        bgColor = ta.getColor(R.styleable.TitleBarLayout_bg_color, getResources().getColor(DEFAULT_BG_COLOR));
        ta.recycle();

        initView();

    }

    private void initView() {
        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.layout_title_bar, this);
        btBack = (ImageView) view.findViewById(R.id.iv_back);
        if (!isShowBackArrow) {
            btBack.setVisibility(GONE);
        } else {
            btBack.setOnClickListener(this);
        }

        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvTitle.setText(titleText == null ? DEFAULT_TITLE_TEXT : titleText);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setTextColor(textColor);

        tvFunc = (TextView) view.findViewById(R.id.tv_func);
        if (isShowFuncText) {
            tvFunc.setText(funcText == null ? DEFAULT_FUNC_TEXT : funcText);
            tvFunc.setTextSize(funcTextSize);
            tvFunc.setTextColor(textColor);
            setOnClickListener(this);
        } else {
            tvFunc.setVisibility(GONE);
        }
        setBackgroundColor(bgColor);
        invalidate();
    }

    public void setTitleBarListener(TitleBarListener listener) {
        mListener = listener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                if (mListener != null) {
                    mListener.onBackClick();
                }
                break;
            case R.id.tv_func:
                if (mListener != null) {
                    mListener.onFuncClick();
                }
                break;
            default:
                break;
        }
    }

    public interface TitleBarListener {
        //后退键事件回调
        void onBackClick();

        //功能键点击事件回调
        void onFuncClick();
    }
}
