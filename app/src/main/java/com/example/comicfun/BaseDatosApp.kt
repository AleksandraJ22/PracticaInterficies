package com.example.comicfun

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class BaseDatosApp(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version:Int)
    : SQLiteOpenHelper(context, name, factory, version){

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "UsuariosDB"
        private const val TABLE_NAME = "Usuarios"
        private const val COLUMN_ID = "ID"
        private const val COLUMN_NOMBRE = "NOMBRE"
        private const val COLUMN_APELLIDO = "APELLIDO"
        private const val COLUMN_PASSWORD = "PASSWORD"
        private const val COLUMN_GMAIL = "GMAIL"
    }


    private val create_table_users = "CREATE TABLE $TABLE_NAME (" +
            "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "$COLUMN_NOMBRE TEXT," +
            "$COLUMN_APELLIDO TEXT," +
            "$COLUMN_PASSWORD TEXT," +
            "$COLUMN_GMAIL TEXT)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(create_table_users)
        //Toast.makeText(this, "Base de datos creada correctamente", Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }


}