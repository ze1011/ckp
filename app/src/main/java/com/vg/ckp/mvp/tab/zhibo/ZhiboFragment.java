package com.vg.ckp.mvp.tab.zhibo;

import android.view.View;
import android.widget.TextView;

import com.vg.ckp.R;
import com.vg.ckp.bean.net.NetLiveBean;
import com.vg.ckp.mvp.base.BaseFragment;
import com.vg.ckp.utils.LogUtils;

import xrecyclerview.hjz.com.XRecyclerView;

public class ZhiboFragment extends BaseFragment<ZhiboPresenter> implements ZhiboView {

    private XRecyclerView mRecyclerView;

    @Override
    protected ZhiboPresenter createPresenter() {
        ZhiboPresenter presenter = new ZhiboPresenter(mActivity, this);
        return presenter;
    }

    @Override
    public int setLayoutID() {
        return R.layout.fragment_zhibo;
    }


    @Override
    public void initView(View view) {
        super.initView(view);
        mRecyclerView = (XRecyclerView) view.findViewById(R.id.recyclerview);

        TextView viewById = view.findViewById(R.id.tv);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public void initData(View view) {
        super.initData(view);
    }


    @Override
    public void initEvent(View view) {
        super.initEvent(view);

        //
        ((ZhiboPresenter) mPresenter).requestLive();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void Success(String s) {
        LogUtils.d("success");
    }

    @Override
    public void Failed(String e) {
        LogUtils.d("failed  " + e);
    }

    @Override
    public void result(NetLiveBean.DataBean bean) {

    }

    @Override
    public XRecyclerView getXRecyclerView() {
        return mRecyclerView;
    }

    @Override
    public void onDestroy() {
        ((ZhiboPresenter) mPresenter).cancel();
        ((ZhiboPresenter) mPresenter).detachView();
        super.onDestroy();
    }
}
