package com.example.ph13373;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class LopDAL {
    List<Lop> _lstLops;
    private Context context;
    SQLiteHelper_Lop sqLiteHelper_lop;
    SQLiteDatabase db;

    public static final String SQL_CREATETABLE_LOP =
            "CREATE TABLE Lop (MaLop TEXT primary key,TenLop TEXT)";

    public LopDAL(Context context) {
        _lstLops = new ArrayList<>();
        sqLiteHelper_lop= new SQLiteHelper_Lop(context);
        db=sqLiteHelper_lop.getWritableDatabase();
    }
    public  String insertLop(Lop lop){
        ContentValues values = new ContentValues();//tao doi tuong chua du lieu
        values.put("Malop",lop.getMaLop());//dua du lieu vao truong ma lop
        values.put("TenLop",lop.getTenLop());//dua du lieu vao truong ten
        if(db.insert("Lop",null,values)<0){
            return "Them that bai";
        }
        return "Them thanh cong";
    }
    public int getIndexLop(String maLop){
        for (int i=0;i<_lstLops.size();i++){
            if (_lstLops.get(i).getMaLop().equals(maLop)){
                return i;
            }
        }
        return -1;
    }
    public String deleteLop(String maLop){
        if(db.delete("Lop","MaLop=?",new  String[]{maLop})<=0){
            return "Xoa that bai";
        }
        return "Xoa thanh cong";
    }
    public List<Lop> get_lstLops(){
        Cursor cursor = db.query("Lop",null,null,null,null,null,null);
        cursor.moveToFirst();

        while (cursor.isAfterLast()==false){
            Lop lop = new Lop();
            lop.setMaLop(cursor.getString(0));
            lop.setTenLop(cursor.getString(1));
            if (getIndexLop(cursor.getString(0))==-1){
                _lstLops.add(lop);
            }
            cursor.moveToNext();
        }
        cursor.close();
        return _lstLops;
    }
    public List<String> getMaLop(){
        List<String> lst = new ArrayList<>();
        Cursor cursor =db.query("Lop",null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            String malop=cursor.getString(0);
            lst.add(malop);

            cursor.moveToNext();
        }
        cursor.close();
        return lst;

    }
}
