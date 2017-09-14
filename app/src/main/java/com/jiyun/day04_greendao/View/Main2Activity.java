package com.jiyun.day04_greendao.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.jiyun.day04_greendao.Model.Main.query.Bean;
import com.jiyun.day04_greendao.Model.Main.query.MyBaseAdapert;
import com.jiyun.day04_greendao.Presenter.query.PresenterDemo;
import com.jiyun.day04_greendao.Presenter.insert.Presenter;
import com.jiyun.day04_greendao.Presenter.delete.PresenterDelete;
import com.jiyun.day04_greendao.R;
import com.jiyun.day04_greendao.View.query.IView;
import com.jiyun.day04_greendao.View.insert.IView2;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements IView, View.OnClickListener {

    private ListView lv;
    private Button bt1;
    private Button bt2;
    private MyBaseAdapert myBaseAdapert;
    private ArrayList<Bean> mList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        // PresenterDemo presenterDemo = new PresenterDemo(this, this);
    }

    private void initView() {
        lv = (ListView) findViewById(R.id.lv);
        bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(this);

    }


    @Override
    public void sendString(List<Bean> list) {
        mList.addAll(list);
        myBaseAdapert = new MyBaseAdapert(mList, this);
        lv.setAdapter(myBaseAdapert);
        initOnClicker();
    }

    private void initOnClicker() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PresenterDelete presenterDelete=new PresenterDelete(new IViewDelete() {
                    @Override
                    public void sendString(List<Bean> list) {
                        mList.clear();
                        mList.addAll(list);
                        myBaseAdapert=new MyBaseAdapert(mList,Main2Activity.this);
                        lv.setAdapter(myBaseAdapert);
                        myBaseAdapert.notifyDataSetChanged();
                    }
                },Main2Activity.this);
                presenterDelete.sendString(mList.get(i));
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                PresenterDemo presenterDemo = new PresenterDemo(this, this);
                break;
            case R.id.bt2:
                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                startActivityForResult(intent,0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0&&resultCode==-1){
            Presenter present=new Presenter(new IView2() {
                @Override
                public void sendString(List<Bean> list) {
                    mList.clear();
                    mList.addAll(list);
                    myBaseAdapert.notifyDataSetChanged();
                }
            }, this);
        }
    }
}
