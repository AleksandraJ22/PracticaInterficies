package com.example.comicfun

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import com.example.comicfun.data.Elemento
import com.example.comicfun.data.comic


//tabla usuarios
val DATABASE_NAME = "BD"
val TABLE_NAME="Usuarios"

 val COLUMN_ID = "ID"
val COLUMN_NOMBRE = "NOMBRE"
val COLUMN_APELLIDO = "APELLIDO"
 val COLUMN_PASSWORD = "PASSWORD"
val COLUMN_GMAIL = "GMAIL"
val COLUMN_HC = "historial_comics"

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
val COLUMN_ID_COMIC_USER="idUser"

//tabla panelComic
val TABLE_NAME_PANEL_COMIC = "panelComic"

val COLUMN_LISTA_PANELES = "listaPaneles"
val COLUMN_ID_PANEL_COMIC
= "id"
val COLUMN_IMAGE_FONDO ="imageFondo"
val COLUMN_BURBUJA ="burbuja"
val COLUMN_PERSONAJE="personaje"

val TABLE_NAME_HISTORIAL_COMICS= "HistorialComics"
val COLUMN_ID_HC = "idHistorialComic"
val COLUMN_ID_COMIC_USUARIO = "idUsuario"
val COLUMN_ID_COMIC_DEL="idComic"
class DBHandler(var context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,1){

    override fun onCreate(db: SQLiteDatabase?) {
        val create_table_users = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOMBRE + " VARCHAR(256), " +
                COLUMN_APELLIDO + " VARCHAR(256), " +
                COLUMN_GMAIL + " VARCHAR(256) UNIQUE, " +
                COLUMN_PASSWORD + " VARCHAR(256)"


                ")";

     /*   val createTableHC = "CREATE TABLE " + TABLE_NAME_HISTORIAL_COMICS + "(" +
            COLUMN_ID_HC + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ID_COMIC_USUARIO +" INTEGER, " +
                COLUMN_ID_COMIC_DEL + " INTEGER, " +
                "FOREIGN KEY($COLUMN_ID_COMIC_USUARIO) REFERENCES $TABLE_NAME($COLUMN_ID), " +
       "FOREIGN KEY($COLUMN_ID_COMIC_DEL) REFERENCES $TABLE_NAME_COMIC($COLUMN_ID_COMIC)" +

       ")";*/

        val createTableElemento = "CREATE TABLE " + TABLE_NAME_ELEMENTOS  + "(" +
                "$COLUMN_ID_ELEMENTO INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_ID_PANEL INTEGER, " +
                "$COLUMN_TIPO_ELEMENTO VARCHAR(256)," +
                "$COLUMN_IMAGEN_ELEMENTO INTEGER, " +
               /* "FOREIGN KEY($COLUMN_ID_PANEL) REFERENCES $TABLE_NAME_PANEL_COMIC($COLUMN_ID_PANEL_COMIC)" +*/
                ")";


      /*  val createTablaComic = "CREATE TABLE $TABLE_NAME_COMIC (" +
                "$COLUMN_ID_COMIC INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NOMBRE_COMIC TEXT, " +
                "FOREIGN KEY($COLUMN_ID_COMIC_USER) REFERENCES $TABLE_NAME($COLUMN_ID)"+
                ")"*/

       /* val createTablaComic = "CREATE TABLE $TABLE_NAME_COMIC (" +
                "$COLUMN_ID_COMIC INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NOMBRE_COMIC TEXT, " +
                "$COLUMN_ID_COMIC_USER INTEGER, " +
                "FOREIGN KEY($COLUMN_ID_COMIC_USER) REFERENCES $TABLE_NAME($COLUMN_ID)" +
                ")"
*/
     /*   val createTablePanelComic = "CREATE TABLE $TABLE_NAME_PANEL_COMIC (" +
                "$COLUMN_ID_PANEL_COMIC INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_ID_COMIC INTEGER, " +
                "$COLUMN_IMAGE_FONDO INTEGER, " +
                "$COLUMN_BURBUJA INTEGER, " +
                "$COLUMN_PERSONAJE INTEGER, " +
                "FOREIGN KEY($COLUMN_ID_COMIC) REFERENCES $TABLE_NAME_COMIC($COLUMN_ID_COMIC), " +
                "FOREIGN KEY($COLUMN_IMAGE_FONDO) REFERENCES $TABLE_NAME_ELEMENTOS($COLUMN_IMAGEN_ELEMENTO)" +

                ")"*/
       /* val createTablePanelComic = "CREATE TABLE $TABLE_NAME_PANEL_COMIC (" +
                "$COLUMN_ID_PANEL_COMIC INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_ID_COMIC INTEGER, " +
                "$COLUMN_IMAGE_FONDO INTEGER, " +
                "$COLUMN_BURBUJA INTEGER, " +
                "$COLUMN_PERSONAJE INTEGER, " +
                "FOREIGN KEY($COLUMN_ID_COMIC) REFERENCES $TABLE_NAME_COMIC($COLUMN_ID_COMIC), " +
                "FOREIGN KEY($COLUMN_IMAGE_FONDO) REFERENCES $TABLE_NAME_ELEMENTOS($COLUMN_IMAGEN_ELEMENTO), " +
                "FOREIGN KEY($COLUMN_BURBUJA) REFERENCES $TABLE_NAME_ELEMENTOS($COLUMN_IMAGEN_ELEMENTO), " +
                "FOREIGN KEY($COLUMN_PERSONAJE) REFERENCES $TABLE_NAME_ELEMENTOS($COLUMN_IMAGEN_ELEMENTO)" +
                ")"*/


      //  db?.execSQL(createTablaComic)
      // db?.execSQL(createTablePanelComic)

     db?.execSQL(createTableElemento)
        db?.execSQL(create_table_users)

      //  db?.execSQL(createTableHC)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_HISTORIAL_COMICS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_ELEMENTOS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_COMIC")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_PANEL_COMIC")

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
               Toast.makeText(context, "Success insertData", Toast.LENGTH_SHORT).show()

               // Toast.makeText(context, "Usuario insertado - Nombre: ${user.NOMBRE}, Apellido: ${user.APELLIDO}, Correo: ${user.GMAIL}",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
               // Toast.makeText(context, "Error al insertar usuario en la base de datos",Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(context,"Error al insertar datos en la base de datos: ${e.message}",Toast.LENGTH_SHORT).show()
        }
    }

    fun insertDataTablaPersonajes(elem: Elemento){
try {
    val db = this.writableDatabase
    val cv = ContentValues()

    cv.put(COLUMN_ID_PANEL, elem.idPanel)
    cv.put(COLUMN_TIPO_ELEMENTO, elem.tipoElemento)
    cv.put(COLUMN_IMAGEN_ELEMENTO, elem.imagenElemento)


    val newRowId = db.insert("Elementos", null, cv)
    Toast.makeText(context, "Hola", Toast.LENGTH_SHORT).show()
    if (newRowId != -1L) {
        Toast.makeText(context, "Elemento insertado correctamente", Toast.LENGTH_SHORT).show()

    } else {
        Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()

    }
} catch (e: Exception) {
        Toast.makeText(context,"Error al insertar datos en la base de datos: ${e.message}",Toast.LENGTH_SHORT).show()
    }

    }
/*
    fun checkearUsuario(email: String): Boolean {
        val db = this.readableDatabase
        val cursor =
            db.rawQuery("SELECT $COLUMN_GMAIL FROM $TABLE_NAME WHERE $COLUMN_GMAIL = ?", arrayOf(email))
        val count = cursor.count
        cursor.close()

        return count==0

    }*/
/*
    fun usuarioExiste(email: String): Int{
        val db = this.readableDatabase
        val cursor =
            db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COLUMN_GMAIL = ?", arrayOf(email))
        val count = cursor.count
        cursor.close()

        return count

    }


*/

    fun registerCheckUser(email: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_GMAIL = ?"
        val cursor = db.rawQuery(query, arrayOf(email))

        val existeUsuario = cursor.count == 0

        cursor.close()
        return existeUsuario
    }
    fun loginCheckUser(email: String, contraseña: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_GMAIL = ? AND $COLUMN_PASSWORD = ?"
        val cursor = db.rawQuery(query, arrayOf(email, contraseña))
        val count = cursor.count
         Toast.makeText(context, "login count $count", Toast.LENGTH_SHORT).show()

        cursor.close()

        return count == 1
    }
    @SuppressLint("Range")
    fun getUserData(user: String, contra: String): Usuarios? {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_GMAIL = ? AND $COLUMN_PASSWORD = ?"

        val cursor = db.rawQuery(query, arrayOf(user, contra))

        var userData: Usuarios? = null

        cursor.use { cursor ->
            if (cursor.moveToFirst()) {
                // Se encontró al menos un registro con las credenciales proporcionadas

                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE));
                val apellido = cursor.getString(cursor.getColumnIndex(COLUMN_APELLIDO));
                // Obtén otros campos según sea necesario

                // Crea un objeto Usuarios con los datos recuperados
                userData = Usuarios(nombre, apellido, user, contra, mutableListOf<comic>())
            }
        }

        cursor.close()
        db.close()

        return userData
    }




}