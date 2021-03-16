package io.brijoe.learnmvp.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * MVP 模式中的Presenter 负责 处理业务逻辑
 * <p>
 * 业务层Presenter 必须实现此基类,
 * <p>
 * 1.如何P
 * 如果遇到 一个View 可能复用到多个Presenter,
 * 思路 1. 思路是可以创建一个用例层UseCase 或者叫交互层  Interactor来放置用例
 * 仍然保持一个P一个V，将Presenter中的逻辑代码放到到UseCase中，一是减少presenter代码，二是复用UseCase。
 * 一个UseCase集中了相关的用户逻辑，比如登入，登出，验证等等。不同的Presenter不用的View如果要做的事相关，
 * 比如登录，那么就复用同一个UserCase。
 * <p>
 * 而不是使用多个Presenter
 * <p>
 * 2.如何解决内存泄漏问题
 * <p>
 * 关联View attachView  解关联 detachView 对View的引用是弱引用
 *
 * @param <V>
 */
public class BasePresenter<V> {


    protected Reference<V> mViewRef;

    protected V mView;

    public final void attachView(V view) {
        this.mView = view;
        mViewRef = new WeakReference<V>(view);
    }

    protected final V getView() {
        return mViewRef.get();
    }

    public final boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    //解决内存泄漏
    public final void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }


}
