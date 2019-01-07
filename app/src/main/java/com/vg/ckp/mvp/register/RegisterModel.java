package com.vg.ckp.mvp.register;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;

import com.vg.ckp.bean.local.RegisterBean;
import com.vg.ckp.bean.net.RegisterResponse;
import com.vg.ckp.http.RetrofitUtils;
import com.vg.ckp.mvp.base.BaseModel;
import com.vg.ckp.utils.NetWorkUtils;
import com.vg.ckp.utils.VerifyUtils;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RegisterModel extends BaseModel {
    private Context mContext;
    private RegisterBean mBean;
    private RegisterCountDownTimer mTimer;

    public RegisterModel(Context mContext) {
        super(mContext);
        this.mContext = mContext;
    }

    @Override
    public String setflag() {
        return "RegisterModel";
    }

    public void register(final ModelListener listener, String... args) {

        String networkTypeName = NetWorkUtils.getNetworkTypeName(mContext);
        if (NetWorkUtils.NETWORK_TYPE_DISCONNECT.equals(networkTypeName)) {
            listener.onComplete(null, NetWorkUtils.NETWORK_TYPE_DISCONNECT);
            return;
        }


        //if (!VerifyUtils.isMobileNumber(args[0])) {
          //  listener.onComplete(null, "请输入正确的电话号码");
            //return;
        //}

        if (!args[2].equals(args[3])) {
            listener.onComplete(null, "二次输入密码不一样");
            return;
        }


        if (mBean == null)
            mBean = new RegisterBean();

        mBean.username = args[0];
        mBean.referrer = args[1];
        mBean.password = args[2];


        Subscription subscribe = RetrofitUtils.getInstance(mContext)
                .http()
                .registerUser(mBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onTerminateDetach()
                .subscribe(new Subscriber<RegisterResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RegisterResponse registerResponse) {
                        listener.onComplete(registerResponse, null);
                    }
                });

        add(subscribe);
    }


    public void timer(ModelListener listener){

        mTimer = new RegisterCountDownTimer(60000,1000,listener);

    }
    public void start(){
        if (mTimer != null){
            mTimer.start();
        }
    }
    public void clearTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

   public class RegisterCountDownTimer extends CountDownTimer{
        private ModelListener listener;

       /**
        * @param millisInFuture    The number of millis in the future from the call
        *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
        *                          is called.
        * @param countDownInterval The interval along the way to receive
        *                          {@link #onTick(long)} callbacks.
        */
       public RegisterCountDownTimer(long millisInFuture, long countDownInterval,ModelListener listener) {
           super(millisInFuture, countDownInterval);
            this.listener = listener;
       }

       @Override
       public void onTick(long millisUntilFinished) {
           Log.d("tag", "onTick: "+millisUntilFinished);
           listener.onComplete(null,millisUntilFinished/1000+"");
       }

       @Override
       public void onFinish() {
           listener.onComplete(null,"finish");
       }
   }
}
