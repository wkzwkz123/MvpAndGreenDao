package com.jiyun.day04_greendao.Presenter.query;

import android.app.Activity;

import com.jiyun.day04_greendao.Model.Main.query.Bean;
import com.jiyun.day04_greendao.Model.Main.query.IModel;
import com.jiyun.day04_greendao.Model.Main.query.ModelDemo;
import com.jiyun.day04_greendao.View.query.IView;

import java.util.List;

/**
 * Created by dell on 2017/9/14.
 */

public class PresenterDemo implements IModel{
    private IView iView;

    public PresenterDemo(IView iView, Activity activity) {
        this.iView = iView;
        new ModelDemo(this,activity);
    }

    @Override
    public void sendString(List<Bean> list) {
        iView.sendString(list);
    }
}
