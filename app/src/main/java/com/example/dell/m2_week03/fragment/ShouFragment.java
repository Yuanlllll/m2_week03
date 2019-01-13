package com.example.dell.m2_week03.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dell.m2_week03.R;
import com.example.dell.m2_week03.adapter.HomeAdapter;
import com.example.dell.m2_week03.bean.HomeBean;
import com.example.dell.m2_week03.home.presenter.ListPresenter;
import com.example.dell.m2_week03.home.view.Iview;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;


public class ShouFragment extends Fragment implements Iview
{

    private RecyclerView recy_view;
    private XBanner xbanner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.shou_layout, null);
        recy_view = view.findViewById(R.id.recy_view);
        ListPresenter listPresenter = new ListPresenter(this);
        listPresenter.getpdata();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recy_view.setLayoutManager(linearLayoutManager);
        return view;
    }


    @Override
    public void getvdata(Object data)
    {
        HomeBean homebean= (HomeBean) data;
        //设置适配器
        HomeAdapter adapter=new HomeAdapter(getContext(),homebean.getData());
        recy_view.setAdapter(adapter);


    }


}
