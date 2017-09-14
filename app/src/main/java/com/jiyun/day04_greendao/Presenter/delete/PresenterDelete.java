package com.jiyun.day04_greendao.Presenter.delete;

import android.app.Activity;

import com.jiyun.day04_greendao.Model.Main.query.Bean;
import com.jiyun.day04_greendao.Model.Main.delete.ModelDelete;
import com.jiyun.day04_greendao.Model.Main.delete.Model_delete;
import com.jiyun.day04_greendao.Model.Main.delete.Model_delete_callback;
import com.jiyun.day04_greendao.View.IViewDelete;

import java.util.List;

/**
 * Created by dell on 2017/9/14.
 */

public class PresenterDelete implements Model_delete_callback,P_Delete{
    private IViewDelete iViewDelete;
    private Model_delete model_delete;
    public PresenterDelete(IViewDelete iViewDelete, Activity activity){
        this.iViewDelete=iViewDelete;
        model_delete=new ModelDelete(activity);
    }
    @Override
    public void sendString(List<Bean> list) {
        iViewDelete.sendString(list);
    }

    @Override
    public void sendString(Bean bean) {
        model_delete.sendString(bean,this);
    }
}
