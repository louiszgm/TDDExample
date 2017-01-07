package com.example.tddexample.module.login;

/**
 * Created by louiszgm on 2017/1/5.
 */

public interface LoginContract {

    interface View{

        String getInputUsername();

        void showErrorMessage(String erro);

        String getInputPwd();

        void loginSuccess();
    }

    interface Presenter{

        void onClickLogin();
    }
}
