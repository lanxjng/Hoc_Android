package com.example.dangnhap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText edtPass, edtUser, edtRepass;
    private Button btnDN, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhxa();
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtUser.getText().toString().isEmpty() || edtPass.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity2.this,"Thông tin không được để trống !!!",Toast.LENGTH_LONG).show();
                }
                else if(edtPass.getText().toString().equals(edtRepass.getText().toString())){
                    Toast.makeText(MainActivity2.this,"Đăng nhập thành công ^-^ ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity2.this, "UserName hoặc Password không đúng !!!", Toast.LENGTH_LONG).show();
                }

            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                builder.setTitle("Xác nhận thoát chương trình !!!");
                builder.setMessage("Bạn có muốn thoát khỏi chương trình không ?");
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
                AlertDialog d1 = builder.create();
                d1 = builder.show();
            }
        });

    }

    private void anhxa() {
        edtPass = findViewById(R.id.edtPass1);
        edtUser = findViewById(R.id.edtUser1);
        edtRepass = findViewById(R.id.edtRePass);
        btnDN = findViewById(R.id.btnDN);
        btnExit = findViewById(R.id.btnExit);
    }
}