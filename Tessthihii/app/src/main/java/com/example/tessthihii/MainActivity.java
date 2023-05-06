package com.example.tessthihii;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SVdatabase database;
    private SVAdapter adapter;
    private List<SinhVien> listSv;
    // design
    private EditText edtMaSv, edtHoTen, edtLop, edtDiaChi, edtSDT;
    private Button btnThem, btnSua, btnXoa, btnThoat;
    private ListView lvSv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        database= new SVdatabase(this);
        listSv = database.InformationSV();
        adapter = new SVAdapter(this, R.layout.item_listsv, listSv);
        lvSv.setAdapter(adapter);


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtMaSv.getText().toString().equals("") || edtHoTen.getText().toString().equals("")
                        || edtLop.getText().toString().equals("") || edtDiaChi.getText().toString().equals("")
                        || edtSDT.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Thông tin SV không được để trống", Toast.LENGTH_LONG).show();
                } else {
                    SinhVien sv = CreateSV();
                    if (sv != null) {
                        database.AddSv(sv);
                        listSv.clear();
                        listSv.addAll(database.InformationSV());
//                        setAdapter() cap nhat lai dl;
                        adapter.notifyDataSetChanged();
                        //Xóa DL nhập vào
                        edtMaSv.setText("");
                        edtHoTen.setText("");
                        edtLop.setText("");
                        edtDiaChi.setText("");
                        edtSDT.setText("");
                    }
                }
            }
        });

        // Bat su kien cho tung item trong listview
        lvSv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinhVien sv = listSv.get(i);
                edtMaSv.setText(sv.getMaSv());
                edtHoTen.setText(sv.getHoTen());
                edtLop.setText(sv.getLop());
                edtDiaChi.setText(sv.getDiaChi());
                edtSDT.setText(sv.getSdt());

            }
        });
        // bat su kie cho btnSua
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sv = new SinhVien();
                sv.setMaSv(String.valueOf(edtMaSv.getText()));
                sv.setHoTen(edtHoTen.getText()+" ");
                sv.setLop(edtLop.getText()+" ");
                sv.setDiaChi(edtDiaChi.getText()+" ");
                sv.setSdt(edtSDT.getText()+" ");
                int kq = database.UpdateSV(sv);
                if(kq>0){
                    listSv.clear();
                    listSv.addAll(database.InformationSV());
                    if(adapter!= null){
                        adapter.notifyDataSetChanged();
                    }
                    setAdapter();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sv=new SinhVien();
                int kq=database.DeleteSV(String.valueOf(edtMaSv.getText()));
                if(kq>0){
                    Toast.makeText(MainActivity.this,"Xóa thành công",Toast.LENGTH_LONG).show();
                    listSv.clear();
                    listSv.addAll(database.InformationSV());
                    setAdapter();
                }else {
                    Toast.makeText(MainActivity.this,"Không xóa được Sinh viên",Toast.LENGTH_LONG).show();
                }

            }
        });


        // bat su kien cho btnThoat
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận Thoát chương trình !!!");
                builder.setMessage("Bạn có muốn Thoát chương trình không ???");
                builder.setPositiveButton("Có ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                //hien thi
                AlertDialog d = builder.create();
                d.show();
            }
        });


    }

    private SinhVien CreateSV(){
        String MaSv = edtMaSv.getText().toString();
        String HoTen = edtHoTen.getText().toString();
        String Lop = edtLop.getText().toString();
        String DiaChi = edtDiaChi.getText().toString();
        String Sdt = edtSDT.getText().toString();
        SinhVien sv = new SinhVien(MaSv,HoTen,Lop,DiaChi,Sdt);
        return sv;

    }
    private void setAdapter(){
        if(adapter == null)
        {
            // tao moi
            adapter = new SVAdapter(this,R.layout.item_listsv,listSv);
            lvSv.setAdapter(adapter);
        }
        else {
            // cap nhat lai dl
            adapter.notifyDataSetChanged();
        }
    }

    private void anhxa() {
        edtMaSv = findViewById(R.id.edtMaSv);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtLop = findViewById(R.id.edtLop);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtSDT = findViewById(R.id.edtSdt);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        btnThoat = findViewById(R.id.btnThoat);
        lvSv = findViewById(R.id.lv1);
    }
}