package com.example.lenovo.week.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.week.HomeActivity;
import com.example.lenovo.week.R;
import com.example.lenovo.week.bean.ChildListBean;
import com.example.lenovo.week.bean.EventBean;
import com.example.lenovo.week.bean.UserBean;
import com.example.lenovo.week.fragment.FragmentTwo;
import com.example.lenovo.week.iter.APP;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/2.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
Context context;
List<ChildListBean> beans;

    public MyAdapter(Context context, List<ChildListBean> beans) {
        this.context = context;
        this.beans = beans;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder)holder).textView.setText(beans.get(position).getTitle());
        ((ViewHolder)holder).img.setImageURI(beans.get(position).getPic());
        ((ViewHolder)holder).textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky(new EventBean(beans.get(position).getPic(),beans.get(position).getTitle()));
                context.startActivity(new Intent(context, HomeActivity.class));
            }
        });
    }
    @Override
    public int getItemCount() {
        return beans==null?0:beans.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView img;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.simppleDraweeview);
            textView = itemView.findViewById(R.id.tv);
        }
    }


}
