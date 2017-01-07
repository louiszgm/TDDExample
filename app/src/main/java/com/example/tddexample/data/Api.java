package com.example.tddexample.data;

/**
 * Created by louiszgm on 2017/1/5.
 */

public class Api{
    public Api() {
    }

    public boolean login(String username, String pwd) {
        if(!username.equals(UserInfo.UserName) || !pwd.equals(UserInfo.Pwd)){
            return false;
        }
        return true;
    }
}
