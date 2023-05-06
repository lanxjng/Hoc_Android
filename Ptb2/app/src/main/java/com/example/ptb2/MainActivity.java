package com.example.ptb2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private EditText edta, edtb, edtc;
    private Button btnGiaiPt, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        btnGiaiPt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,KetQuaPtb2.class);
                Bundle bundle1 = new Bundle();
                int a,b,c;
                a = Integer.parseInt(edta.getText().toString());
                b = Integer.parseInt(edtb.getText().toString());
                c = Integer.parseInt(edtc.getText().toString());
                //dua dl vao bundle
                bundle1.putInt("soa",a);
                bundle1.putInt("sob",b);
                bundle1.putInt("soc",c);
                //dua bundle vao intent1
                intent1.putExtra("DuLieu", bundle1);
                startActivity(intent1);
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void anhxa() {
        edta = findViewById(R.id.edtA);
        edtb = findViewById(R.id.edtB);
        edtc = findViewById(R.id.edtC);
        btnGiaiPt = findViewById(R.id.btnGiai);
        btnThoat = findViewById(R.id.btnThoat);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }
}