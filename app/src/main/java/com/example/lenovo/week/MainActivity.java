package com.example.lenovo.week;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lenovo.week.fragment.FragmentFive;
import com.example.lenovo.week.fragment.FragmentFour;
import com.example.lenovo.week.fragment.FragmentOne;
import com.example.lenovo.week.fragment.FragmentThree;
import com.example.lenovo.week.fragment.FragmentTwo;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.vp)
    FrameLayout vp;
    @Bind(R.id.bt)
    RadioButton bt;
    @Bind(R.id.bt2)
    RadioButton bt2;
    @Bind(R.id.bt3)
    RadioButton bt3;
    @Bind(R.id.bt4)
    RadioButton bt4;
    @Bind(R.id.bt5)
    RadioButton bt5;
    @Bind(R.id.rg)
    RadioGroup rg;
    private FragmentOne one;
    private FragmentTwo two;
    private FragmentThree three;
    private FragmentFour four;
    private FragmentFive five;
    private List<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        one = new FragmentOne();
        two = new FragmentTwo();
        three = new FragmentThree();
        four = new FragmentFour();
        five = new FragmentFive();
        isNetworkConnected(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.vp,one)
                .commit();
    }
    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                Toast.makeText(this, "网络正常", Toast.LENGTH_SHORT).show();
                EventBus.getDefault().postSticky("0");
                return mNetworkInfo.isAvailable();
            }else {
                Toast.makeText(context, "网络未连接", Toast.LENGTH_SHORT).show();
                EventBus.getDefault().postSticky("1");
            }
        }
        return false;
    }

    @OnClick({R.id.bt, R.id.bt2, R.id.bt3, R.id.bt4, R.id.bt5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.vp, one)
                        .commit();

                break;
            case R.id.bt2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.vp, two)
                        .commit();
                break;
            case R.id.bt3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.vp, three)
                        .commit();
                break;
            case R.id.bt4:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.vp, four)
                        .commit();
                break;
            case R.id.bt5:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.vp, five)
                        .commit();
                break;
        }
    }
}
