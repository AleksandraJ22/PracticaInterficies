package com.example.comicfun


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class seleccionarComic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seleccionar_comic)
    }


    fun regresarAtras(view: View){


        val intent= Intent(this, pantallaCrearEditarComic::class.java).apply{}
        startActivity(intent);

    }

    fun comicSeleccionado(view: View){


        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);

    }
    fun volverAtras(view: View){


        val intent= Intent(this, pantallaCrearEditarComic::class.java).apply{}
        startActivity(intent);

    }

}
