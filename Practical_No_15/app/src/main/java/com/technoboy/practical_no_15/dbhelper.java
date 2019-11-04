package com.technoboy.practical_no_15;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.nio.DoubleBuffer;

public class dbhelper extends SQLiteOpenHelper {

    private static final String Db_Name="got.db";
    private static final String Tb_Name="got";
    private static final String Col1="Id";
    private static final String Col2="Name";
    private static final String Col3="House";
    SQLiteDatabase db;
    
    public dbhelper(@Nullable Context context) {
        super(context, Db_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ Tb_Name + "("+Col1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+Col2+" TEXT,"+Col3+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Tb_Name);
    }
    
    public boolean add(String Name,String House)
    {
        db=this.getWritableDatabase();
        ContentValues data=new ContentValues();
        data.put(Col2,Name);
        data.put(Col3,House);
        long result = db.insert(Tb_Name, null, data);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor show()
    {
        db=this.getReadableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+Tb_Name,null);
        return data;
    }
}
