package com.example.lenovo.week.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.week.BaseActivity;
import com.example.lenovo.week.R;
import com.example.lenovo.week.adapter.MyAdapter;
import com.example.lenovo.week.bean.ChildListBean;
import com.example.lenovo.week.bean.UserBean;
import com.example.lenovo.week.iter.APP;
import com.example.lenovo.week.presenter.RecyPresenter;
import com.example.lenovo.week.view.IRecyView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/12/2.
 */

public class FragmentOne extends BaseActivity<RecyPresenter> implements IRecyView {
    private RecyclerView rlv;
//        @Bind(R.id.rlv)
//    RecyclerView rlv;
    private RecyPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        rlv = view.findViewById(R.id.rlv);
//        ButterKnife.bind(getActivity(), view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.showrecy();
    }
    @Override
    public void show(List<ChildListBean> beans) {
        List<ChildListBean> loadAll = APP.session.getChildListBeanDao().loadAll();
        MyAdapter myAdapter = new MyAdapter(getActivity(), beans);
        rlv.setAdapter(myAdapter);
//        for (ChildListBean list:loadAll){
//            Log.i("==========", "show: "+loadAll.get(0).getTitle());
//        }
        for (int i = 0; i < loadAll.size(); i++) {
            Log.i("==========", "show: "+loadAll.get(i).getTitle());
        }
    }


    @Subscribe( threadMode = ThreadMode.MAIN,sticky = true)
    public void getData(String i){
        if (i.equals("0")){
            return;
        }else{
            List<ChildListBean> childListBeans = APP.session.getChildListBeanDao().loadAll();
//            List<DataBean> beanList = APP.session.getDataBeanDao().loadAll();
            MyAdapter myAdapter = new MyAdapter(getActivity(),childListBeans);
            rlv.setAdapter(myAdapter);
        }
    }
    @Override
    protected void complate() {
        presenter = new RecyPresenter(this);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
