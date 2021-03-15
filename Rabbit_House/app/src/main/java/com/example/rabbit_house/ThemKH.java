package com.example.rabbit_house;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.ListIterator;

public class ThemKH extends AppCompatActivity {
    Button btnThemKH;
    ListView lvKH;
    ArrayList<khach>list=new ArrayList<khach>();
    ArrayAdapter<khach>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_k_h);
        btnThemKH=(Button)findViewById(R.id.btnThemKH);
        lvKH=(ListView)findViewById(R.id.lvKH);
        list.add(new khach("1", "teo"));
        list.add(new khach("2","ty"));
        adapter= new ArrayAdapter<khach>(this, android.R.layout.simple_list_item_1,list);
        lvKH.setAdapter(adapter);
        btnThemKH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(ThemKH.this,themKHH.class);
                startActivityForResult(i,999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==999){
            Bundle bundle=data.getBundleExtra("DATA");
            khach k = (khach) bundle.getSerializable("khach");
            list.add(k);
            adapter.notifyDataSetChanged();

        }
    }
}