package com.oztaking.www.a016_recyclerviewdemo2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @function:
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.Holder> {

    private int[] mArrayPic;
    private String[] mArrayString;
    private Context mContext;
    private final LayoutInflater mInflater;
    private OnItemClickListener mListener;

    public GalleryAdapter(Context context, int[] arrayPic, String[] arrayString) {
        this.mArrayPic = arrayPic;
        this.mArrayString = arrayString;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    // 创建ViewHolder
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recyclerview, parent, false);
        Holder holder = new Holder(view);

        holder.mIv = (ImageView) view.findViewById(R.id.item_iv);
        holder.mTv = (TextView) view.findViewById(R.id.item_tv);


        return holder;
    }

    //设置VIewHolder数据
    @Override
    public void onBindViewHolder(Holder holder, final int position) {

       if (holder != null){
           holder.mIv.setImageResource(mArrayPic[position]);
           holder.mTv.setText(mArrayString[position]);
       }

       if (mListener != null){
           holder.mIv.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   mListener.onItemClick(v,position);
               }
           });

           holder.mTv.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   mListener.onItemClick(v,position);
               }
           });
       }

    }

    @Override
    public int getItemCount() {
        return mArrayString.length;
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView mIv;
        TextView mTv;

        public Holder(View itemView) {
            super(itemView);
        }
    }

    public interface OnItemClickListener{
        public void onItemClick(View view,int postion);
        public void onItemLongClick(View view,int position);
    }
}
