package com.example.rabbit_house;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mhsuamonnnn extends AppCompatActivity {
    EditText txtTenMon,txtLoai;
    Button btnLuu,btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mhsuamonnnn);
        final Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("DATA");
        final Mon m = (Mon) bundle.getSerializable("mon");
        txtTenMon = (EditText)findViewById(R.id.txtTenMon);
        txtLoai = (EditText)findViewById(R.id.txtLoai);
        btnHuy=(Button)findViewById(R.id.btnHuy);
        btnLuu=(Button)findViewById(R.id.btnLuu);
        txtLoai.setText(m.getLoai()+"");
        txtTenMon.setText(m.getName()+"");
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.setName(txtTenMon.getText()+"");
                setResult(116,intent);
                finish();
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}