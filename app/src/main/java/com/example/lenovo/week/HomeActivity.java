package com.example.lenovo.week;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.week.bean.EventBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {


    private ImageView sim;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        ButterKnife.bind(this);
        sim = findViewById(R.id.simppleDraweeview);
        tv = findViewById(R.id.tv);
        EventBus.getDefault().register(this);
    }
    @Subscribe(sticky = true)
    public void onEventMainThread(EventBean bean) {
        Glide.with(this).load(bean.getPic()).into(sim);
        tv.setText(bean.getTextview());

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }
}
