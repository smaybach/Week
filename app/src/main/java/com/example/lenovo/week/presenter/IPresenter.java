package com.example.lenovo.week.presenter;

/**
 * Created by lenovo on 2017/12/2.
 */

public interface IPresenter<T> {
    void attach(T view);
    void detach();
}
