package com.example.dell.m2_week03.login.model;


import com.example.dell.m2_week03.network.OkHttp3;

public class LoginModel implements Imodel
{

    @Override
    public void getMdata(String url, String name, String pwd, final Ilogin LoginCallback)
    {
        OkHttp3.OkHttpPost(url, name, pwd, new OkHttp3.GetMessListener() {
            @Override
            public void getMess(String s) {
                LoginCallback.getSuccess(s);
            }
        });

    }

    //注册
    @Override
    public void getZdata(String url, String name, String pwd, final Ilogin LoginCallback) {

        OkHttp3.OkHttpPost(url, name, pwd, new OkHttp3.GetMessListener() {
            @Override
            public void getMess(String s) {
                LoginCallback.getSuccess(s);
            }
        });
    }
}
