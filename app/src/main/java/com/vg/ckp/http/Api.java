package com.vg.ckp.http;

import com.vg.ckp.bean.local.AnchorsBean;
import com.vg.ckp.bean.local.RegisterBean;
import com.vg.ckp.bean.local.UserBean;
import com.vg.ckp.bean.net.ChannelBean;
import com.vg.ckp.bean.local.LiveBean;
import com.vg.ckp.bean.net.NetLiveBean;
import com.vg.ckp.bean.net.RegisterResponse;
import com.vg.ckp.bean.net.RequestBean;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface Api {

    /**
     * 登录
     * @param user
     * @return
     */
    @POST("user/login")
    Observable<RequestBean> login(@Body UserBean user);

    /**
     * 注册
     * @param bean
     * @return
     */
    @POST("user/register")
    Observable<RegisterResponse> registerUser(@Body RegisterBean bean);

    /**
     * 列表
     * @param bean
     * @return
     */
    @POST("live/index")
    Observable<NetLiveBean> getLiveItem(@Body LiveBean bean);

    /**
     * 菜单
     * @param bean
     * @return
     */
    @POST("live/anchors")
    Observable<ChannelBean> getChannelBean(@Body AnchorsBean bean);
}
