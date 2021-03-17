package io.brijoe.learnmvp;

import io.brijoe.learnmvp.base.BaseMVPActivity;
import io.brijoe.learnmvp.base.BasePresenter;

public class HomeActivity extends BaseMVPActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
