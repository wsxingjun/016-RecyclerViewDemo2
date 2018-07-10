package com.oztaking.www.a016_recyclerviewdemo2;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * @function: https://blog.csdn.net/lmj623565791/article/details/38173061
 */

public class customRecyclerView extends RecyclerView  { //此处不必再实现接口

    public customRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private View mCurrentView;

    private OnItemScrollChangeListener mListener;


    public void setListener(OnItemScrollChangeListener listener) {
        this.mListener = listener;
    }

    public interface OnItemScrollChangeListener{
        void onChange(View view,int position);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mCurrentView = getChildAt(0);
        if (mListener != null){
            mListener.onChange(mCurrentView,getChildPosition(mCurrentView));
        }
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent e) {
//        if (e.getAction() == MotionEvent.ACTION_MOVE){
//            mCurrentView = getChildAt(0);
//            if (mListener != null){
//                mListener.onChange(mCurrentView,getChildPosition(mCurrentView));
//            }
//        }
//
//        return super.onTouchEvent(e);
//    }

    //【注意】可以直接书写，没有必要实现接口！！！！
    @Override
    public void onScrollStateChanged(int arg0)
    {
    }

    /**
     *
     * 滚动时，判断当前第一个View是否发生变化，发生才回调
     */
    @Override
    public void onScrolled(int arg0, int arg1)
    {
        View newView = getChildAt(0);

        if (mListener != null)
        {
            if (newView != null && newView != mCurrentView)
            {
                mCurrentView = newView ;
                mListener.onChange(mCurrentView,
                        getChildPosition(mCurrentView));

            }
        }

    }


}
