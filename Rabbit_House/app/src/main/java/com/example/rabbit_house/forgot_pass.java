package com.example.rabbit_house;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class forgot_pass extends AppCompatActivity {
    Button btnDangNhap, btnHuy;
    TextView tvTam1, tvTam2;
    EditText edtTam1, edtTam2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        btnDangNhap = (Button) findViewById(R.id.btnLogin);
        btnHuy = (Button) findViewById(R.id.btnExit);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}