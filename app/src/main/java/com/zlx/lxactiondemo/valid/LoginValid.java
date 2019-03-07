package com.zlx.lxactiondemo.valid;

import android.content.Context;
import android.content.Intent;

import com.zlx.lxactiondemo.LoginActivity;
import com.zlx.lxactiondemo.MainActivity;
import com.zlx.lxcheckaction.action.Valid;

/**
 * @date: 2019\3\7 0007
 * @author: zlx
 * @email: 1170762202@qq.com
 * @description:
 */
public class LoginValid implements Valid {
    private Context context;

    public LoginValid(Context context) {
        this.context = context;
    }

    @Override
    public boolean check() {
        return MainActivity.isLogin;
    }

    @Override
    public void doValid() {
        context.startActivity(new Intent(context, LoginActivity.class));
    }
}
