package com.vg.ckp.mvp.plvideo;

import android.content.Context;

import com.vg.ckp.bean.net.ChannelBean;
import com.vg.ckp.mvp.base.BaseModel;
import com.vg.ckp.mvp.base.IPresenter;

public class PLVideoPresenter extends IPresenter<PLVideoView> {

    private final PLVideoModel mModel;

    public PLVideoPresenter(Context context, PLVideoView plVideoView) {
        super(plVideoView);
        mModel = new PLVideoModel(context);
    }

    public void getChannel(){
        mModel.loading(getView().getRecyclerView(),getView().returnName(),new BaseModel.ModelListener<ChannelBean>() {
            @Override
            public void onComplete(ChannelBean bean, String s) {

            }
        });
    }
}
