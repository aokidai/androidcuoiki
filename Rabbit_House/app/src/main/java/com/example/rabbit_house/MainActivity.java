package com.example.rabbit_house;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnBanHang, btnThemKH;
    TextView tvSignout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBanHang = (Button) findViewById(R.id.btnSelf);
        btnThemKH = (Button) findViewById(R.id.btnCostmermng);
        tvSignout = (TextView) findViewById(R.id.btnSignout);
        btnBanHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent banhang = new Intent(MainActivity.this, Seft_cafe.class);
                startActivity(banhang);
            }
        });
        btnThemKH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent khachhang = new Intent(MainActivity.this, ThemKH.class);
                startActivity(khachhang);
            }
        });
        tvSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signout = new Intent(MainActivity.this, loginGamen.class);
                startActivity(signout);
            }
        });
    }
}