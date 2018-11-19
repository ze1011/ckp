package com.vg.ckp.mvp.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vg.ckp.R;
import com.vg.ckp.bean.net.NetLiveBean;
import com.vg.ckp.mvp.base.RecyclerViewAdapter;
import com.vg.ckp.mvp.base.RecyclerViewHolder;
import com.vg.ckp.mvp.plvideo.PLVideoActivity;

import java.util.List;

public class ZhiboAdapter extends RecyclerViewAdapter<NetLiveBean.DataBean.ListsBean> {
    public ZhiboAdapter(List<NetLiveBean.DataBean.ListsBean> data, int layoutId) {
        super(data, layoutId);
    }

    @Override
    public void onBindData(RecyclerViewHolder holder, final NetLiveBean.DataBean.ListsBean item, final int position) {
        ImageView imageView = holder.getChildView(R.id.image);
        TextView textview = holder.getChildView(R.id.title);
        textview.setText(item.getTitle());
        Glide.with(mContext).load(item.getImg()).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,PLVideoActivity.class);
                intent.putExtra("name", item.getName());
                mContext.startActivity(intent);

            }
        });
    }

}
