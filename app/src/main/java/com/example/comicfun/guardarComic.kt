package com.example.comicfun



import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class guardarComic : AppCompatActivity() {
    val db = DBHandler(this)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guardar_comic_buena)

        val editTextNombreComic: EditText = findViewById(R.id.editText2)
        val botonGuardar: Button = findViewById(R.id.boton)
        val botonIrAInicio:TextView = findViewById(R.id.textView30)

        botonGuardar.setOnClickListener {
            val nombreComic = editTextNombreComic.text.toString()

            if (nombreComic.isNotEmpty()) {
//db.guardarComicEnBD()
                guardarInformacionComic(nombreComic)


                botonIrAInicio.setOnClickListener {

                    irAInicio(botonIrAInicio)
                }
            } else {
                Toast.makeText(this, "Por favor, ingresa un nombre para el cómic", Toast.LENGTH_SHORT).show()
            }
        }

      /*  val dialogo1 = AlertDialog.Builder(this)

        dialogo1.setMessage("Volver a inicio")
        dialogo1.setCancelable(false)
        irAInicio(botonIrAInicio)

        dialogo1.show()*/
    }



      /*
        botonIrAInicio.setOnClickListener {
            irAInicio(botonIrAInicio)
        }*/



public fun aceptar() {
    Toast.makeText(this,"Ir a inicio", Toast.LENGTH_SHORT);

}

public fun cancelar() {
    finish();
}
    private fun guardarInformacionComic(nombreComic: String) {
        val prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
        val editor = prefs.edit()

        editor.putString("nombreComic", nombreComic)


        editor.apply()


        //Toast.makeText(this, "Tu comic ha sido guardado!", Toast.LENGTH_SHORT).show()

    }


    fun irAInicio(view:View){

        val intent= Intent(this,pantallaCrearEditarComic::class.java).apply{}
        startActivity(intent);


    }
}

