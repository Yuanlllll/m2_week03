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

public class Gadapter extends RecyclerView.Adapter<Gadapter.gholder> {
    private Context context;
    private List<HomeBean.DataBean.FenleiBean> list;

    public Gadapter(Context context, List<HomeBean.DataBean.FenleiBean> list) {
        this.context = context;
        this.list = list;
    }

    private ImageView img2;
    private TextView text2;
    @NonNull
    @Override
    public Gadapter.gholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.s22_layout, viewGroup, false);
        return new gholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Gadapter.gholder gholder, int i) {
        text2.setText(list.get(i).getName());
        Glide.with(context).load(list.get(i).getIcon()).into(gholder.img2);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class gholder extends RecyclerView.ViewHolder {
        public ImageView img2;

        public gholder(@NonNull View itemView) {
            super(itemView);
            img2 = itemView.findViewById(R.id.img2);
            text2 = itemView.findViewById(R.id.text2);
        }
    }
}
