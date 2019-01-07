package com.vg.ckp;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.SaveCallback;
import com.vg.ckp.View.BottomBar;
import com.vg.ckp.mvp.base.BaseActivity;
import com.vg.ckp.mvp.base.IPresenter;
import com.vg.ckp.mvp.login.LoginView;
import com.vg.ckp.mvp.tab.findnew.FindNewFragment;
import com.vg.ckp.mvp.tab.yunbo.YunboFragment;
import com.vg.ckp.mvp.tab.zhibo.ZhiboFragment;
import com.vg.ckp.utils.MobileInfoUtil;

import java.util.List;


public class MainActivity extends BaseActivity implements LoginView {

    private static final String TAG = "MainActivity_tag";


    @Override
    protected MainActivity addView() {
        return this;
    }

    @Override
    protected void initView() {

        BottomBar bar = findViewById(R.id.bottom_bar);
        bar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                .setIconHeight(23)
                .setIconWidth(23)
                .setTitleSize(15)
                .setTitleIconMargin(5)
                .addItem(ZhiboFragment.class, "直播", R.mipmap.live_xz, R.mipmap.live_wxz)
                .addItem(YunboFragment.class, "云播", R.mipmap.yunbo_xz, R.mipmap.yunbo_wxz)
                .addItem(FindNewFragment.class, "发现", R.mipmap.yingshi_xz, R.mipmap.yingshi_wxz)
                .addItem(YunboFragment.class, "我的", R.mipmap.wode_xz, R.mipmap.wode_wxz)
                .build();
    }

    @Override
    protected void initData() {
//        ((LoginPresenter)mPresenter).loadLogin(null,null);
    }

    @Override
    protected void initEvent() {
//        ((LoginPresenter)mPresenter).detachView();//断开
//        mPresenter = null;//测试用
        //获取imei号生成用户唯一信息
        final String imei = MobileInfoUtil.getIMEI(this);
        if (null != imei) {
            //查询imei号是否存在，不存在新增一个用户
            AVQuery<AVObject> avQuery = new AVQuery<>(Constant.TABLE_USER_INFO);
            avQuery.whereEqualTo(Constant.TABLE_USER_INFO_ITEM_IMEI, imei);
            avQuery.findInBackground(new FindCallback<AVObject>() {
                @Override
                public void done (List<AVObject> avObjects, AVException avException) {
                    if (null == avObjects || avObjects.isEmpty()) {
                        AVObject todo = new AVObject(Constant.TABLE_USER_INFO);
                        todo.put("imei", imei);
                        todo.saveInBackground(new SaveCallback() {
                            @Override
                            public void done (AVException e) {
                                if (null == e) {
                                    //生成账号成功
                                    
                                }
                            }
                        });
                    } else {
                    
                    }
                }
            });
        }
    }
    
    

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public IPresenter createPresenter() {

//        LoginPresenter instance = LoginPresenter.getInstance(this.getApplicationContext(),this);
        return null;
    }



    @Override
    public void showDialog() {

    }

    @Override
    public void Success(String s) {

    }

    @Override
    public void Failed(String e) {
//        if (Constant.e.equals(e)){
//            ((LoginPresenter)mPresenter).detachView();//断开
//            mPresenter = null;//设置这个为null 断开这个activity与LoginPresenter联系
//            Log.d(TAG, "mPresenter: ");
//            startActivity(LoginActivity.class);
//        }

    }

    @Override
    protected void onResume() {


        super.onResume();
    }
}