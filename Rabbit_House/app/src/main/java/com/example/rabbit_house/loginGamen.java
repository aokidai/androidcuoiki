package com.example.rabbit_house;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginGamen extends AppCompatActivity {
    Button btnDangNhap, btnThoat;
    TextView tvForgotpass, tvSaipass;
    EditText edtUsername, edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_gamen);
        btnDangNhap = (Button) findViewById(R.id.btnLogin);
        btnThoat = (Button) findViewById(R.id.btnExit);
        tvSaipass = (TextView) findViewById(R.id.tvSaipass);
        tvForgotpass = (TextView) findViewById(R.id.btnForgot);
        edtUsername = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSaipass.setText("");
                if (edtUsername.getText().toString().equals("admin") && edtPass.getText().toString().equals("123"))
                {
                    Intent login = new Intent(loginGamen.this, MainActivity.class);
                    startActivity(login);
                }
                else{
                    tvSaipass.setText("Sai Thông tin ĐN!");
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvForgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot = new Intent(loginGamen.this, forgot_pass.class);
                startActivity(forgot);
            }
        });
    }
}