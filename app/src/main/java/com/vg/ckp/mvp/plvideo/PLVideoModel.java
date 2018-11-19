package com.vg.ckp.mvp.plvideo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.vg.ckp.Constant;
import com.vg.ckp.R;
import com.vg.ckp.bean.local.AnchorsBean;
import com.vg.ckp.bean.net.ChannelBean;
import com.vg.ckp.http.RetrofitUtils;
import com.vg.ckp.mvp.adapter.PLVideoAdapter;
import com.vg.ckp.mvp.base.BaseModel;
import com.vg.ckp.utils.LogUtils;
import com.vg.ckp.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PLVideoModel extends BaseModel {
    private List<ChannelBean.DataBean.ListsBean> mLists;
    private AnchorsBean mBean;
    private RecyclerView mRecyclerView;
    private PLVideoAdapter mAdapter;

    public PLVideoModel(Context mContext) {
        super(mContext);
        mLists = new ArrayList<>();
    }

    @Override
    public String setflag() {
        return "PLVideoModel";
    }

    public void loading(RecyclerView view, String name, ModelListener listener) {
        this.mRecyclerView = view;
        if (name == null || name == "") {
            listener.onComplete(null, "PLVideoModel name is null");
            return;
        }


        mAdapter = new PLVideoAdapter(mLists, R.layout.item_recyclerview);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        gridLayoutManager.setOrientation(StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mBean = new AnchorsBean();
        mBean.setName(name);
        loading(listener);
    }


    public void notifyDataSetChanged(){

        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void loading(final ModelListener listener) {
        super.loading(listener);

        RetrofitUtils.getInstance(mContext).http()
                .getChannelBean(mBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onTerminateDetach()
                .subscribe(new Subscriber<ChannelBean>() {


                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.d("error   " + e.getMessage());
                    }

                    @Override
                    public void onNext(ChannelBean bean) {
                        ToastUtil.showToast(mContext,"PLVideoModel  :::   ::  "+bean.toString());
                        if (bean.getCode() == Constant.code) {
                            
                            mLists.addAll(bean.getData().getLists());
                            for (int i = 0; i < mLists.size(); i++) {
                                String play_url = mLists.get(i).getPlay_url();
                               if (play_url.endsWith(".flv")){
                                   mLists.remove(i);
                               }
                            }

                            notifyDataSetChanged();//更新
                        }else {
                            listener.onComplete(null, bean.getCode() + "  :  " + bean.getMsg());
                        }
                    }
                });

    }
}
