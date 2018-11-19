package com.vg.ckp.mvp.plvideo;

import android.support.v7.widget.RecyclerView;

import com.vg.ckp.R;
import com.vg.ckp.mvp.base.BaseActivity;
import com.vg.ckp.mvp.base.IPresenter;

public class PLVideoActivity extends BaseActivity implements PLVideoView{


    private String mName;
    private RecyclerView mRecyclerView;

    @Override
    protected PLVideoActivity addView() {
        return this;
    }

    @Override
    protected void initView() {
        mName = getIntent().getStringExtra("name");
        mRecyclerView = findViewById(R.id.recyclerview);
        ( (PLVideoPresenter)mPresenter).getChannel();
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initEvent() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_plvideo;
    }

    @Override
    public IPresenter createPresenter() {
        PLVideoPresenter presenter = new PLVideoPresenter(PLVideoActivity.this,this);
        return presenter;
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void Success(String s) {

    }

    @Override
    public void Failed(String e) {

    }

    @Override
    public String returnName() {
        return mName;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }
}
