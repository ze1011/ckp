package com.vg.ckp.mvp.login;

import android.content.Context;
import android.widget.EditText;

import com.vg.ckp.Constant;
import com.vg.ckp.bean.net.RequestBean;
import com.vg.ckp.mvp.base.BaseModel;
import com.vg.ckp.mvp.base.IPresenter;
import com.vg.ckp.utils.LogUtils;

public class LoginPresenter<IView> extends IPresenter {
    private static final String TAG = "LoginPresenter_tag";
    private LoginView mView;
    private final LoginModel mModel;
    private static LoginPresenter instance;
    private Context mContext;

    public LoginPresenter(Context context, LoginView view) {
        super(view);
        this.mView = (LoginView) getView();
        this.mContext = context;
        mModel = new LoginModel(context);

    }


    public static LoginPresenter getInstance(Context context, LoginView view) {
        if (instance == null) {
            synchronized (LoginPresenter.class) {
                if (instance == null) {
                    instance = new LoginPresenter(context, view);
                }
            }
        }
        return instance;
    }

    /**
     * 登录
     * @param password 密码
     */
    public void loadLogin(EditText username,EditText password) {
        mModel.setUser_Pwd(username,password);
        mModel.loading(new BaseModel.ModelListener<RequestBean>() {

            @Override
            public void onComplete(RequestBean bean, String s) {

                if (bean == null){

                    mView.Failed(s);
                    return;
                } else {
                    LogUtils.d("msg:成功   "+bean.toString());
                    mView.Success(Constant.msg);

                }
//                if (Constant.code == (bean.getCode()) && Constant.msg.equals(bean.getMsg())) {
//
//                    mView.Success(Constant.msg);
//
//                } else {
//
//                    mView.Failed(bean.getMsg());
//                }

            }

        });
    }

    public void cancel() {
        mModel.cancel();
    }

}
