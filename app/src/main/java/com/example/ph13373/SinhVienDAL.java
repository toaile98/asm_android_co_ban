package com.example.ph13373;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAL {
    List<String> _lstSinhViens;
    private Context context;
    SQLiteHelper_sinhVien sqLiteHelper_sinhVien;
    SQLiteDatabase db;

    public static final String SQL_CREATETABLE_SinhVIen =
            "CREATE TABLE SinhVien (maLop TEXT NOT NULL CONSTRAINT malop REFERENCES Lop(MaLop) ON DELETE CASCADE ,tenSV TEXT primary key ,ngaySinh TEXT )";

    public SinhVienDAL(Context context) {
        _lstSinhViens = new ArrayList<>();
        sqLiteHelper_sinhVien=new SQLiteHelper_sinhVien(context);
        db=sqLiteHelper_sinhVien.getWritableDatabase();
    }


    public String insertSinhVien(SinhVien sv){
        if(sv.getTenSV().isEmpty()||sv.getMaLop().isEmpty()){
            return "them that bai";
        }else {
            ContentValues values = new ContentValues();
            values.put("maLop", sv.getMaLop());
            values.put("tenSV", sv.getTenSV());
            values.put("ngaySinh", sv.getNgaySinh());


            if (db.insert("SinhVien", null, values) < 0) {
                return "Them that bai";
            }
            return "Them thanh cong";
        }
    }

    public String deleteSV_lop(String maLop){
        if(db.delete("SinhVien","maLop=?",new String[]{maLop})<=0){
            return "Xoa that bai";
        }
        return "Xoa thanh cong";
    }
    public String deleteSV_ten(String ten){
        if(db.delete("SinhVien","tenSV=?",new String[]{ten})<=0){
            return "Xoa that bai";
        }
        return "Xoa thanh cong";
    }

    public List<String> get_lstSinhViens(String malop){
        String sv="";
        Cursor cursor = db.query("SinhVien",null,null,null,null,null,null);
        cursor.moveToFirst();
        int i=1;
        while (cursor.isAfterLast()==false) {

            if (cursor.getString(0).toString().equals(malop)) {

                sv=cursor.getString(1)+"_"+cursor.getString(2);


                _lstSinhViens.add(sv);
            }



            cursor.moveToNext();
        }
        cursor.close();
        return _lstSinhViens;
    }
    public String update(String ngaySinh, String ten){
        ContentValues values = new ContentValues();
        values.put("ngaySinh",ngaySinh);
        if(db.update("SinhVien",values,"tenSV=?",new  String[]{ten})<=0){
            return "Sua that bai";
        }
        return "Sua thanh cong";
    }
}
