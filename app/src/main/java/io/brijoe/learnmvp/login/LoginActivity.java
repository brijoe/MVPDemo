package io.brijoe.learnmvp.login;

import io.brijoe.learnmvp.base.BaseMVPActivity;

/**
 * 登录界面
 */
public class LoginActivity extends BaseMVPActivity<ILoginView, LoginPresenter> {


    @Override
    protected int getContentView() {
        return 0;
    }

    @Override
    protected void init() {
        mPresenter.login();
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

}
