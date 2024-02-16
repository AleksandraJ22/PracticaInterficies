package com.example.comicfun

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatosApp(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version:Int)
    : SQLiteOpenHelper(context, name, factory, version){



    val create_table_users = "CREATE TABLE Usuarios" +
            "(ID INT PRIMARY KEY," +
            "NOMBRE TEXT," +
            "APELLIDO TEXT," +
            "PASSWORD TEXT," +
            "GMAIL TEXT)"
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL(create_table_users)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


}