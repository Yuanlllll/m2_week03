package com.example.dell.m2_week03.home.model;


import com.example.dell.m2_week03.bean.HomeBean;
import com.example.dell.m2_week03.network.OkHttp3;

public class ListModel implements Imodel {

    @Override
    public void getmdata(String url, final HomeCallBack homeCallBack) {
        OkHttp3.getInstance().OkHttpGet(url, HomeBean.class, new OkHttp3.ListCallBack() {
            @Override
            public void getOnSuccess(Object obj) {
                homeCallBack.getSuceess(obj);
            }

            @Override
            public void getOnFailure(Exception e) {
                homeCallBack.getFail();

            }
        });
    }








}
