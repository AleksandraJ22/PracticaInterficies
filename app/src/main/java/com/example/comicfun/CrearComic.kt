package com.example.comicfun

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class CrearComic : AppCompatActivity() {

    var listaPaneles: ArrayList<panelComic> = ArrayList()
    companion object {
        const val SELECCIONAR_FONDO_REQUEST_CODE = 1 // o cualquier número que elijas
    }
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



    fun onSelectBackgroundButtonClick() {
        val intent = Intent(this, lista_fondo::class.java)
        startActivityForResult(intent, SELECCIONAR_FONDO_REQUEST_CODE)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SELECCIONAR_FONDO_REQUEST_CODE && resultCode == RESULT_OK) {

            val idFondoSeleccionado = data?.getIntExtra("idFondo", -1) ?: -1

            if (idFondoSeleccionado != -1) {

                actualizarPanelesConFondo(idFondoSeleccionado)
            }
        }
    }


    private fun actualizarPanelesConFondo(idFondo: Int) {
        for (panel in listaPaneles) {
            val imageView = panel.imageFondo
            imageView.setImageResource(panel.imageFondo)
        }

        actualizarVista()
    }

}
