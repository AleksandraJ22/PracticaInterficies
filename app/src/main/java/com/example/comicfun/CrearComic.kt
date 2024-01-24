package com.example.comicfun

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class CrearComic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_crear_comic)
    }


    fun regresarAtras(view: View){


        val intent= Intent(this, pantallaCrearEditarComic::class.java).apply{}
        startActivity(intent);

    }


    fun verPersonajes(view:View){


        val intent= Intent(this, personajes::class.java).apply{}
        startActivity(intent);
    }


    fun verFondos(view:View){


        val intent= Intent(this, lista_fondo::class.java).apply{}
        startActivity(intent);
    }


    fun verBurbujas(view:View){


        val intent= Intent(this, lista_burbujas::class.java).apply{}
        startActivity(intent);
    }

fun guardarComic(view:View){


    val intent = Intent(this, guardarComic::class.java).apply{}
    startActivity(intent);
}




}
