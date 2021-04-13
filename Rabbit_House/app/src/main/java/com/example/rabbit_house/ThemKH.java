package com.example.rabbit_house;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.ListIterator;

public class ThemKH extends AppCompatActivity {
    Button btnThemKH;
    ListView lvKH;
    ArrayList<khach>list=new ArrayList<khach>();
    ArrayAdapter<khach>adapter;
    int possselected = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_k_h);
        btnThemKH=(Button)findViewById(R.id.btnThemKH);
        lvKH=(ListView)findViewById(R.id.lvKH);
        list.add(new khach("teo", "1"));
        list.add(new khach("ty","2"));
        adapter= new ArrayAdapter<khach>(this, android.R.layout.simple_list_item_1,list);
        lvKH.setAdapter(adapter);
        btnThemKH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(ThemKH.this,themKHH.class);
                startActivityForResult(i,999);
            }
        });
        lvKH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                possselected=arg2;
                return false;
            }
        });
        registerForContextMenu(lvKH);
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
        Intent intentEdit = new Intent(this, suaKHH.class);
        khach k = list.get(possselected);
        Bundle bundle = new Bundle();
        bundle.putSerializable("khach", k);
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
        if(requestCode==999){
            Bundle bundle=data.getBundleExtra("DATA");
            khach k = (khach) bundle.getSerializable("khach");
            list.add(k);
            adapter.notifyDataSetChanged();
        }
        switch (requestCode){
            case 113:
                if (resultCode ==115 ){
                    Bundle bundle = data.getBundleExtra("DATA");
                    khach k = (khach) bundle.getSerializable("khach");
                    list.add(k);
                    adapter.notifyDataSetChanged();
                }
                break;
            case 114:
                if (resultCode == 116){
                    Bundle bundle = data.getBundleExtra("DATA");
                    khach k = (khach) bundle.getSerializable("khach");
                    list.set(possselected, k);
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