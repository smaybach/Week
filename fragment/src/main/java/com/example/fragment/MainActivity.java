package com.example.fragment;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fragment.Fragment.FragmentFour;
import com.example.fragment.Fragment.FragmentOne;
import com.example.fragment.Fragment.FragmentThree;
import com.example.fragment.Fragment.FragmentTwwo;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {
    private BottomTabBar fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = findViewById(R.id.fragment);
        fragment.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(0)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("月光茶人",R.drawable.ac0, FragmentOne.class)
                .addTabItem("优惠",R.drawable.abu, FragmentThree.class)
                .addTabItem("购物车",R.drawable.abw, FragmentTwwo.class)
                .addTabItem("我的",R.drawable.aby, FragmentFour.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                    }
                });
    }
}
