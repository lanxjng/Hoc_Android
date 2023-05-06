package com.example.tablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtTk, edtMk, edtMk2, edtHoTen, edtDiaChi, edtLop, edtSdt, edtEmail;
    Spinner spnTruong, spnNgay, spnThang, spnNam, spnDiaChi;
    RadioButton rbtnNam, rbtnNu;
    Button btnDky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        btnDky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtTk.getText().toString().isEmpty()||edtMk.getText().toString().isEmpty()|| edtMk2.getText().toString().isEmpty()||
                edtHoTen.getText().toString().isEmpty()||edtDiaChi.getText().toString().isEmpty()||edtLop.getText().toString().isEmpty()||
                edtLop.getText().toString().isEmpty()||edtSdt.getText().toString().isEmpty()||edtEmail.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Thông tin không được để trống !!!",Toast.LENGTH_LONG).show();
                }
                else if(edtMk.getText().toString().equals(edtMk2.getText().toString())){
                    Toast.makeText(MainActivity.this,"Đăng nhập thành công ^-^ ",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(MainActivity.this,"Thông tin không chính xác, Vui lòng kiểm tra lại thông tin!!! ",Toast.LENGTH_LONG).show();

            }
        });
        


    }

    private void anhxa() {
        edtTk = findViewById(R.id.edtTk);
        edtMk = findViewById(R.id.edtMk);
        edtMk2 = findViewById(R.id.edtMk2);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtDiaChi = findViewById(R.id.edtDiaChiCuThe);
        edtLop = findViewById(R.id.edtLop);
        edtSdt = findViewById(R.id.edtSdt);
        edtEmail = findViewById(R.id.edtEmail);
        spnTruong = findViewById(R.id.spTruong);
        spnDiaChi = findViewById(R.id.spDiaChi);
        spnNgay = findViewById(R.id.spNgay);
        spnThang = findViewById(R.id.spThang);
        spnNam = findViewById(R.id.spNam);
        rbtnNam = findViewById(R.id.rdbtnNam);
        rbtnNu = findViewById(R.id.rdbtnNu);
        btnDky = findViewById(R.id.btnDky);

    }
}