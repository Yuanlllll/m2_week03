package com.example.dell.m2_week03.login.model;

public interface Imodel
{
    //登录
    void getMdata(String url, String name, String pwd, Ilogin LoginCallback);
    //注册
    void getZdata(String url, String name, String pwd, Ilogin LoginCallback);
    interface Ilogin
    {
        void getSuccess(String data);
        void getFaid();
    }

}
