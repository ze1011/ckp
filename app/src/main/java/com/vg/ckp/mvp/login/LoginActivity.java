package com.vg.ckp.mvp.login;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vg.ckp.R;
import com.vg.ckp.mvp.base.BaseActivity;
import com.vg.ckp.mvp.base.IPresenter;
import com.vg.ckp.mvp.register.RegisterActivity;
import com.vg.ckp.utils.ToastUtil;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    private static final String TAG = "LoginActivity_tag";
    private RelativeLayout mLoginBack;
    private EditText mUsername;
    private EditText mPassword;
    private Button mLogin;
    private Button mRegister;
    private CheckBox mIsAuto;
    private TextView mRe_pwd;
    private ImageView mRetureImg;


    @Override
    protected LoginActivity addView() {
        return this;
    }

    @Override
    protected void initView() {
        mLoginBack = findViewById(R.id.login_ll);
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mLogin = findViewById(R.id.login);
        mRegister = findViewById(R.id.register);
        mIsAuto = findViewById(R.id.isAutoLogin);
        mRe_pwd = findViewById(R.id.forget);
        mRetureImg = findViewById(R.id.image_return);
        mUsername.setText("13422223333");
        mPassword.setText("123");
    
    
        
    
    }


    @Override
    protected void initData() {
        if (((CheckBox) mIsAuto).isChecked()) {
            ((LoginPresenter) mPresenter).loadLogin(null, null);
        }


    }


    @Override
    protected void initEvent() {
        mRetureImg.setOnClickListener(this);
        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);
        mIsAuto.setOnClickListener(this);
        mRe_pwd.setOnClickListener(this);

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }


    @Override
    public IPresenter createPresenter() {
        LoginPresenter mP = LoginPresenter.getInstance(this.getApplicationContext(), this);
        return mP;
    }


    @Override
    public void showDialog() {

    }

    @Override
    public void Success(String s) {
        flag = true;
        finish();
    }

    @Override
    public void Failed(String e) {

        ToastUtil.showToast(LoginActivity.this,e);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_return:
                finish();
                break;
            case R.id.login:
                //Log.d(TAG, "onClick: login");
                //((LoginPresenter) mPresenter).loadLogin(mUsername,mPassword);
                break;
            case R.id.register:
                startActivity(RegisterActivity.class);
                break;
            case R.id.forget:
                break;
            default:
                break;
        }

    }

    @Override
    protected void onDestroy() {
        //解除关系
        ((LoginPresenter) mPresenter).cancel();
        ((LoginPresenter) mPresenter).detachView();

        super.onDestroy();


    }
}
