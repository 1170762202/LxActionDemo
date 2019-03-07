package com.zlx.lxactiondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zlx.lxactiondemo.valid.LoginValid;
import com.zlx.lxcheckaction.action.Action;
import com.zlx.lxcheckaction.action.LxAction;

public class MainActivity extends AppCompatActivity {

    public static boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn(View view) {
        LxAction.getInstance()
                .addAction(new Action() {
                    @Override
                    public void doAction() {
                        startActivity(new Intent(MainActivity.this, OrderActivity.class));
                    }
                })
                .addValid(new LoginValid(this))
                .doCheck();
    }

    public void exit(View view) {
        MainActivity.isLogin = false;
    }
}
