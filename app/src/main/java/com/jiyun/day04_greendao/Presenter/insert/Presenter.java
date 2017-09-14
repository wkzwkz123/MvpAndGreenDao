package com.jiyun.day04_greendao.Presenter.insert;

import android.app.Activity;

import com.jiyun.day04_greendao.Model.Main.query.Bean;
import com.jiyun.day04_greendao.Model.Main.query.IModel;
import com.jiyun.day04_greendao.Model.Main.query.ModelDemo;
import com.jiyun.day04_greendao.Model.Main.insert.IModel2;
import com.jiyun.day04_greendao.Model.Main.insert.IModelCallback;
import com.jiyun.day04_greendao.View.insert.IView2;

import java.util.List;

/**
 * Created by dell on 2017/9/14.
 */

public class Presenter implements IModel,IModel2,Main2Ipresenter{
    private IView2 iView;
    private IModelCallback iModelCallback;
    public Presenter(IView2 iView, Activity activity){
        this.iView=iView;
        iModelCallback=new ModelDemo(this,activity);
    }

    @Override
    public void sendString(List<Bean> list) {
        iView.sendString(list);
    }

    @Override
    public void sendString(String name) {
        iModelCallback.chengGong(name,this);
    }
}
