package com.vg.ckp;

public interface Constant {

    //String base_url = URL.url;
    String base_url = "http://180.76.115.140/mobile/";

    String name = "1";
    String passsword = "12315284512";


    String error ="-1";
    int code = 0;
    String msg ="登录成功";
    String e ="登录失败";

    String registerSuccess ="注册成功";
    
    
    public static final Integer REQUEST_INSTALL_UNKNOW_APK_NOTE = 0x101;                    //适配8.0及以上安装未知来源应用授权请求码
    public static final String TABLE_USER_INFO                  = "imei_user";              //以imei号为唯一识别生成用户
    public static final String TABLE_USER_INFO_ITEM_IMEI        = "imei";                   //用户表imei字段
}
