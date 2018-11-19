package com.vg.ckp.mvp.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

public abstract class BaseActivity<IView> extends AppCompatActivity {
    private static final String TAG = "BaseActivity_tag";

    public boolean flag = false;
    protected IPresenter<IView> mPresenter;
    private Toast mToast;
    private boolean isShowTitle = false; //是否显示标题栏
    private boolean isShowState = false;//是否显示状态栏
    private boolean isSetStatusBar = false;//是否设置沉浸状态栏

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!isShowTitle) {
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        if (isShowState) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        if (isSetStatusBar){
            steepStatusBar();
        }
        setContentView(getContentView());

        ScreenAdapterTools.getInstance().reset(this);//如果希望android7.0分屏也适配的话,加上这句
        //在setContentView();后面加上适配语句
        ScreenAdapterTools.getInstance().loadView(getWindow().getDecorView());

        mPresenter = createPresenter();

        initView();
        initData();
        initEvent();


    }

    protected abstract IView addView();


    /**
     * 设置继承的子类标记 方便管理
     * @return
     */

    /**
     * 初始化id
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化事件
     */
    protected abstract void initEvent();

    /***
     * 获取布局资源文件
     * @return xml 布局资源文件
     */
    protected abstract int getContentView();

    public abstract IPresenter<IView> createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }

    /**
     * 是否设置标题栏
     *
     * @return
     */
    public void setTitle(boolean ishow) {
        isShowTitle=ishow;
    }

    /**
     * 设置是否显示状态栏
     * @param ishow
     */
    public void setState(boolean ishow) {
        isShowState=ishow;
    }

    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 是否设置沉浸状态栏
     * @param isSetStatusBar
     */
    public void setSteepStatusBar(boolean isSetStatusBar) {
        this.isSetStatusBar = isSetStatusBar;
    }


    /**
     *  带参数启动
     * @param cls  activity
     * @param bundle 参数
     */
    protected void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 不带参数启动
     * @param cls activity
     */
    protected void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * startActivityForResult => 带参数 带请求码  启动
     * @param cls activity
     * @param bundle 参数
     * @param requestCode 请求码
     */
    protected void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult => 带请求码 启动
     * @param cls activity
     * @param requestCode   请求码
     */
    protected void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 获取bundle对象
     * @return bundle
     */
    protected Bundle getIntentExtra() {
        Intent intent = getIntent();
        Bundle bundle = null;
        if (null != intent)
            bundle = intent.getExtras();
        return bundle;
    }
}
