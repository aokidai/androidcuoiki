package com.example.rabbit_house;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mhthemmmmon extends AppCompatActivity {
    EditText txtTenMon,txtLoai;
    Button btnLuu,btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mhthemmmmon);
        txtTenMon=(EditText)findViewById(R.id.txtTenMon);
        txtLoai=(EditText)findViewById(R.id.txtLoai);
        btnLuu=(Button)findViewById(R.id.btnLuu);
        btnHuy=(Button)findViewById(R.id.btnHuy);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String ten=txtTenMon.getText().toString();
            String loai=txtLoai.getText().toString();
            Mon m=new Mon(loai,ten);
            Intent intent = getIntent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("mon", m);
            intent.putExtra("DATA", bundle);
                setResult(Activity.RESULT_OK, intent);
            finish();
            }
        });
    }
}