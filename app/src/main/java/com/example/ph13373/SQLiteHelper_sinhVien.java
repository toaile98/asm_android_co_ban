package com.example.ph13373;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper_sinhVien extends SQLiteOpenHelper {
    private static final String DB_NAME1="sinhvien";
    private static final int VERSITON=1;
    public SQLiteHelper_sinhVien( Context context) {
        super(context, DB_NAME1, null, VERSITON);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SinhVienDAL.SQL_CREATETABLE_SinhVIen);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS SinhVien");
    }
}
