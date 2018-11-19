package com.vg.ckp.mvp.tab.zhibo;

import com.vg.ckp.bean.net.NetLiveBean;
import com.vg.ckp.mvp.base.IView;

import xrecyclerview.hjz.com.XRecyclerView;

public interface ZhiboView extends IView {

    void result(NetLiveBean.DataBean bean);
    XRecyclerView getXRecyclerView();
}
