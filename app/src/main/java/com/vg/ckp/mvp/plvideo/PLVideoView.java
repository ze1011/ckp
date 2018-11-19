package com.vg.ckp.mvp.plvideo;

import android.support.v7.widget.RecyclerView;

import com.vg.ckp.mvp.base.IView;

public interface PLVideoView  extends IView {

    String returnName();
    RecyclerView getRecyclerView();
}
