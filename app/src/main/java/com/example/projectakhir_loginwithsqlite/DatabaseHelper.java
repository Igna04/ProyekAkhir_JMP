package com.example.projectakhir_loginwithsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName = "igna.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "igna.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table users(email TEXT primary key, password TEXT)");
        MyDatabase.execSQL("create Table crud(nim TEXT primary key, nama TEXT, tanggal_lahir TEXT, jenis_kelamin TEXT, alamat TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists crud");
    }

    public Boolean insertData(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = MyDatabase.insert("users", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where email = ?", new String[]{email});

        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where email = ? and password = ?", new String[]{email, password});

        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean insertDataCrud(int nim,String nama,int tanggal_lahir, String jenis_kelamin, String alamat){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nim", nim);
        contentValues.put("nama", nama);
        contentValues.put("tanggal_lahir", tanggal_lahir);
        contentValues.put("jenis_kelamin", jenis_kelamin);
        contentValues.put("alamat", alamat);
        long result = MyDatabase.insert("crud", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<Map<String, String>> getAllMahasiswa() {
        List<Map<String, String>> mahasiswaList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM crud", null);

        if (cursor.moveToFirst()) {
            do {
                Map<String, String> mahasiswaMap = new HashMap<>();
                mahasiswaMap.put("nim", cursor.getString(cursor.getColumnIndex("nim")));
                mahasiswaMap.put("nama", cursor.getString(cursor.getColumnIndex("nama")));
                mahasiswaMap.put("tanggal_lahir", cursor.getString(cursor.getColumnIndex("tanggal_lahir")));
                mahasiswaMap.put("jenis_kelamin", cursor.getString(cursor.getColumnIndex("jenis_kelamin")));
                mahasiswaMap.put("alamat", cursor.getString(cursor.getColumnIndex("alamat")));
                mahasiswaList.add(mahasiswaMap);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return mahasiswaList;
    }
}