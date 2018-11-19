package com.vg.ckp.utils;


import android.content.Context;

/**
 * @desc: 判断手机网络类型，是否连接
 */

public class NetWork {
    public static void internal(Context mContext) {
        int networkType = NetWorkUtils.getNetworkType(mContext);
        String networkTypeName = NetWorkUtils.getNetworkTypeName(mContext);
        LogUtils.d("-----网络名字-----", networkTypeName);
        LogUtils.d("----网络类型-----", networkType + "");
        if (networkTypeName.equals(NetWorkUtils.NETWORK_TYPE_WIFI)) {
            ToastUtil.showToast(mContext,"你目前处于wifi网络");
        } else if (networkTypeName.equals(NetWorkUtils.NETWORK_TYPE_DISCONNECT)) {
            ToastUtil.showToast(mContext,"你目前处于断网状态");
        } else if (networkTypeName.equals(NetWorkUtils.NETWORK_TYPE_3G)) {
            ToastUtil.showToast(mContext,"你目前处于3G状态");
        } else if (networkTypeName.equals(NetWorkUtils.NETWORK_TYPE_2G)) {
            ToastUtil.showToast(mContext,"你目前处于2G网络");
        } else if (networkTypeName.equals(NetWorkUtils.NETWORK_TYPE_WAP)) {
            ToastUtil.showToast(mContext,"你目前处于企业网");
        } else if (networkTypeName.equals(NetWorkUtils.NETWORK_TYPE_UNKNOWN)) {
            ToastUtil.showToast(mContext,"你目前网络类型不知道");
        }
    }
}
