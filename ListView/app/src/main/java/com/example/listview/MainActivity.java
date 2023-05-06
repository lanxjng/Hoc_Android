package com.example.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edt_HP;
    private Button btnThem, btnSua, btnXoa, btnThoat;
    private ListView listView_HP;
    private ArrayList<String> Arr_HP;
    private ArrayAdapter<String> adapter;
    private int Vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        //Khoi tao CSDL vao mang
        Arr_HP = new ArrayList<>();
        Arr_HP.add("LT Android");
        Arr_HP.add("APS.NET");
        //Khoi tao adapter
        adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,Arr_HP);
        listView_HP.setAdapter(adapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt_HP.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Tên học phần không được để trống !!!",Toast.LENGTH_LONG).show();
                }
                else {
                   // Arr_HP.add(edt_HP.getText().toString());
                    String monhoc = edt_HP.getText().toString();
                    Arr_HP.add(monhoc);
                    //Cap nhat lai DL
                    adapter.notifyDataSetChanged();
                }
            }
        });
        //Bat su kien cho item duoc chon tren listview
        listView_HP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edt_HP.setText(Arr_HP.get(i));
                Vitri = i;
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Arr_HP.set(Vitri, edt_HP.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Arr_HP.remove(Vitri);
                adapter.notifyDataSetChanged();
                edt_HP.setText("");
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận thoát chương trình!");
                builder.setMessage("Bạn có muốn thoát ko?");
                builder.setPositiveButton("Có ^-^ ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không -.- ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog d1 = builder.create();
                d1.show();

            }
        });
    }

    private void anhxa() {
        edt_HP = findViewById(R.id.edt_HP);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        btnThoat = findViewById(R.id.btnThoat);
        listView_HP = findViewById(R.id.Lv_HP);
    }
    //goi menu_option

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuoption,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_Them:{
                //Khoi lenh xu ly
                if(edt_HP.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Tên học phần không được để trống !!!",Toast.LENGTH_LONG).show();
                }
                else {
                    // Arr_HP.add(edt_HP.getText().toString());
                    String monhoc = edt_HP.getText().toString();
                    Arr_HP.add(monhoc);
                    //Cap nhat lai DL
                    adapter.notifyDataSetChanged();
                }
                break;
            }
            case R.id.menu_Sua:{
                Arr_HP.set(Vitri, edt_HP.getText().toString());
                adapter.notifyDataSetChanged();
                break;
            }
            case R.id.menu_Xoa:{
                Arr_HP.remove(Vitri);
                adapter.notifyDataSetChanged();
                edt_HP.setText("");

                break;
            }
            case R.id.menu_Thoat:{
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận thoát chương trình!");
                builder.setMessage("Bạn có muốn thoát ko?");
                builder.setPositiveButton("Có ^-^ ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không -.- ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog d1 = builder.create();
                d1.show();
            }
            default:
                //Dua ra thong bao nhap sai
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}