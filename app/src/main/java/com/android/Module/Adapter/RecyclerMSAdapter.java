package com.android.Module.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.Module.Beans.BeanAll;
import com.android.Module.Beans.NineBean;
import com.android.R;
import com.android.Utils.GlideImageLoader;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerMSAdapter extends RecyclerView.Adapter {

    private List<BeanAll.MiaoshaBean.ListBeanX> list = new ArrayList<>();
    private Context context;

    public RecyclerMSAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(),R.layout.rcv_ms_item,null);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getImages()).into(viewHolder.imageView);
        viewHolder.textView.setText("￥ "+list.get(position).getTitle());
        viewHolder.textView2.setText(list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setDate(List<BeanAll.MiaoshaBean.ListBeanX> list){
        list.addAll(list);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.rcv_img);
            textView = itemView.findViewById(R.id.rcv_text);
            textView2 = itemView.findViewById(R.id.rcv_ms_price);
        }
    }
}
