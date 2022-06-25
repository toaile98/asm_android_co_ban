package com.example.ph13373;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemLop extends AppCompatActivity {
    EditText txt_malop,txt_tenLop;
    Button btn_clear,btn_addLop;
    LopDAL lopDAL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_lop);
        txt_malop=findViewById(R.id.txt_maLop);
        txt_tenLop=findViewById(R.id.txt_tenLop);
        btn_clear=findViewById(R.id.btn_clear);
        btn_addLop=findViewById(R.id.btn_addLop);
        lopDAL = new LopDAL(ThemLop.this);
    }

    public void clear_themlop(View view) {
        txt_tenLop.setText("");
        txt_malop.setText("");
    }

    public void addLop(View view) {
        Lop lop = new Lop();
        lop.setMaLop(txt_malop.getText().toString());
        lop.setTenLop(txt_tenLop.getText().toString());
        Toast.makeText(this,lopDAL.insertLop(lop),Toast.LENGTH_SHORT).show();
    }
}