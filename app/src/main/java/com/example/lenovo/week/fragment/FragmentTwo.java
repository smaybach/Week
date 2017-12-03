package com.example.lenovo.week.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.week.R;
import com.example.lenovo.week.bean.EventBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/12/2.
 */

public class FragmentTwo extends Fragment {
    @Bind(R.id.simppleDraweeview)
    SimpleDraweeView simppleDraweeview;
    @Bind(R.id.tv)
    TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, null);


        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        return view;
    }

    @Subscribe(sticky = true)
    public void onEventMainThread(EventBean bean) {
        Glide.with(getActivity()).load(bean.getPic()).into(simppleDraweeview);
        tv.setText(bean.getTextview());

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
