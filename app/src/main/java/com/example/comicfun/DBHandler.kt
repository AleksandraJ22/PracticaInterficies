package com.example.comicfun

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast




//tabla usuarios
val DATABASE_NAME = "BD"
val TABLE_NAME="Usuarios"

 val COLUMN_ID = "ID"
val COLUMN_NOMBRE = "NOMBRE"
val COLUMN_APELLIDO = "APELLIDO"
 val COLUMN_PASSWORD = "PASSWORD"
val COLUMN_GMAIL = "GMAIL"

//tabla Elementos
val TABLE_NAME_ELEMENTOS = "Elementos"

val COLUMN_ID_ELEMENTO = "idElemento"
val COLUMN_ID_PANEL = "idPanel"
val COLUMN_IMAGEN_ELEMENTO= "imagenElemento"
val COLUMN_TIPO_ELEMENTO = "tipoElemento"

//tabla comic

val TABLE_NAME_COMIC="Comic"
val COLUMN_ID_COMIC="id"
val COLUMN_NOMBRE_COMIC = "nombre"

//tabla panelComic
val TABLE_NAME_PANEL_COMIC = "panelComic"

val COLUMN_LISTA_PANELES = "listaPaneles"
val COLUMN_ID_PANEL_COMIC
= "id"
val COLUMN_IMAGE_FONDO ="imageFondo"
val COLUMN_BURBUJA ="burbuja"
val COLUMN_PERSONAJE="personaje"

class DBHandler(var context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,1){



    override fun onCreate(db: SQLiteDatabase?) {
        val create_table_users = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOMBRE + " VARCHAR(256), " +
                COLUMN_APELLIDO + " VARCHAR(256), " +
                COLUMN_GMAIL + " VARCHAR(256) UNIQUE, " +
                COLUMN_PASSWORD + " VARCHAR(256)" +
                ")";

     /*   val createTableElemento = "CREATE TABLE " + TABLE_NAME_ELEMENTOS  + "(" +
                "$COLUMN_ID_ELEMENTO INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_ID_PANEL INTEGER, " +
                "$COLUMN_TIPO_ELEMENTO TEXT," +
                "$COLUMN_IMAGEN_ELEMENTO INTEGER" +
                ")"

        val createTablaComic = "CREATE TABLE $TABLE_NAME_COMIC (" +
                "$COLUMN_ID_COMIC INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NOMBRE_COMIC TEXT " +

                ")"
        val createTablePanelComic = "CREATE TABLE $TABLE_NAME_PANEL_COMIC (" +
                "$COLUMN_ID_PANEL_COMIC INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_ID_COMIC INTEGER, " +
                "$COLUMN_IMAGE_FONDO INTEGER, " +
                "$COLUMN_BURBUJA INTEGER, " +
                "$COLUMN_PERSONAJE INTEGER, " +
                "FOREIGN KEY($COLUMN_ID_COMIC) REFERENCES $TABLE_NAME_COMIC($COLUMN_ID_COMIC)" +
                ")"

        db?.execSQL(createTablaComic)
        db?.execSQL(createTablePanelComic)

        db?.execSQL(create_table_users)
        db?.execSQL(createTableElemento)*/
        db?.execSQL(create_table_users)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(user: Usuarios) {
        try {
            val db = this.writableDatabase
            val cv = ContentValues()

            cv.put(COLUMN_NOMBRE, user.NOMBRE)
            cv.put(COLUMN_APELLIDO, user.APELLIDO)
            cv.put(COLUMN_GMAIL, user.GMAIL)
            cv.put(COLUMN_PASSWORD, user.PASSWORD)

            val result = db.insert("Usuarios", null, cv)

            if (result != -1L) {
               Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()

               // Toast.makeText(context, "Usuario insertado - Nombre: ${user.NOMBRE}, Apellido: ${user.APELLIDO}, Correo: ${user.GMAIL}",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
               // Toast.makeText(context, "Error al insertar usuario en la base de datos",Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(context,"Error al insertar datos en la base de datos: ${e.message}",Toast.LENGTH_SHORT).show()
        }
    }

    fun checkearUsuario(email: String, contraseña: String): Boolean {
        val db = this.readableDatabase
        val cursor =
            db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COLUMN_GMAIL = ? AND $COLUMN_PASSWORD = ?", arrayOf(email))
        val count = cursor.count
        cursor.close()

        return count==0

    }


}