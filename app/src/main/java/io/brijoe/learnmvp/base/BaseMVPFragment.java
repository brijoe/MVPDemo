package io.brijoe.learnmvp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Base MVPFragment 所有业务 Fragment  必须继承此基类
 *
 * @param <V>
 * @param <P>
 */
public abstract class BaseMVPFragment<V, P extends BasePresenter<V>> extends BaseFragment
        implements IBaseView {

    protected View mRootView;

    protected LayoutInflater inflater;

    protected boolean isPrepared;

    protected boolean isVisible;

    protected Context mContext;

    protected Activity mActivity;

    protected P mPresenter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(getLayoutId(), container, false);
            mActivity = getActivity();
            mContext = mActivity;
            this.inflater = inflater;
        }
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        isPrepared = true;
        init();
        lazyLoad();
    }

    /**
     * 获取布局
     */
    public abstract @LayoutRes
    int getLayoutId();

    protected abstract void init();

    /**
     * 子类必须实现的构造Presenter 以实现MVP 模式
     *
     * @return
     */
    protected abstract P createPresenter();

    public View findViewById(@IdRes int id) {
        View view = null;
        if (mRootView != null) {
            view = mRootView.findViewById(id);
        }
        return view;
    }

    private void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        lazyLoadData();
        isPrepared = false;
    }

    /**
     * 懒加载
     */
    protected void lazyLoadData() {

    }

    protected void onVisible() {
        lazyLoad();
    }

    protected void onInvisible() {

    }

    @Override
    public void showProgressUI(boolean isShow) {

    }

    @Override
    public void showToast(int resId) {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }
}
