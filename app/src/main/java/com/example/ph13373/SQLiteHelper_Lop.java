package com.example.ph13373;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper_Lop extends SQLiteOpenHelper {
    public static final String DB_NAME="ds_lop";
    public static final int VERSION=1;
    public SQLiteHelper_Lop( Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LopDAL.SQL_CREATETABLE_LOP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Lop");
    }
}
