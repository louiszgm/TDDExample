package com.example.tddexample.module.login;

import android.text.TextUtils;

import com.example.tddexample.data.Api;

/**
 * Created by louiszgm on 2017/1/5.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;
    private Api mApi;
    public LoginPresenter(LoginContract.View view, Api api) {
        mView = view;
        mApi = api;
    }


    @Override
    public void onClickLogin() {
        String username = mView.getInputUsername();
        if (username == null || username.equals("")){
            mView.showErrorMessage("用户名为空");
            return;
        }
        String pwd = mView.getInputPwd();
        if (pwd == null || pwd.equals("")){
            mView.showErrorMessage("请输入密码");
            return;
        }

        if(!mApi.login(username, pwd)){
            mView.showErrorMessage("登录失败!请检查用户名密码是否正确!");
            return;
        }

        mView.loginSuccess();
    }
}
