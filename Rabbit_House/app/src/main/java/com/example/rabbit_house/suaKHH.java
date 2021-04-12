package com.example.rabbit_house;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class suaKHH extends AppCompatActivity {
    EditText txtma, txtten;
    Button btnLuu, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_k_h_h);
        final Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("DATA");
        final khach k = (khach) bundle.getSerializable("khach");
        txtma=(EditText)findViewById(R.id.txtma);
        txtten=(EditText)findViewById(R.id.txtten);
        btnHuy=(Button)findViewById(R.id.btnHuy);
        btnLuu=(Button)findViewById(R.id.btnLuu);
        txtten.setText(k.getTen());
        txtma.setText(k.getSdt());
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k.setTen(txtten.getText()+"");
                k.setSdt(txtma.getText()+"");
                setResult(116,intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}