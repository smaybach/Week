package com.example.lenovo.week.model;

import android.util.Log;

import com.afa.tourism.greendao.gen.DaoSession;
import com.example.lenovo.week.bean.ChildListBean;
import com.example.lenovo.week.bean.UserBean;
import com.example.lenovo.week.iter.APIService;
import com.example.lenovo.week.iter.APP;

import java.util.List;

import javax.security.auth.login.LoginException;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/2.
 */

public class RecyModel implements IRecyModel {
    @Override
    public void recy(final Recy recy) {
        APIService.API_SERVICE.getdata()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        Log.i("====", "onNext: "+userBean.toString());
                        List<ChildListBean> childList = userBean.getRet().getList().get(0).getChildList();
                        recy.complate(childList);
                        APP.session.getChildListBeanDao().insertInTx(childList);
                    }
                });
    }
}
