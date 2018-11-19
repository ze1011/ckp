package com.vg.ckp.mvp.tab.zhibo;

import android.content.Context;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.vg.ckp.Constant;
import com.vg.ckp.R;
import com.vg.ckp.bean.local.LiveBean;
import com.vg.ckp.bean.net.NetLiveBean;
import com.vg.ckp.http.RetrofitUtils;
import com.vg.ckp.mvp.adapter.ZhiboAdapter;
import com.vg.ckp.mvp.base.BaseModel;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xrecyclerview.hjz.com.ProgressStyle;
import xrecyclerview.hjz.com.XRecyclerView;

public class ZhiboModel extends BaseModel {

    private final List<NetLiveBean.DataBean.ListsBean> mListData;
    private ZhiboAdapter mAdapter;

    public ZhiboModel(Context mContext) {
        super(mContext);
        mListData = new ArrayList<>();

    }



    public LiveBean initLiveBean() {
        LiveBean bean = new LiveBean();
        return bean;
    }

    public void initXRecyclerView(final XRecyclerView mRecyclerView){
        //创建GridLayoutManager
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //设置方向
        gridLayoutManager.setOrientation(StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.mipmap.ic_launcher);
        /**
         * inflate() 方法中 mRecyclerView是header的容器。 因为是添加在mRecyclerView头部。
         */
        View header = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_header,mRecyclerView , false);
        mRecyclerView.addHeaderView(header);

        mAdapter = new ZhiboAdapter(mListData, R.layout.item_recyclerview);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                mRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {

                mRecyclerView.loadMoreComplete();
            }
        });
    }

    @Override
    public String setflag() {
        return "ZhiboModel";
    }

    @Override
    public void loading(final ModelListener listener) {
        super.loading(listener);


        Subscription subscription = RetrofitUtils.getInstance(mContext)
                .http()
                .getLiveItem(initLiveBean())//TODO 请求参数
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onTerminateDetach()
                .subscribe(new Subscriber<NetLiveBean>() {
                    @Override
                    public void onCompleted() {
                        //                        listener.onComplete(null,"ZhiboModel == > 请求结束");
                    }

                    @Override
                    public void onError(Throwable e) {

                        listener.onComplete(null, e.getMessage());
                    }

                    @Override
                    public void onNext(NetLiveBean itemBean) {
                        if (Constant.code == itemBean.getCode()) {

                            if (itemBean.getData().getLists().size() != 0 && itemBean.getData().getLists() != null){
                                mListData.addAll(itemBean.getData().getLists());
                                mAdapter.refresh(mListData);
                            }

                            listener.onComplete(itemBean.getData(), null);
                        } else {
                            listener.onComplete(null, itemBean.getCode() + "  :  " + itemBean.getMsg());
                        }


                    }
                });
        add(subscription);
    }

    public void lunbo() {

    }

    public void showLiveList() {

    }
}
