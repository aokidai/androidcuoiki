package com.example.rabbit_house;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class loginGamen extends AppCompatActivity {
    Button btnDangNhap, btnThoat;
    TextView tvForgotpass, tvSaipass;
    EditText edtUsername, edtPass;
    user u =new user();
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
//        Intent intent = new Intent();
//        Bundle bundle=intent.getBundleExtra("DATA");
//        user u= (user)bundle.getSerializable("pass");
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSaipass.setText("");
                if (edtUsername.getText().toString().equals(u.getUsername()) && edtPass.getText().toString().equals(u.getPassword()))
                {
                    Intent login = new Intent(loginGamen.this, MainActivity.class);
                    startActivityForResult(login,998);
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
                startActivityForResult(forgot,998);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==998){
            String newpass=data.getStringExtra("pass");
            u.setPassword(newpass);
        }
    }
}
