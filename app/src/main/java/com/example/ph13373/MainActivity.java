package com.example.ph13373;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_themLop,btn_xemDSLop,btn_QlySV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_QlySV=findViewById(R.id.btn_QuanLySV);
        btn_themLop=findViewById(R.id.btn_themLop);
        btn_xemDSLop=findViewById(R.id.btn_XemDSLop);
    }

    public void ThemLop(View view) {
        Intent intent = new Intent(MainActivity.this,ThemLop.class);
        startActivity(intent);
    }

    public void XemDSLop(View view) {
        Intent intent = new Intent(MainActivity.this,XemDSLop.class);
        startActivity(intent);
    }

    public void QuanLySV(View view) {
        Intent intent = new Intent(MainActivity.this,Qly_SV.class);
        startActivity(intent);
    }
}