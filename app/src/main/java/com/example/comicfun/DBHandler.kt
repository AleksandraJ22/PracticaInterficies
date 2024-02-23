package com.example.comicfun

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


val DATABASE_NAME = "BD"
val TABLE_NAME="Usuarios"

 val COLUMN_ID = "ID"
val COLUMN_NOMBRE = "NOMBRE"
val COLUMN_APELLIDO = "APELLIDO"
 val COLUMN_PASSWORD = "PASSWORD"
val COLUMN_GMAIL = "GMAIL"


class DBHandler(var context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,1){


    override fun onCreate(db: SQLiteDatabase?) {
        val create_table_users = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOMBRE+" VARCHAR(256), " +
                COLUMN_APELLIDO+ "VARCHAR(256), " +
                COLUMN_GMAIL+" VARCHAR(256) " +
                COLUMN_PASSWORD+ "VARCHAR(256)"
               ;

        db?.execSQL(create_table_users)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user: Usuarios){
val db = this.writableDatabase
        var cv = ContentValues()


        cv.put(COLUMN_NOMBRE, user.NOMBRE)
        cv.put(COLUMN_APELLIDO,user.APELLIDO)
        cv.put(COLUMN_GMAIL,user.GMAIL)
        cv.put(COLUMN_PASSWORD,user.PASSWORD)

       var result = db.insert("Usuarios", null, cv)


if(result == -1.toLong())
    Toast.makeText(context, "Failed",Toast.LENGTH_SHORT).show()
else
    Toast.makeText(context, "Success",Toast.LENGTH_SHORT).show()



    }
}