package io.brijoe.learnmvp.login;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import io.brijoe.learnmvp.R;
import io.brijoe.learnmvp.base.BasePresenter;

public class LoginPresenter extends BasePresenter<ILoginView> {

    /**
     * 模拟执行登录操作
     */
    public void login(String userName, String password) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            getView().showToast(R.string.toast_login_tip);
            return;
        }
        getView().showProgressUI(true);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (isViewAttached()) {
                getView().showProgressUI(false);
                getView().onLoginSuccess();
            }
        }, 3000);
    }

}
