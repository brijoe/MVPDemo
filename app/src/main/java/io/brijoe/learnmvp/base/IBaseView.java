package io.brijoe.learnmvp.base;

import androidx.annotation.IdRes;

/**
 * View层一些基础操作
 */
public interface IBaseView {
    /**
     * 弹出Toast
     *
     * @param resId
     */
    void showToast(@IdRes int resId);

    /**
     * 展示进度UI
     *
     * @param isShow
     */
    void showProgressUI(boolean isShow);

}
