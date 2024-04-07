package com.example.comicfun

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLiteOpenHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {

        val db : DBHandler

        sqLiteDatabase.execSQL(

            "CREATE TABLE registros(" +
                    "idRegistro INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "dia TEXT, " +
                    "totalRegistros TEXT" +

                    ")"

        );

    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {

    }
}
