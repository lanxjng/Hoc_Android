package com.example.dkikhoahoc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //1. khai bao tp
    private EditText edtHoTen, edtDiaChi,edtSdt,edtEmail;
    private RadioButton rbnNam, rbnNu;
    private CheckBox ckbAndroid, ckbWeb, ckbNet;
    private Button btnDky, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2. anh xa
        anhxa();
        //3. bat su kien
        //xoa
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận hủy/ Thoát chương trình.");
                builder.setMessage("Bạn có muốn thoát khỏi chương trình không ??");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();;
                    }
                });
                // hien thi hop thoai
                AlertDialog d1 = builder.create();
                d1 = builder.show();
            }
        });
        // dky
        btnDky.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(edtHoTen.getText().toString().isEmpty()|| edtSdt.getText().toString().isEmpty());
                {
                    Toast.makeText(MainActivity.this,"Thông Tin Không Được Để Trống !!!",
                            Toast.LENGTH_LONG).show();
                }
                String GioiTinh ="";
                GioiTinh = (rbnNam.isChecked())?"Nam":"Nữ";
                String KhoaHoc ="";
                if(ckbAndroid.isChecked()){
                    KhoaHoc += "Lập Trình Android";
                }
                if(ckbWeb.isChecked()){
                    KhoaHoc +=  "Lập Trình Web";
                }
                if(ckbNet.isChecked()){
                    KhoaHoc +=  "Lập Trình Net";
                }
                if(!ckbAndroid.isChecked()&& !ckbWeb.isChecked()&& !ckbNet.isChecked()){
                    Toast.makeText(MainActivity.this,"Khóa Học Không Đươc Để Trống!!!", Toast.LENGTH_LONG).show();
                }
//                Toast.makeText(MainActivity.this, "Họ Tên: "+edtHoTen.getText()
//                        +"\n SDT: " + edtSdt.getText() +KhoaHoc, Toast.LENGTH_LONG).show();

                else
                    btnDky.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intent1);
                        }
                    });


            }
        });
    }


    private void anhxa() {
        edtHoTen= findViewById(R.id.edtHoTen);
        edtSdt = findViewById(R.id.edtSdt);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtEmail = findViewById(R.id.edtEmail);
        rbnNam = findViewById(R.id.rbtNam);
        rbnNu = findViewById(R.id.rbtNu);
        ckbAndroid = findViewById(R.id.ckbAndroid);
        ckbNet = findViewById(R.id.ckbNet);
        ckbWeb = findViewById(R.id.ckbWeb);
        btnDky = findViewById(R.id.btnDky);
        btnHuy = findViewById(R.id.btnHuy);


    }
}