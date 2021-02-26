package com.example.rabbit_house;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class loginGamen extends AppCompatActivity {
    Button btnDangNhap, btnThoat;
    TextView tvForgotpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_gamen);
        btnDangNhap = (Button) findViewById(R.id.btnLogin);
        btnThoat = (Button) findViewById(R.id.btnExit);
        tvForgotpass = (TextView) findViewById(R.id.btnForgot);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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