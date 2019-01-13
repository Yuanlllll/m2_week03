package com.example.dell.m2_week03.home.model;

public interface Imodel
{
    void getmdata(String url, HomeCallBack homeCallBack);
    //轮播

    interface HomeCallBack
    {
       void getSuceess(Object data);
       void getFail();
    }
}
