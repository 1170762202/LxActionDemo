package com.zlx.lxactiondemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zlx.lxcheckaction.action.LxAction;

/**
 * @date: 2019\3\7 0007
 * @author: zlx
 * @email: 1170762202@qq.com
 * @description:
 */
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        MainActivity.isLogin = true;
        //注意登录成功后执行doAction，继续校验
        LxAction.getInstance().doAction();
        finish();
    }
}
