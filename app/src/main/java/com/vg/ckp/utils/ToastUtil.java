package com.vg.ckp.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @description Toast封装类
 */
public class ToastUtil {
	private static Toast toast;
	/**
	 * 强大的吐司，能够连续弹的吐司
	 * @param text
	 * @param mContext
	 */
	public static void showToast(Context mContext,String text){
		if(toast==null){
			toast = Toast.makeText(mContext, text,Toast.LENGTH_SHORT);
		}else {
			toast.setText(text);//如果不为空，则直接改变当前toast的文本
		}
		toast.show();
	}
}
