package com.jiyun.day04_greendao.Model.Main.query;

import android.app.Activity;
import android.text.TextUtils;

import com.jiyun.day04_greendao.Model.Main.insert.IModel2;
import com.jiyun.day04_greendao.Model.Main.insert.IModelCallback;
import com.jiyun.day04_greendao.dao.BeanDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/9/14.
 */

public class ModelDemo implements IModelCallback {
    private IModel iModel;
    private Activity activity;
    private BeanDao daos;
    private List<Bean> list;

    public ModelDemo(IModel iModel, Activity activity){
        this.iModel=iModel;
        this.activity=activity;
        initADD();
    }
    public void initADD(){
        daos = DaoMangder.getInstance(activity).getDaos();
        list = daos.queryBuilder().list();
        if(list !=null&& list.size()>0){
            iModel.sendString(list);
        }else{
            ArrayList<Bean> mList=new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                mList.add(new Bean(null,"张三"+i));
            }
            daos.insertInTx(mList);
            List<Bean> list1 = daos.queryBuilder().list();
            list.addAll(list1);
            iModel.sendString(list);
        }
    }

    @Override
    public void chengGong(String str, IModel2 imdel2) {
        if (!TextUtils.isEmpty(str)){
            daos.insertInTx(new Bean(null,str));
            List<Bean> list2 = daos.queryBuilder().list();
            imdel2.sendString(list2);
        }

    }
}
