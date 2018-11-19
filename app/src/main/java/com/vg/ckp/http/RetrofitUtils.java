package com.vg.ckp.http;


import android.content.Context;
import android.support.v4.util.ArrayMap;

import com.vg.ckp.Constant;

import java.io.IOException;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscription;

public class RetrofitUtils {

    private static RetrofitUtils instance;
    private static ArrayMap<String, Subscription> maps; //订阅的网络请求管理容器
    private String mToken = "";
    private RetrofitUtils(Context context) {}

    /**
     * 获取RetrofitUtils对象单例保证唯一
     * @param context  上下文
     * @return RetrofitUtils对象
     */
    public static RetrofitUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (RetrofitUtils.class) {
                if (instance == null) {
                    instance = new RetrofitUtils(context.getApplicationContext());
                    maps = new ArrayMap<String, Subscription>();
                }
            }
        }
        return instance;
    }

    public RetrofitUtils setToken(String token){
        this.mToken = token;
        return this;
    }

    /**
     * 创建并获取Api接口对象
     * @return Api对象
     */
    public Api http() {
        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request original = chain.request();
                Request.Builder newBuilder = original.newBuilder()
                        .header("Content", "application/json")
                        .header("Content-Type", "application/json; charset=utf-8")
                        .header("Content-Length", "0")
                        .header("Host", "180.76.115.140")
                        .header("Connection", "Keep-Alive")
                        .header("Accept-Encoding", "gzip")
                        .header("User-Agent", "okhttp/3.8.1")
                        .header("token",mToken);

                Request build = newBuilder.build();
                return chain.proceed(build);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constant.base_url)
                .client(client)

                .build();
        Api api = retrofit.create(Api.class);

        return api;
    }



    public void add(String tag, Subscription subscription) {
        //移除重复的 重新加入tag
        if (maps.get(tag) != null){
            maps.remove(tag);
        }
        maps.put(tag, subscription);
    }

    public void remove(String tag){
        if (maps.isEmpty() && maps.containsKey(tag)){
            maps.remove(tag);
        }
    }

    public void removeAll(){
        if (maps.isEmpty() ){
            maps.clear();
        }
    }

    public void cancel(String tag){
        if (maps.isEmpty() || maps.get(tag) == null){
            return;
        }
        if (!maps.get(tag).isUnsubscribed()){
            maps.get(tag).unsubscribe();
            maps.remove(tag);
        }
    }

    public void cancelAll(){
        if (maps.isEmpty()){
            return;
        }
        Set<String> str = maps.keySet();
        for (String s:str) {
            maps.get(s).unsubscribe();
            maps.remove(s);
        }
    }
}
