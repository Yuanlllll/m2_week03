package com.example.dell.m2_week03.login.presenter;


import com.example.dell.m2_week03.MainActivity;
import com.example.dell.m2_week03.ZcActivity;
import com.example.dell.m2_week03.api.Api;
import com.example.dell.m2_week03.login.model.Imodel;
import com.example.dell.m2_week03.login.model.LoginModel;

public class LoginPresenter implements Ipresenter{
    MainActivity mview;
    private final LoginModel loginModel;

    public LoginPresenter(MainActivity mview) {
        this.mview = mview;
        loginModel = new LoginModel();
    }

    //注册
    ZcActivity zcActivity;

    public LoginPresenter(ZcActivity zcActivity) {
        this.zcActivity = zcActivity;
        loginModel = new LoginModel();
    }

    @Override
    public void getpdata(String name,String pwd)
    {
       loginModel.getMdata(Api.LOGIN, name, pwd, new Imodel.Ilogin() {
           @Override
           public void getSuccess(String data) {
               mview.getVdata(data);
           }

           @Override
           public void getFaid() {
               mview.getVdata("加载失败");

           }
       });


    }

    //注册
    @Override
    public void getZpdata(String name, String pwd)
    {
        loginModel.getZdata(Api.ZC, name, pwd, new Imodel.Ilogin() {
            @Override
            public void getSuccess(String data) {
                zcActivity.getVdata(data);
            }

            @Override
            public void getFaid() {
                zcActivity.getVdata("加载失败");

            }
        });

    }
}
