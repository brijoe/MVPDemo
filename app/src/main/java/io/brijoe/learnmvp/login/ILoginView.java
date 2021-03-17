package io.brijoe.learnmvp.login;

import io.brijoe.learnmvp.base.IBaseView;

public interface ILoginView extends IBaseView {
    void onLoginSuccess();

    void onLoginFail();
}

