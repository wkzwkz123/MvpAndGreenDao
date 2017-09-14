package com.jiyun.day04_greendao.Model.Main.delete;

import android.app.Activity;

import com.jiyun.day04_greendao.Model.Main.query.Bean;
import com.jiyun.day04_greendao.Model.Main.query.DaoMangder;
import com.jiyun.day04_greendao.dao.BeanDao;

import java.util.List;

/**
 * Created by dell on 2017/9/14.
 */

public class ModelDelete implements Model_delete{

    private  BeanDao daos;

    public ModelDelete(Activity activity) {
        daos = DaoMangder.getInstance(activity).getDaos();

    }

    @Override
    public void sendString(Bean bean, Model_delete_callback callback) {
        daos.delete(bean);
        List<Bean> list = daos.queryBuilder().list();
        callback.sendString(list);
    }
}
