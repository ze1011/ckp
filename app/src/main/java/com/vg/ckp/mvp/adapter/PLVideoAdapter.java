package com.vg.ckp.mvp.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pili.pldroid.player.AVOptions;
import com.vg.ckp.R;
import com.vg.ckp.bean.net.ChannelBean;
import com.vg.ckp.mvp.base.RecyclerViewAdapter;
import com.vg.ckp.mvp.base.RecyclerViewHolder;
import com.vg.ckp.mvp.sec_plvideo_view.PLVideoViewActivity;

import java.util.List;

public class PLVideoAdapter extends RecyclerViewAdapter<ChannelBean.DataBean.ListsBean> {

    public PLVideoAdapter(List<ChannelBean.DataBean.ListsBean> data, int layoutId) {
        super(data, layoutId);
    }

    @Override
    public void onBindData(RecyclerViewHolder holder, ChannelBean.DataBean.ListsBean item, int position) {
        TextView textView = holder.getChildView(R.id.title);
        ImageView img = holder.getChildView(R.id.image);
        textView.setText(item.getTitle());
        Glide.with(mContext).load(item.getImg()).into(img);
        final String play_url = item.getPlay_url();
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,PLVideoViewActivity.class);
                intent.putExtra("videoPath",play_url);
                intent.putExtra("mediaCodec", AVOptions.MEDIA_CODEC_HW_DECODE);
                intent.putExtra("liveStreaming", 1);//直播
                intent.putExtra("cache", false);
                intent.putExtra("loop",false);
                intent.putExtra("video-data-callback", false);
                intent.putExtra("audio-data-callback",false);
                intent.putExtra("disable-log", false);
                mContext.startActivity(intent);
            }
        });
    }
}
