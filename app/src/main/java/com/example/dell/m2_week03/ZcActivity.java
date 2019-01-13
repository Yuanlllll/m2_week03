package com.example.dell.m2_week03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




import com.example.dell.m2_week03.login.bean.ZcBean;
import com.example.dell.m2_week03.login.presenter.LoginPresenter;
import com.example.dell.m2_week03.login.view.Iview;
import com.google.gson.Gson;

public class ZcActivity extends AppCompatActivity implements Iview {

    private EditText zc_name;
    private EditText zc_pswd;
    private TextView btn_zc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zc);
        zc_name = findViewById(R.id.zc_name);
        zc_pswd = findViewById(R.id.zc_pswd);
        btn_zc = findViewById(R.id.btn_zc);
        final LoginPresenter presenter = new LoginPresenter(this);
        btn_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = zc_name.getText().toString();
                String pwd = zc_pswd.getText().toString();
                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd))
                {
                    Toast.makeText(ZcActivity.this,"输入内容不能为空",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    presenter.getZpdata(name,pwd);
                }
            }
        });
    }

    @Override
    public void getVdata(final String vdata)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson=new Gson();
                ZcBean zcBean = gson.fromJson(vdata, ZcBean.class);
                Toast.makeText(ZcActivity.this,zcBean.getMsg(),Toast.LENGTH_SHORT).show();
                if (zcBean.getMsg().equals("注册成功"))
                {
                    startActivity(new Intent(ZcActivity.this,MainActivity.class));
                    finish();
                }
            }
        });

    }
}
