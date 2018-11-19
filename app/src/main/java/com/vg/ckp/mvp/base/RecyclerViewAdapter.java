package com.vg.ckp.mvp.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vg.ckp.R;

import java.util.List;

/**
 * 封装RecyclerViewAdapter
 */
public abstract class RecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<T> data;
    private int layoutId;
    public RecyclerViewAdapter(List<T> data, int layoutId){
        this.data = data;
        this.layoutId = layoutId;
    }
    public Context mContext;
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview,parent,false);

        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        onBindData(holder,data.get(position),position);
    }

    @Override
    public int getItemCount() {
        return data.size();

    }

    public void refresh(List<T> data) {
        try {
            this.data = data;
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 继承者 添写时面的数据
     * @param holder 缓存
     * @param item  对于的条目
     * @param position 列表对应的角标
     */
    public abstract void onBindData(RecyclerViewHolder holder,T item,int position);

    /**
     * 多种Item重写这个方法
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
