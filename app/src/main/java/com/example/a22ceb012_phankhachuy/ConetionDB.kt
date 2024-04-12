package com.example.a22ceb012_phankhachuy

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ConetionDB(context: Context):SQLiteOpenHelper(context,"HOCPHAN",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE HOCPHAN(ID INTEGER  primary key autoincrement,NAME text,TC integer,HK TEXT)") //khởi tạo bảng trong database
        db?.execSQL("INSERT INTO HOCPHAN(NAME,TC,HK) values ('Mobil','3','HK I')")
        db?.execSQL("INSERT INTO HOCPHAN(NAME,TC,HK) values ('Math','2','HK II')")
        db?.execSQL("INSERT INTO HOCPHAN(NAME,TC,HK) values ('C++','2','HK I')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}