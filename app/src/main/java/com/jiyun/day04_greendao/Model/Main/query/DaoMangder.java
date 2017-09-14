package com.jiyun.day04_greendao.Model.Main.query;

import android.content.Context;

import com.jiyun.day04_greendao.dao.BeanDao;
import com.jiyun.day04_greendao.dao.DaoMaster;
import com.jiyun.day04_greendao.dao.DaoSession;

/**
 * Created by dell on 2017/9/14.
 */

public class DaoMangder {
    private static DaoMangder mangder;
    private DaoMaster.DevOpenHelper openHelper;
    private String DB_NAME="bean.db";
    private DaoMangder(Context context){
        openHelper=new DaoMaster.DevOpenHelper(context,DB_NAME);
    }
    public static synchronized DaoMangder getInstance(Context context){
        if(mangder==null){
            mangder=new DaoMangder(context);
        }
        return mangder;
    }
    public BeanDao getDaos(){
        DaoMaster master=new DaoMaster(openHelper.getWritableDatabase());
        DaoSession daoSession = master.newSession();
        BeanDao beanDao = daoSession.getBeanDao();
        return beanDao;
    }
}
