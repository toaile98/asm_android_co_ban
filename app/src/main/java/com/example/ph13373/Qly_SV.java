package com.example.ph13373;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Qly_SV extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText txt_tenSV,txt_ngaysSinh;
    Spinner spinner_lop;
    Button btn_themSV;
    ListView lv_sinhvien;
    List<String> _lst_MaLop=null;
    List<String> _lst_SinhVien;
    LopDAL lopDAL;
    SinhVienDAL sinhVienDAL ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qly_sv);
        txt_ngaysSinh=findViewById(R.id.txt_ngaySinh);
        txt_tenSV=findViewById(R.id.txt_tenSv);
        btn_themSV=findViewById(R.id.btn_themSinhVien);
        spinner_lop=findViewById(R.id.spinner);
        lv_sinhvien=findViewById(R.id.lv_ds_sinhvien);

        lopDAL=new LopDAL(Qly_SV.this);
        sinhVienDAL = new SinhVienDAL(Qly_SV.this);
        _lst_MaLop=lopDAL.getMaLop();



        ArrayAdapter aa =new ArrayAdapter(this, android.R.layout.simple_spinner_item,_lst_MaLop);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_lop.setAdapter(aa);
        spinner_lop.setOnItemSelectedListener(this);


//        _lst_SinhVien.removeAll(_lst_SinhVien);
        if (!(spinner_lop.getSelectedItem()==null)){
            _lst_SinhVien =sinhVienDAL.get_lstSinhViens(spinner_lop.getSelectedItem().toString());
            ArrayAdapter sv=new ArrayAdapter(this, android.R.layout.simple_list_item_1,_lst_SinhVien);
            lv_sinhvien.setAdapter(sv);
        }

//        ArrayAdapter sv=new ArrayAdapter(this, android.R.layout.simple_list_item_1,_lst_SinhVien);
//        lv_sinhvien.setAdapter(sv);

        lv_sinhvien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
                String arrname= _lst_SinhVien.get(position).toString();
                String ten=arrname.substring(0,arrname.indexOf("_"));
                String ngaySinh=arrname.substring(arrname.indexOf("_")+1,arrname.length());
                String maLop=spinner_lop.getSelectedItem().toString();
                txt_tenSV.setText(ten);
                txt_ngaysSinh.setText(ngaySinh);


            }
        });

        final int[] check = {0};
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(Qly_SV.this);
        aBuilder.setMessage("Ban co muon xoa sinh vien?");
        aBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                check[0] =1;
                finish();
            }
        });
        aBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog=aBuilder.create();

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        _lst_SinhVien.removeAll(_lst_SinhVien);
        _lst_SinhVien =sinhVienDAL.get_lstSinhViens(spinner_lop.getSelectedItem().toString());
        ArrayAdapter sv=new ArrayAdapter(this, android.R.layout.simple_list_item_1,_lst_SinhVien);
        lv_sinhvien.setAdapter(sv);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void themSinhVien(View view) {
        SinhVien sinhVien = new SinhVien();


        sinhVien.setTenSV(txt_tenSV.getText().toString());
        sinhVien.setNgaySinh(txt_ngaysSinh.getText().toString());
        sinhVien.setMaLop(String.valueOf(spinner_lop.getSelectedItem()));
        Toast.makeText(this,sinhVienDAL.insertSinhVien(sinhVien),Toast.LENGTH_SHORT).show();
        _lst_SinhVien.removeAll(_lst_SinhVien);
        _lst_SinhVien =sinhVienDAL.get_lstSinhViens(spinner_lop.getSelectedItem().toString());
        ArrayAdapter sv=new ArrayAdapter(this, android.R.layout.simple_list_item_1,_lst_SinhVien);
        lv_sinhvien.setAdapter(sv);
    }

    public void SuaSV(View view) {

        Toast.makeText(this,sinhVienDAL.update(txt_ngaysSinh.getText().toString(),txt_tenSV.getText().toString()),Toast.LENGTH_SHORT).show();
        _lst_SinhVien.removeAll(_lst_SinhVien);
        _lst_SinhVien =sinhVienDAL.get_lstSinhViens(spinner_lop.getSelectedItem().toString());
        ArrayAdapter sv=new ArrayAdapter(this, android.R.layout.simple_list_item_1,_lst_SinhVien);
        lv_sinhvien.setAdapter(sv);
    }

    public void XoaSV(View view) {



        Toast.makeText(this,sinhVienDAL.deleteSV_ten(txt_tenSV.getText().toString()),Toast.LENGTH_SHORT).show();
        _lst_SinhVien.removeAll(_lst_SinhVien);
        _lst_SinhVien =sinhVienDAL.get_lstSinhViens(spinner_lop.getSelectedItem().toString());
        ArrayAdapter sv=new ArrayAdapter(this, android.R.layout.simple_list_item_1,_lst_SinhVien);
        lv_sinhvien.setAdapter(sv);

    }
}