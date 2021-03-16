package com.example.rabbit_house;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class mhmon extends AppCompatActivity {
    Button btnThemMon;
    ListView lvMon;
    ArrayList<Mon>list = new ArrayList<Mon>();
    ArrayAdapter<Mon>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mhmon);
        btnThemMon=(Button)findViewById(R.id.btnThemMon);
         lvMon=(ListView)findViewById(R.id.lvMon);
//        String [] fiilliste= getResources().getStringArray(R.array.string_array_name);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, fiilliste);
//        lvMon.setAdapter(adapter );
//        ArrayList<String> list =new ArrayList<String>(Arrays.asList(fiilliste));
        list.add(new Mon("1", "Cafe"));
        list.add(new Mon("2", "Trà xanh"));
        //   Toast.makeText(MainActivity.this, list.get(1).toString(), Toast.LENGTH_LONG).show(); 
        adapter = new ArrayAdapter<Mon>(this, android.R.layout.simple_list_item_1,list);
        lvMon.setAdapter(adapter);
        btnThemMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mhmon.this, mhthemmmmon.class);
                startActivityForResult(i,999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 999) {
            Bundle bundle = data.getBundleExtra("DATA");
            Mon m = (Mon) bundle.getSerializable("mon");
            list.add(m);
            adapter.notifyDataSetChanged();
        }
    }
}