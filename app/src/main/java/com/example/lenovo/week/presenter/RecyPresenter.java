package com.example.lenovo.week.presenter;

import android.support.v4.app.FragmentActivity;

import com.example.lenovo.week.bean.ChildListBean;
import com.example.lenovo.week.bean.UserBean;
import com.example.lenovo.week.iter.APP;
import com.example.lenovo.week.model.IRecyModel;
import com.example.lenovo.week.model.RecyModel;
import com.example.lenovo.week.view.IRecyView;

import java.lang.ref.SoftReference;
import java.util.List;

/**
 * Created by lenovo on 2017/12/2.
 */

public class RecyPresenter implements IPresenter<IRecyView> {
    RecyModel model;
    SoftReference<IRecyView> reference;
    public  RecyPresenter(IRecyView view){
        attach(view);
        model=new RecyModel();
    }
    public void showrecy(){
        model.recy(new IRecyModel.Recy() {
            @Override
            public void complate(List<ChildListBean> beans) {
                reference.get().show(beans);
            }
        });
    }
    @Override
    public void attach(IRecyView view) {
        reference=new SoftReference<IRecyView>(view);
    }
    @Override
    public void detach() {
        reference.clear();

    }
}
