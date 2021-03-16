package io.brijoe.learnmvp.login;

import io.brijoe.learnmvp.base.BasePresenter;

public class LoginPresenter extends BasePresenter<ILoginView> {

    /**
     * 执行登录操作
     */
    public void login() {
        getView().refreshLoginButton();
    }

    /**
     * 执行退出登录操作
     */
    public void logout() {
    }
}
