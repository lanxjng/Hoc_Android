package com.example.ptb2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KetQuaPtb2 extends AppCompatActivity {
    //khai bao thanh phan
    private TextView tvkq;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua_ptb2);
        //anh xa
        tvkq = findViewById(R.id.tvkq);
        btnExit = findViewById(R.id.btnExit);
        //xu ly
        //goi intent1
        Intent goiIntent = getIntent();
        //lay bundle tu intent
        Bundle goiBundle = goiIntent.getBundleExtra("DuLieu");
        int a = goiBundle.getInt("soa");
        int b = goiBundle.getInt("sob");
        int c = goiBundle.getInt("soc");
        //giai pt
        giaiPtB2(a,b,c);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void giaiPtB2(int a, int b, int c) {
        String kq = "";
        if (a == 0) {
            if (b == 0 && c==0)
                kq =("Phương trình vô số nghiệm!");

            else if (b==0 && c!= 0)
                kq= "Phương trình vô nghiệm";
            else
                kq=("Phương trình có nghiệm duy nhất: "
                        + "x = " + (-c / b));

        }
        else {
            float delta = b * b - 4 * a * c;
            float x1;
            float x2;

            if (delta > 0) {
                x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
                x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
                kq = ("Phương trình có 2 nghiệm là: "
                        + "x1 = " + x1 + " và x2 = " + x2);
            } else if (delta == 0) {
                x1 = (-b / (2 * a));
                kq = ("Phương trình có nghiệm kép: "
                        + "x1 = x2 = " + x1);
            }
            else
                kq = ("Phương trình vô nghiệm!");

        }

        tvkq.setText(kq);
    }



}