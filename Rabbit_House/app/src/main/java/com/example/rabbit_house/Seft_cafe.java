package com.example.rabbit_house;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Seft_cafe extends Activity {
    ArrayList<Mon>list = new ArrayList<Mon>();
    ArrayAdapter<Mon>adapter;
    ArrayList<khach>listKH = new ArrayList<khach>();
    ArrayAdapter<khach>adapter1;
    ArrayList<banhang>listhd = new ArrayList<banhang>();
    ArrayAdapter<banhang>adapterhd;
    ListView lvmon,lvhoadon;
    EditText edtDate;
    int possselected = -1;
    int bien = 0;
    int posSpinner2 = -1;
    Button btnChon;
    Spinner spKH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seft_cafe);
        edtDate=(EditText) findViewById(R.id.edtDate);
        lvmon=(ListView)findViewById(R.id.lvmon);
        lvhoadon=(ListView)findViewById(R.id.lvhoadon);
        spKH=(Spinner)findViewById(R.id.spKH);
        listKH.add(new khach("teo"));
        listKH.add(new khach("ty"));
        adapter1 = new ArrayAdapter<khach>(this, android.R.layout.simple_list_item_1,listKH);
        spKH.setAdapter(adapter1);
        list.add(new Mon("1", "Cafe "));
        list.add(new Mon("2","trà xanh"));
        listhd.add(new banhang("2","Cafe","teo"));
        adapterhd= new ArrayAdapter<banhang>(this, android.R.layout.simple_list_item_1,listhd);
        lvhoadon.setAdapter(adapterhd);

        adapter= new ArrayAdapter<Mon>(this, android.R.layout.simple_list_item_1,list);
        lvmon.setAdapter(adapter);

//        spKH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                posSpinner2 = position;
//            }
//        });


            lvmon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (bien<=0) {
                        Toast.makeText(getApplicationContext(), "Vui long chon ngay!!!", Toast.LENGTH_LONG).show();
                        bien = 0;
                    }
                    else {
                        Mon m = list.get(position);
                        String Ten = m.getName();
                        String Ngay = edtDate.getText().toString();
                        String tenkh = spKH.getSelectedItem().toString();


                        listhd.add(new banhang(Ten, Ngay, tenkh));
                        adapterhd.notifyDataSetChanged();
                    }
                }
            });


        lvhoadon.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               possselected=position;
                return false;
            }
        });
        registerForContextMenu(lvhoadon);
        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(Seft_cafe.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        edtDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                bien = bien + 1;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menuseftcafe,menu);
    }
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.mnudelete:
                doDelete();
                break;
        }
        return super.onContextItemSelected(item);
    }


    public void doDelete(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hoi xoa");
        builder.setMessage("Muon xoa that a?");
        builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listhd.remove(possselected);
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

}