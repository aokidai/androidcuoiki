package com.example.rabbit_house;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Person;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
    int possselected = -1;
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
        lvMon.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                possselected = arg2;
                return false;
            }
        });
        registerForContextMenu(lvMon);
    }
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menuhoadon, menu);
    }
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mnuedit:
                doStartEdit();
                break;
            case R.id.mnudelete:
                doDelete();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void doStartEdit(){
        Intent intentEdit = new Intent(this, mhsuamonnnn.class);
        Mon m = list.get(possselected);
        Bundle bundle = new Bundle();
        bundle.putSerializable("mon", m);
        intentEdit.putExtra("DATA", bundle);
        startActivityForResult(intentEdit, 114);
    }
    public void doDelete(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hoi xoa");
        builder.setMessage("Muon xoa that a?");
        builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                list.remove(possselected);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
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
        switch (requestCode){
            case 113:
                if (resultCode ==115 ){
                    Bundle bundle = data.getBundleExtra("DATA");
                    Mon p = (Mon) bundle.getSerializable("mon");
                    list.add(p);
                    adapter.notifyDataSetChanged();
                }
                break;
            case 114:
                if (resultCode == 116){
                    Bundle bundle = data.getBundleExtra("DATA");
                    Mon p = (Mon) bundle.getSerializable("mon");
                    list.set(possselected, p);
                    adapter.notifyDataSetChanged();
                }
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

}