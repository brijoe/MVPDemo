package io.brijoe.learnmvp.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.brijoe.learnmvp.HomeActivity;
import io.brijoe.learnmvp.R;
import io.brijoe.learnmvp.Utils;
import io.brijoe.learnmvp.base.BaseMVPActivity;

/**
 * 登录界面
 */
public class LoginActivity extends BaseMVPActivity<ILoginView, LoginPresenter>
        implements ILoginView, View.OnClickListener {

    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private Button mBtnLogin;

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        mEdtUsername = findViewById(R.id.edt_username);
        mEdtPassword = findViewById(R.id.edt_password);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);

    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                mPresenter.login(mEdtUsername.getText().toString(),
                        mEdtPassword.getText().toString());
                break;
        }
    }

    @Override
    public void onLoginSuccess() {
        Utils.launchActivity(this, HomeActivity.class);
        finish();
    }

    @Override
    public void onLoginFail() {
        mEdtUsername.setText(null);
        mEdtPassword.setText(null);
    }
}
