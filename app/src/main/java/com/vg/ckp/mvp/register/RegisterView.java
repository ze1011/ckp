package com.vg.ckp.mvp.register;

import android.widget.EditText;

import com.vg.ckp.mvp.base.IView;

public interface RegisterView extends IView {

    EditText reUsername();
    EditText verify();
    EditText repassword_1();
    EditText repassword_2();
    void timer(String str);
}
