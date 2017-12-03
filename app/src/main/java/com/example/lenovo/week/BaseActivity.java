package com.example.lenovo.week;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.lenovo.week.presenter.IPresenter;

/**
 * Created by lenovo on 2017/12/2.
 */

public abstract class BaseActivity<T extends IPresenter> extends Fragment {
    T presenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        complate();
    }

    protected abstract void complate();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter !=null){
            presenter.detach();
        }
    }
}
