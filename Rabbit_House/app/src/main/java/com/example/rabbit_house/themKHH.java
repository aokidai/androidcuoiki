package com.example.rabbit_house;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.BatchUpdateException;

public class themKHH extends AppCompatActivity {
    EditText txtma,txtten;
    Button btnLuu,btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_k_h_h);
        txtma=(EditText)findViewById(R.id.txtma);
        txtten=(EditText)findViewById(R.id.txtten);
        btnHuy=(Button)findViewById(R.id.btnHuy);
        btnLuu=(Button)findViewById(R.id.btnLuu);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent();
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten=txtten.getText().toString();
                String sdt=txtma.getText().toString();
                khach k= new khach(ten,sdt);
                Intent intent= new Intent();
                Bundle bundle= new Bundle();
                bundle.putSerializable("khach",k);
                intent.putExtra("DATA",bundle);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}