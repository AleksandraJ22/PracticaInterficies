package com.example.comicfun

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import com.example.comicfun.data.Elemento
import com.example.comicfun.data.Registros
import com.example.comicfun.data.comic
import com.example.comicfun.data.panelComic


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
val COLUMN_ID_COMIC="idComic"
val COLUMN_NOMBRE_COMIC = "nombre"
val COLUMN_ID_COMIC_USER="idUser"

//tabla panelComic
val TABLE_NAME_PANEL_COMIC = "panelComic"

val COLUMN_LISTA_PANELES = "listaPaneles"
val column_id_de_panel ="id_panel"
val COLUMN_ID_PANEL_COMIC = "id_panel_comic"
val COLUMN_IMAGE_FONDO ="imageFondo"
val COLUMN_BURBUJA ="burbuja"
val COLUMN_PERSONAJE="personaje"

val TABLE_NAME_HISTORIAL_COMICS= "HistorialComics"
val COLUMN_ID_HC = "idHistorialComic"
val COLUMN_ID_COMIC_USUARIO = "idUsuario"
val COLUMN_ID_COMIC_DEL="idComic"
class DBHandler(var context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,1){

    val dias: Array<String> = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")

    val registros: Array<String> = arrayOf("100", "22", "35", "600", "87")


    override fun onCreate(db: SQLiteDatabase?) {
    val create_table_users = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NOMBRE + " VARCHAR(256), " +
            COLUMN_APELLIDO + " VARCHAR(256), " +
            COLUMN_GMAIL + " VARCHAR(256) UNIQUE, " +
            COLUMN_PASSWORD + " VARCHAR(256)" +


    ")";

      val createTableHC = "CREATE TABLE " + TABLE_NAME_HISTORIAL_COMICS + "(" +
           COLUMN_ID_HC + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
               COLUMN_ID_COMIC_USUARIO +" INTEGER, " +
               COLUMN_ID_COMIC_DEL + " INTEGER, " +
               "FOREIGN KEY($COLUMN_ID_COMIC_USUARIO) REFERENCES $TABLE_NAME($COLUMN_ID), " +
      "FOREIGN KEY($COLUMN_ID_COMIC_DEL) REFERENCES $TABLE_NAME_COMIC($COLUMN_ID_COMIC)" +

      ")";


    val createTableElemento = "CREATE TABLE $TABLE_NAME_ELEMENTOS (" +
            "$COLUMN_ID_ELEMENTO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$COLUMN_ID_PANEL INTEGER, " +
            "$COLUMN_TIPO_ELEMENTO TEXT, " + // Cambiado a TEXT en lugar de VARCHAR(256)
            "$COLUMN_IMAGEN_ELEMENTO TEXT, " + // Cambiado a TEXT en lugar de INTEGER

             "FOREIGN KEY($COLUMN_ID_PANEL) REFERENCES $TABLE_NAME_PANEL_COMIC($column_id_de_panel)" +
            ")";




     val createTablaComic = "CREATE TABLE $TABLE_NAME_COMIC (" +
             "$COLUMN_ID_COMIC INTEGER PRIMARY KEY AUTOINCREMENT, " +
             "$COLUMN_NOMBRE_COMIC TEXT, " +
             "$COLUMN_ID_COMIC_USER INTEGER, " +
             "FOREIGN KEY($COLUMN_ID_COMIC_USER) REFERENCES $TABLE_NAME($COLUMN_ID)" +
             ")";

     val createTablePanelComic = "CREATE TABLE $TABLE_NAME_PANEL_COMIC (" +
             "$column_id_de_panel INTEGER PRIMARY KEY AUTOINCREMENT, " +
             "$COLUMN_ID_COMIC INTEGER, " +

             "$COLUMN_IMAGE_FONDO INTEGER, " +
             "$COLUMN_BURBUJA INTEGER, " +
             "$COLUMN_PERSONAJE INTEGER, " +
             "FOREIGN KEY($COLUMN_ID_COMIC) REFERENCES $TABLE_NAME_COMIC($COLUMN_ID_COMIC), " +
             "FOREIGN KEY($COLUMN_IMAGE_FONDO) REFERENCES $TABLE_NAME_ELEMENTOS($COLUMN_IMAGEN_ELEMENTO), " +
             "FOREIGN KEY($COLUMN_BURBUJA) REFERENCES $TABLE_NAME_ELEMENTOS($COLUMN_IMAGEN_ELEMENTO), " +
             "FOREIGN KEY($COLUMN_PERSONAJE) REFERENCES $TABLE_NAME_ELEMENTOS($COLUMN_IMAGEN_ELEMENTO)" +
             ")"


val createRegistros = "CREATE TABLE registros(" +
        "idRegistro INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "dia TEXT, " +
        "totalRegistros TEXT" +

        ")"

        db?.execSQL(createTablaComic)
      db?.execSQL(createTablePanelComic)

     db?.execSQL(createTableElemento)
        db?.execSQL(create_table_users)

        db?.execSQL(createTableHC)
        db?.execSQL(createRegistros)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_HISTORIAL_COMICS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_ELEMENTOS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_COMIC")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME_PANEL_COMIC")

        onCreate(db)
    }

    fun insertData(user: Usuarios): Long{
        var userId = -1L
        try {
            val db = this.writableDatabase
            val cv = ContentValues()

            cv.put(COLUMN_NOMBRE, user.NOMBRE)
            cv.put(COLUMN_APELLIDO, user.APELLIDO)
            cv.put(COLUMN_GMAIL, user.GMAIL)
            cv.put(COLUMN_PASSWORD, user.PASSWORD)

            userId = db.insert("Usuarios", null, cv)
            //val result = db.insert("Usuarios", null, cv)

            if (userId != -1L) {
               Toast.makeText(context, "Success insertData", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "ID del nuevo usuario: $userId", Toast.LENGTH_SHORT).show()
               // Toast.makeText(context, "Usuario insertado - Nombre: ${user.NOMBRE}, Apellido: ${user.APELLIDO}, Correo: ${user.GMAIL}",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
               // Toast.makeText(context, "Error al insertar usuario en la base de datos",Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(context,"Error al insertar datos en la base de datos: ${e.message}",Toast.LENGTH_SHORT).show()
        }

        return userId

    }
   public fun insertUsuario(user: Usuarios): Boolean{
        var resultado = false
        var userId = -1L
        try {
            val db = this.writableDatabase
            val cv = ContentValues()

            cv.put(COLUMN_NOMBRE, user.NOMBRE)
            cv.put(COLUMN_APELLIDO, user.APELLIDO)
            cv.put(COLUMN_GMAIL, user.GMAIL)
            cv.put(COLUMN_PASSWORD, user.PASSWORD)

            userId = db.insert("Usuarios", null, cv)
            //val result = db.insert("Usuarios", null, cv)

            if (userId != -1L) {
                resultado = true

            }
        } catch (e: Exception) {
            Toast.makeText(context,"Error al insertar datos en la base de datos: ${e.message}",Toast.LENGTH_SHORT).show()
        }

        return resultado

    }
    fun insertDataTablaPersonajes() {
        try {
            val db = this.writableDatabase
            val cv = ContentValues()

            val personajes = listOf(
                Elemento(null, null, R.drawable.personaje1, "personaje"),
                Elemento(null, null, R.drawable.personaje2, "personaje"),
                Elemento(null, null, R.drawable.perssonaje3, "personaje"),
                Elemento(null, null, R.drawable.personaje4, "personaje")
            )

            for (personaje in personajes) {
                cv.put(COLUMN_ID_PANEL, personaje.idPanel)
                cv.put(COLUMN_TIPO_ELEMENTO, personaje.tipoElemento)
                cv.put(COLUMN_IMAGEN_ELEMENTO, personaje.imagenElemento)

                val newRowId = db.insert(TABLE_NAME_ELEMENTOS, null, cv)

                if (newRowId != -1L) {
                    //Toast.makeText(context, "Elemento insertado correctamente", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            Toast.makeText(context, "Error al insertar datos en la base de datos: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }



    fun crearComic(){




    }



    fun guardarComic(infoComic: comic, userId: Int) : Long{
        var idComic = -1L
        try {
            val db = this.writableDatabase
            val cv = ContentValues()

            cv.put(COLUMN_NOMBRE_COMIC, infoComic.nombre)
            cv.put(COLUMN_ID_COMIC_USER, userId)

            //val result = db.insert(TABLE_NAME_COMIC, null, cv)
            idComic = db.insert(TABLE_NAME_COMIC, null, cv)
            if (idComic != -1L) {
                Toast.makeText(context, "Cómic guardado correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Error al guardar el cómic", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(context, "Error al guardar el cómic: ${e.message}", Toast.LENGTH_SHORT).show()
        }

        return idComic
    }

    fun cambiarNombreComic(nombreNuevo: String, userId: Int): Int {
        var idComic = -1

        try {
            val db = this.writableDatabase
            val cv = ContentValues()

            cv.put(COLUMN_NOMBRE_COMIC, nombreNuevo)


            val whereClause = "$COLUMN_ID_COMIC_USER = ?"
            val whereArgs = arrayOf(userId.toString())


            idComic = db.update(TABLE_NAME_COMIC, cv, whereClause, whereArgs)

            if (idComic != -1) {

                Toast.makeText(context, "Nuevo nombre: "+ {nombreNuevo}, Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(context, "Error al actualizar el cómic", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(context, "Error al actualizar el cómic: ${e.message}", Toast.LENGTH_SHORT).show()
        }

        return idComic
    }


    fun guardarPanelComic(panel: panelComic, comicId: Int) {

        try {
            val db = this.writableDatabase
            val cv = ContentValues()

            cv.put(COLUMN_ID_COMIC, comicId)
            cv.put(COLUMN_IMAGE_FONDO, panel.imageFondo)
            cv.put(COLUMN_BURBUJA, panel.burbuja)
            cv.put(COLUMN_PERSONAJE, panel.personaje)

            val result = db.insert(TABLE_NAME_PANEL_COMIC, null, cv)
            if (result != -1L) {
                Toast.makeText(context, "Panel guardado correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Error al guardar el panel", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(context, "Error al guardar el panel: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }



    fun checkearUsuario(email: String): Boolean {
        val db = this.readableDatabase
        val cursor =
            db.rawQuery("SELECT $COLUMN_GMAIL FROM $TABLE_NAME WHERE $COLUMN_GMAIL = ?", arrayOf(email))
        val count = cursor.count
        cursor.close()

        return count==0

    }


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
                userData = Usuarios(nombre, apellido, user, contra)
            }
        }

        cursor.close()
        db.close()

        return userData
    }

fun getElementoPersonaje():List<Elemento>{

    val elementos = mutableListOf<Elemento>()
    val db = this.readableDatabase
    val query = "SELECT * FROM $TABLE_NAME_ELEMENTOS WHERE $COLUMN_TIPO_ELEMENTO = 'personaje' "
    val cursor = db.rawQuery(query,null)
    cursor.use { // Garantiza que el cursor se cierre al finalizar el bloque
        while (cursor.moveToNext()) {
            val idIndex = cursor.getColumnIndex(COLUMN_ID_ELEMENTO)

            val id_panel_index = cursor.getColumnIndex(COLUMN_ID_PANEL)

            val imagenIndex = cursor.getColumnIndex(COLUMN_IMAGEN_ELEMENTO)
            val tipoIndex = cursor.getColumnIndex(COLUMN_TIPO_ELEMENTO)


            val idElemento = cursor.getInt(idIndex)
            val panelId = cursor.getInt(id_panel_index)
            val image = cursor.getInt(imagenIndex)
            val tipo = cursor.getString(tipoIndex)



            elementos.add(Elemento(idElemento, panelId, image, tipo))
        }
    }

    return elementos;


}

    fun addElementos(){


    }








}