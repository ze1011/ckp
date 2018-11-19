package com.vg.ckp.mvp.base;

import android.content.Context;

import com.vg.ckp.http.RetrofitUtils;
import com.vg.ckp.utils.NetWorkUtils;

import rx.Subscription;

public abstract class BaseModel {

    protected Context mContext;
    protected String flag; //网络请求的标记
    public BaseModel(Context mContext){
       this.mContext = mContext.getApplicationContext();
        flag = setflag();
    }

    /**
     * 让调用使自行设置每个网络请求的标记
     * @return
     */
    public abstract String setflag();

    public void loading(ModelListener listener) {

        String networkTypeName = NetWorkUtils.getNetworkTypeName(mContext);
        if (NetWorkUtils.NETWORK_TYPE_DISCONNECT.equals(networkTypeName)){
            listener.onComplete(null,NetWorkUtils.NETWORK_TYPE_DISCONNECT);
            return;
        }

    }

    public void add( Subscription subscription){
        RetrofitUtils.getInstance(mContext).add(flag,subscription);
    }

    public void remove() {
        RetrofitUtils.getInstance(mContext).remove(flag);
    }

    public void removeAll(){
        RetrofitUtils.getInstance(mContext).removeAll();
    }


    public void cancel(){
        RetrofitUtils.getInstance(mContext).cancel(flag);
    }


    public void cancelAll(){
        RetrofitUtils.getInstance(mContext).cancelAll();
    }


    /**
     * 回调
     */
    public interface ModelListener<T> {
        void onComplete(T bean,String s);

    }
}
