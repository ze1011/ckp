package com.vg.ckp.mvp.login;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import com.vg.ckp.Constant;
import com.vg.ckp.bean.local.UserBean;
import com.vg.ckp.bean.net.RequestBean;
import com.vg.ckp.http.RetrofitUtils;
import com.vg.ckp.mvp.base.BaseModel;
import com.vg.ckp.utils.LogUtils;
import com.vg.ckp.utils.SPUtil;
import com.vg.ckp.utils.VerifyUtils;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginModel extends BaseModel {
    private static final String TAG = "LoginModel_tag";
    private Context mContext;
    private UserBean mUserBean;
    private EditText username;
    private EditText password;
    public LoginModel(Context context) {
        super(context);
        this.mContext = context;

    }

    public void setUser_Pwd(EditText username, EditText password){
        this.username = username;
        this.password = password;
    }

    @Override
    public String setflag() {
        return "login";
    }


    @Override
    public void loading(final ModelListener listener) {
        super.loading(listener);


        mUserBean = getSPUserBean();


        if (mUserBean == null) {

            mUserBean = getUserBean(username, password ,listener);
            if (mUserBean == null)

                return;
        }


        final RetrofitUtils instance = RetrofitUtils.getInstance(mContext);
        final Subscription subscription =  instance.http()
                .login(mUserBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onTerminateDetach()
                .subscribe(new Subscriber<RequestBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(RequestBean requestBean) {
                        LogUtils.d("onNext");
                        if (Constant.code == (requestBean.getCode()) && Constant.msg.equals(requestBean.getMsg())) {
//                            SPUtil.put(mContext, "username", mUserBean.username);
//                            SPUtil.put(mContext, "password", mUserBean.password);
                            //TODO 设置 token
                            instance.setToken(requestBean.getData().getToken().toString());
                            listener.onComplete(requestBean,null);

                        }else {
                            listener.onComplete(null,requestBean.getCode()+"   :   " +requestBean.getMsg() );
                        }

                    }
                });
        //添加到map 管理subscription
        add(subscription);

    }

    private UserBean getSPUserBean() {
        String username = (String) SPUtil.get(mContext, "username", null);
        String password = (String) SPUtil.get(mContext, "password", null);
        if (username == null) {
            return null;
        }
        if (password != null)
            return null;

        mUserBean.username = username;
        mUserBean.password = password;

        return mUserBean;
    }

    private UserBean getUserBean(EditText username, EditText password,ModelListener listener) {

        String user = username.getText().toString().trim();
        String pwd = password.getText().toString().trim();

        //if (!VerifyUtils.isMobileNumber(user)) {
          //  listener.onComplete(null,"请输入正确的手机号码......");
            //return null;
        //}
        if (pwd == null || pwd.length() == 0) {

            listener.onComplete(null,"密码不能为空");
            return null;
        }
        UserBean bean = new UserBean();
        bean.username = user;
        bean.password = pwd;

        return bean;
    }


}
