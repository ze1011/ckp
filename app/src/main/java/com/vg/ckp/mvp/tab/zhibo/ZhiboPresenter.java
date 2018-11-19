package com.vg.ckp.mvp.tab.zhibo;

import android.content.Context;

import com.vg.ckp.bean.local.LiveBean;
import com.vg.ckp.bean.net.NetLiveBean;
import com.vg.ckp.mvp.base.BaseModel;
import com.vg.ckp.mvp.base.IPresenter;
import com.vg.ckp.utils.LogUtils;

public class ZhiboPresenter extends IPresenter<ZhiboView> {

    private final ZhiboModel mModel;
    private LiveBean mLiveBean;
    private ZhiboView mZhiboView;

    public ZhiboPresenter(Context mContext, ZhiboView zhiboView) {
        super(zhiboView);
        this.mZhiboView = (ZhiboView)getView();
        mModel = new ZhiboModel(mContext);

    }



    public void requestLive(){
        mModel.initXRecyclerView(mZhiboView.getXRecyclerView());
        mModel.loading(new BaseModel.ModelListener<NetLiveBean.DataBean>() {

            @Override
            public void onComplete(NetLiveBean.DataBean bean, String s) {
                LogUtils.d(bean.toString());
                if (bean == null){
                    mZhiboView.Failed(s);
                }else {


                    mZhiboView.Success("正在加载中...");
                }
            }
        });

    }

    public void cancel() {
        mModel.cancel();
    }

}
