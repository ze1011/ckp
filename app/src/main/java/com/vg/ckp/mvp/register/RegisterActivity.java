package com.vg.ckp.mvp.register;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.vg.ckp.R;
import com.vg.ckp.mvp.base.BaseActivity;
import com.vg.ckp.mvp.base.IPresenter;
import com.vg.ckp.utils.ToastUtil;

public class RegisterActivity extends BaseActivity<RegisterView> implements RegisterView, View.OnClickListener {


    private ImageView mImgReturn;
    private EditText mRegisterUser;
    private EditText mRegisterV;
    private Button mRegisterVBtn;
    private EditText mRegisterP1;
    private EditText mRegisterP2;
    private Button mRegisterBtn;

    @Override
    protected RegisterView addView() {
        return this;
    }

    @Override
    protected void initView() {

        mImgReturn = findViewById(R.id.register_return);
        mRegisterUser = findViewById(R.id.register_u);
        mRegisterV = findViewById(R.id.register_v);
        mRegisterVBtn = findViewById(R.id.register_v_btn);
        mRegisterP1 = findViewById(R.id.register_p1);
        mRegisterP2 = findViewById(R.id.register_p2);
        mRegisterBtn = findViewById(R.id.registerBtn);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        mImgReturn.setOnClickListener(this);
        mRegisterUser.setOnClickListener(this);
        mRegisterV.setOnClickListener(this);
        mRegisterVBtn.setOnClickListener(this);
        mRegisterP1.setOnClickListener(this);
        mRegisterP2.setOnClickListener(this);
        mRegisterBtn.setOnClickListener(this);

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    public IPresenter<RegisterView> createPresenter() {
        RegisterPresenter p = new RegisterPresenter(RegisterActivity.this, this);
        return p;
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void Success(String s) {
        ToastUtil.showToast(RegisterActivity.this, s);

    }

    @Override
    public void Failed(String e) {
        ToastUtil.showToast(RegisterActivity.this, e);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_return:
                finish();
                break;
            case R.id.register_v_btn:
                //                ((RegisterPresenter) mPresenter).createTimer().start();
                //后面再解决
                ToastUtil.showToast(RegisterActivity.this,"请写入：aabbcc");
                break;
            case R.id.register_v:
                break;
            case R.id.register_p1:
                break;
            case R.id.register_p2:
                break;
            case R.id.registerBtn:
                ((RegisterPresenter) mPresenter).registerUser();
                break;
            default:
                break;

        }
    }

    @Override
    protected void onDestroy() {
        ((RegisterPresenter) mPresenter).remove();
        ((RegisterPresenter) mPresenter).cancel();
        ((RegisterPresenter) mPresenter).detachView();
        ((RegisterPresenter) mPresenter).clearTimer();

        super.onDestroy();
    }

    @Override
    public EditText reUsername() {

        return mRegisterUser;
    }

    @Override
    public EditText verify() {
        return mRegisterV;
    }

    @Override
    public EditText repassword_1() {
        return mRegisterP1;
    }

    @Override
    public EditText repassword_2() {
        return mRegisterP2;
    }

    @Override
    public void timer(String str) {
        if ("finish".equals(str)) {
            mRegisterVBtn.setText("验证码");
            mRegisterBtn.setClickable(true);
        } else {
            mRegisterVBtn.setText(str);
            mRegisterBtn.setClickable(false);
        }
    }


}
