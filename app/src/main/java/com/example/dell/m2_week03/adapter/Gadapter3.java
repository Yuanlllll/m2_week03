package com.example.dell.m2_week03.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.m2_week03.R;
import com.example.dell.m2_week03.bean.HomeBean;

import java.util.List;

public class Gadapter3 extends RecyclerView.Adapter<Gadapter3.gholder>
{
    private Context context;
    private List<HomeBean.DataBean.FenleiBean> list;

    public Gadapter3(Context context, List<HomeBean.DataBean.FenleiBean> list) {
        this.context = context;
        this.list = list;
    }

    private ImageView img3;
    private TextView text3;


    @NonNull
    @Override
    public Gadapter3.gholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.s33_layout, viewGroup, false);
        return new gholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Gadapter3.gholder gholder, int i) {
        text3.setText(list.get(i).getName());
        Glide.with(context).load(list.get(i).getIcon()).into(gholder.img3);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class gholder extends RecyclerView.ViewHolder {
        public ImageView img3;

        public gholder(@NonNull View itemView) {
            super(itemView);
            img3 = itemView.findViewById(R.id.img3);
            text3 = itemView.findViewById(R.id.text3);
        }
    }
}
