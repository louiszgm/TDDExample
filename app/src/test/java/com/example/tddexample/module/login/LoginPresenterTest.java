package com.example.tddexample.module.login;

import com.example.tddexample.data.Api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * Created by louiszgm on 2017/1/5.
 */
public class LoginPresenterTest {

    private LoginContract.View mView;
    private Api api;
    private LoginPresenter mPresenter;
    @Before
    public void setUp() throws Exception {
        mView = mock(LoginContract.View.class);
        api = mock(Api.class);
        mPresenter = new LoginPresenter(mView, api);
    }

    @Test
    public void testWhenTheUserNameIsEmpty() throws Exception {
        //调用mView对象获取用户名的方法，并指定让其返回空值
        when(mView.getInputUsername()).thenReturn("");
        //调用presenter中的方法处理具体逻辑
        mPresenter.onClickLogin();
        //验证mView中提示错误的方法是否被调用
        verify(mView).showErrorMessage("用户名为空");
    }

    @Test
    public void testWhenThePwdIsEmpty() throws Exception {
        //调用mView对象获取密码的方法，并指定让其返回空值
        when(mView.getInputPwd()).thenReturn("");
        when(mView.getInputUsername()).thenReturn("louiszgm");
        mPresenter.onClickLogin();

        //验证mView中提示错误的方法是否被调用
        verify(mView).showErrorMessage("请输入密码");
    }

    @Test
    public void testWhenTheVerificationNotPass() throws Exception {
        when(mView.getInputUsername()).thenReturn("louiszgm");
        when(mView.getInputPwd()).thenReturn("12345");
        when(api.login("louiszgm", "12345")).thenReturn(false);

        mPresenter.onClickLogin();
        verify(mView).showErrorMessage("登录失败!请检查用户名密码是否正确!");
    }

    @Test
    public void testWhenTheVerificationPass() throws Exception {
        when(mView.getInputUsername()).thenReturn("louiszgm");
        when(mView.getInputPwd()).thenReturn("123456");
        when(api.login("louiszgm", "123456")).thenReturn(true);
        mPresenter.onClickLogin();
        verify(mView).loginSuccess();

    }
}