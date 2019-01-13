package com.example.dell.m2_week03.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.m2_week03.R;
import com.example.dell.m2_week03.bean.HomeBean;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter {
    private Context context;
    private HomeBean.DataBean homebean;

    private RecyclerView grecy_view;
    private RecyclerView grecy_view3;

    public HomeAdapter(Context context, HomeBean.DataBean homebean) {
        this.context = context;
        this.homebean = homebean;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {

         View view;
         int type = getItemViewType(i);
        if (type == 0)
        {
            view = LayoutInflater.from(context).inflate(R.layout.s2_layout, viewGroup, false);
            return new XiangViewHolder2(view);
        }
        else {
            view = LayoutInflater.from(context).inflate(R.layout.s3_layout, viewGroup, false);
            return  new XiangViewHolder3(view);


        }



    }

    //绑定数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        if (viewHolder instanceof XiangViewHolder2)
        {
            GridLayoutManager gmanager =new GridLayoutManager(context,5);
            grecy_view.setLayoutManager(gmanager);
            Gadapter gadapter=new Gadapter(context,homebean.getFenlei());
            grecy_view.setAdapter(gadapter);
        }
        if (viewHolder instanceof XiangViewHolder3)
        {
            GridLayoutManager gmanager3 =new GridLayoutManager(context,3);
            grecy_view3.setLayoutManager(gmanager3);
            Gadapter3 gadapter3=new Gadapter3(context,homebean.getFenlei());
            grecy_view3.setAdapter(gadapter3);
        }


    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        if (position % 2 == 1) {
            type = 1;
        }
        return type;
    }
    class XiangViewHolder2 extends RecyclerView.ViewHolder {
        public ImageView img2;
        public XiangViewHolder2(@NonNull View itemView) {
            super(itemView);
            grecy_view = itemView.findViewById(R.id.grecy_view);

        }
 }

    class XiangViewHolder3 extends RecyclerView.ViewHolder {
        public ImageView img3;
        public XiangViewHolder3(@NonNull View itemView)
        {
            super(itemView);
            grecy_view3 = itemView.findViewById(R.id.grecy_view3);

        }

    }


}
