package com.example.lenovo.week.model;

import com.example.lenovo.week.bean.ChildListBean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/2.
 */

public interface IRecyModel {
    public void recy(Recy recy);
    interface Recy{
        public void complate(List<ChildListBean> beans);
    }
}
