package com.vg.ckp.mvp.base;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * 基本封装
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    private TextView mTextView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
    }

    public <T extends View> T getChildView(int id){
        return itemView.findViewById(id);
    }

    public TextView setText(int viewId,String text){
        mTextView = getChildView(viewId);
        mTextView.setText(text);
        return mTextView;
    }
    public RecyclerViewHolder setTextSize(int size){
        mTextView.setTextColor(size);
        return this;
    }

    public RecyclerViewHolder setTextColor(String color){
        mTextView.setTextColor(Color.parseColor(color));
        return this;
    }
}
