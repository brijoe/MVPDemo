package io.brijoe.learnmvp.base;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import io.brijoe.learnmvp.Utils;

/**
 * BaseMVPActivity 所有业务 Activity 必须继承此基类
 * <p>
 * 多个Presenter 处理 ？
 *
 * @param <V> View 层泛型约束
 * @param <P> Presenter 泛型约束
 */
public abstract class BaseMVPActivity<V, P extends BasePresenter<V>>
        extends BaseActivity implements IBaseView {


    protected P mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentView() != 0) {
            setContentView(getContentView());
        }
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
        init();
    }

    /**
     * 设置内容视图
     *
     * @return
     */

    protected abstract @LayoutRes
    int getContentView();

    /**
     * 一些init操作,绑定视图,初始化UI等
     */
    protected abstract void init();


    @Override
    public void showToast(int resId) {
        Utils.showToast(this, resId);
    }

    private ProgressDialog pd;

    @Override
    public void showProgressUI(boolean isShow) {
        if (isShow) {
            if (pd == null) {
                pd = new ProgressDialog(this);
                pd.show();
            }
        } else {
            if (pd != null) {
                pd.dismiss();
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    /**
     * 子类必须实现的构造Presenter 以实现MVP 模式
     *
     * @return
     */
    protected abstract P createPresenter();


}
