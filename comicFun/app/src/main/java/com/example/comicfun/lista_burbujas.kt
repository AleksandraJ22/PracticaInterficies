package com.example.comicfun

import android.content.Intent
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity

class lista_burbujas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elegir_burbujas)
    }



    fun OkBurbuja(view: View){


        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);


    }


    fun volverSinSeleccionarburbuja(view: View){

        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);


    }
}