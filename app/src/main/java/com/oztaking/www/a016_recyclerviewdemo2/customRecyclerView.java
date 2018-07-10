package com.oztaking.www.a016_recyclerviewdemo2;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @function:
 */

public class customRecyclerView extends RecyclerView{

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

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_MOVE){
            mCurrentView = getChildAt(0);
            if (mListener != null){
                mListener.onChange(mCurrentView,getChildPosition(mCurrentView));
            }
        }

        return super.onTouchEvent(e);
    }
}
