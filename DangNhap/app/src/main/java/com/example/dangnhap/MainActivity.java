package com.example.dangnhap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //1.khai báo thành phần
    //2. ánh xạ
    //3. nút thoát
    //4. đăng nhập
    //5. quên mk
    private EditText edtUserName, edtPassWord;
    private Button btnDangNhap, btnQuenMk, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận thoát chương trình !!!");
                builder.setMessage("Bạn có muốn thoát khỏi chương trình không");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog di = builder.create();
                di = builder.show();
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtUserName.getText().toString().isEmpty()|| edtPassWord.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Thông tin không được để trống !!!", Toast.LENGTH_LONG).show();

                }
                else if(edtUserName.getText().toString().equals("admin") &&( edtPassWord.getText().toString().equals("admin"))){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công ^-^ ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "UserName hoặc Password không đúng !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnQuenMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);

            }
        });

    }

    private void anhxa() {
        edtUserName = findViewById(R.id.edtUserName);
        edtPassWord = findViewById(R.id.edtPassWord);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnQuenMk = findViewById(R.id.btnQuenMk);
        btnThoat = findViewById(R.id.btnThoat);
    }
}