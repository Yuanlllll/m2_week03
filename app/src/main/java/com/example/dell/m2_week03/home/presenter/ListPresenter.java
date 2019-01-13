package com.example.dell.m2_week03.home.presenter;


import com.example.dell.m2_week03.api.Api;
import com.example.dell.m2_week03.fragment.ShouFragment;
import com.example.dell.m2_week03.home.model.Imodel;
import com.example.dell.m2_week03.home.model.ListModel;

public class ListPresenter implements Ipresenter {
    ShouFragment shouFragment;
    private final ListModel listModel;

    public ListPresenter(ShouFragment shouFragment) {
        this.shouFragment = shouFragment;
        listModel = new ListModel();
    }

    @Override
    public void getpdata()
    {
        listModel.getmdata(Api.SHOU, new Imodel.HomeCallBack() {
            @Override
            public void getSuceess(Object data) {
              shouFragment.getvdata(data);
            }

            @Override
            public void getFail() {
              shouFragment.getvdata("加载失败");

            }
        });

    }




    public void destory()
    {
        if (shouFragment!=null)
        {
            shouFragment=null;
        }
    }


}
