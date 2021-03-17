package io.brijoe.learnmvp;

import android.view.View;
import android.widget.Button;

import io.brijoe.learnmvp.base.BaseMVPActivity;
import io.brijoe.learnmvp.base.BasePresenter;
import io.brijoe.learnmvp.login.LoginActivity;

public class MainActivity extends BaseMVPActivity implements View.OnClickListener {

    private Button mBtnEnter;


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        //do something init
        mBtnEnter = findViewById(R.id.btn_enter);
        mBtnEnter.setOnClickListener(this);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_enter:
                Utils.launchActivity(this, LoginActivity.class);
                finish();
                break;
        }
    }
}