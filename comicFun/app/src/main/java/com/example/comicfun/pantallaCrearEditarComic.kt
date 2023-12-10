package com.example.comicfun


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class pantallaCrearEditarComic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_bienbenida)
    }


    fun crearComic(view:View){

        val intent= Intent(this,CrearComic::class.java).apply{}
        startActivity(intent);
    }


    fun editarComic(view:View){

        val intent= Intent(this,seleccionarComic::class.java).apply{}
        startActivity(intent);


    }


}