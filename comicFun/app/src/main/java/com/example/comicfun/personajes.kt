package com.example.comicfun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class personajes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_personajes)
    }


    fun OkPersonaje(view:View){



        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);


    }


    fun volverSinSeleccionarNada(view:View){

        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);


    }

}
