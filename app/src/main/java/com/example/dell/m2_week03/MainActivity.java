package com.example.dell.m2_week03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.m2_week03.login.bean.DlBean;
import com.example.dell.m2_week03.login.presenter.LoginPresenter;
import com.example.dell.m2_week03.login.view.Iview;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements Iview {

    private Button login_dl;
    private Button login_zc;
    private EditText login_name;
    private EditText login_pswd;
    private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_dl = findViewById(R.id.login_dl);
        login_zc = findViewById(R.id.login_zc);
        login_name = findViewById(R.id.login_name);
        login_pswd = findViewById(R.id.login_pswd);
        loginPresenter = new LoginPresenter(this);
        login_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = login_name.getText().toString();
                String pwd = login_pswd.getText().toString();
                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd))
                {
                    Toast.makeText(MainActivity.this,"不能为空",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    loginPresenter.getpdata(name,pwd);
                }
            }
        });

        login_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ZcActivity.class));
                finish();
            }
        });
    }

    @Override
    public void getVdata(String vdata) {
        Gson gson=new Gson();
        final DlBean dlBean = gson.fromJson(vdata, DlBean.class);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,dlBean.getMsg(),Toast.LENGTH_SHORT).show();
                if (dlBean.getMsg().equals("登录成功"))
                {
                    startActivity(new Intent(MainActivity.this,ShowActivity.class));
                    finish();
                }
            }
        });
    }
}
