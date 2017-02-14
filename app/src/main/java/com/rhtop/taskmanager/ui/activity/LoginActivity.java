package com.rhtop.taskmanager.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.rhtop.taskmanager.R;
import com.rhtop.taskmanager.common.utils.LogUtils;
import com.rhtop.taskmanager.ui.widget.CircleTextView;

import static com.rhtop.taskmanager.R.id.et_password;
import static com.rhtop.taskmanager.R.id.et_phone;


public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private CircleTextView circletvName;
    private Spinner spPhonePrefix;
    private EditText etPhone;
    private EditText etPassword;
    private Button btLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        LogUtils.d("LoginActivity--onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        circletvName = (CircleTextView) findViewById(R.id.circletv_name);
        spPhonePrefix = (Spinner) findViewById(R.id.sp_phone_prefix);
        etPhone = (EditText) findViewById(et_phone);
        etPassword = (EditText) findViewById(et_password);
        btLogin = (Button) findViewById(R.id.bt_login);

        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String phone = etPhone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        accessMainActivity();
    }

    private void accessMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

