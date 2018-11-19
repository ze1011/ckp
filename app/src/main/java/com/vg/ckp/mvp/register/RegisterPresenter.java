package com.vg.ckp.mvp.register;

import android.content.Context;

import com.vg.ckp.Constant;
import com.vg.ckp.bean.net.RegisterResponse;
import com.vg.ckp.mvp.base.BaseModel;
import com.vg.ckp.mvp.base.IPresenter;

public class RegisterPresenter extends IPresenter<RegisterView> {
    private RegisterView mRegisterView;
    private final RegisterModel mRegisterModel;

    public RegisterPresenter(Context mContext, RegisterView registerView) {
        super(registerView);
        this.mRegisterView = getView();
        mRegisterModel = new RegisterModel(mContext);
    }

    public void registerUser() {
        mRegisterModel.register(new BaseModel.ModelListener<RegisterResponse>() {
                                    @Override
                                    public void onComplete(RegisterResponse bean, String s) {

                                        if (bean == null) {
                                            mRegisterView.Failed(s);
                                            return;
                                        }

                                        if (Constant.code == (bean.getCode()) && Constant.registerSuccess.equals(bean.getMsg())) {
                                            mRegisterView.Success(bean.getMsg());

                                        }else {
                                            mRegisterView.Failed(bean.getMsg());
                                        }

                                    }
                                }
                , mRegisterView.reUsername().getText().toString().trim()
                , mRegisterView.verify().getText().toString().trim()
                , mRegisterView.repassword_1().getText().toString().trim()
                , mRegisterView.repassword_2().getText().toString().trim());
    }

    public RegisterPresenter createTimer(){

        mRegisterModel.timer(new BaseModel.ModelListener<String>() {
            @Override
            public void onComplete(String bean, String s) {
                mRegisterView.timer(s);
            }
        });
        return this;

    }
    public void start(){
        mRegisterModel.start();
    }
    public void clearTimer(){
        mRegisterModel.clearTimer();
    }

    public void cancel() {
        mRegisterModel.cancel();
    }
    public void remove(){
        mRegisterModel.remove();
    }
}
