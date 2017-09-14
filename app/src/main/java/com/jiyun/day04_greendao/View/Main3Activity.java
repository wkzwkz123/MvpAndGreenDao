package com.jiyun.day04_greendao.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jiyun.day04_greendao.Model.Main.query.Bean;
import com.jiyun.day04_greendao.Presenter.insert.Presenter;
import com.jiyun.day04_greendao.R;
import com.jiyun.day04_greendao.View.insert.IView2;

import java.util.List;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener,IView2 {

    private EditText edit_name;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        edit_name = (EditText) findViewById(R.id.edit_name);
        bt = (Button) findViewById(R.id.bt);

        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
                Presenter presenter=new Presenter(this,this);
                presenter.sendString(edit_name.getText().toString());
                setResult(-1,intent);
                finish();
                break;
        }
    }

    @Override
    public void sendString(List<Bean> list) {

    }
}
