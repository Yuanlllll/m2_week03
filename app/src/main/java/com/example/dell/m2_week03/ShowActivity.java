package com.example.dell.m2_week03;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dell.m2_week03.fragment.FenFragment;
import com.example.dell.m2_week03.fragment.FindFragment;
import com.example.dell.m2_week03.fragment.MyFragment;
import com.example.dell.m2_week03.fragment.ShopFragment;
import com.example.dell.m2_week03.fragment.ShouFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class ShowActivity extends AppCompatActivity {
    private BottomTabBar bottom_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        bottom_bar = findViewById(R.id.bottom_bar);
        bottom_bar.init(getSupportFragmentManager())
                .setChangeColor(Color.RED,Color.DKGRAY)
                .setFontSize(12)
                .setImgSize(50,50)
                .setTabPadding(4,6,10)
                .addTabItem("首页",R.drawable.a,ShouFragment.class)
                .addTabItem("分类",R.drawable.e,FenFragment.class)
                .addTabItem("发现",R.drawable.f,FindFragment.class)
                .addTabItem("购物",R.drawable.c,ShopFragment.class)
                .addTabItem("我的",R.drawable.d,MyFragment.class)
                .isShowDivider(false);
    }
}
