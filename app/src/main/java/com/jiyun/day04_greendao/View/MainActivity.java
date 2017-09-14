package com.jiyun.day04_greendao.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.jiyun.day04_greendao.R;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        /*startActivity(new Intent(MainActivity.this,Main2Activity.class));
        overridePendingTransition(R.animator.exit,R.animator.entor);*/
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.entro);
        tv.setAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            startActivity(new Intent(MainActivity.this,Main2Activity.class));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
    }
}
