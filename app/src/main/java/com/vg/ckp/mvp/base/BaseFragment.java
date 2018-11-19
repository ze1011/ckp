package com.vg.ckp.mvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

public abstract class BaseFragment<T extends IPresenter> extends Fragment {

    public Activity mActivity;
    public T mPresenter;
    // Fragment被创建
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();// 获取所在的activity对象
    }

    // 初始化Fragment布局
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutID(),container,false);
        ScreenAdapterTools.getInstance().loadView(view);
        Log.d("baseF", "onCreateView: ");
        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = createPresenter();
        initView(view);
        initData(view);
        initEvent(view);
    }

    protected abstract T createPresenter();


    /**
     * 设置布局
     * @return
     */
    public abstract int setLayoutID();

    /**
     * 初始化布局
     */
    public void initView(View view){}

    /**
     * 初始化数据, 子类可以不实现
     */
    public void initData(View view) {}

    /**
     * 初始化事件
     * @param view
     */
    public  void initEvent(View view){}

}