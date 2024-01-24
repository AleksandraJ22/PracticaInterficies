package com.example.comicfun


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button

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


fun verPerfil(view: View?){

        val intent= Intent(this,Perfil::class.java).apply{}
        startActivity(intent);

    }


    fun salir(view:View?){

        finish();
    }

            override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.ver_perfil) {
            verPerfil(null)
            return true
        }
        if(id==R.id.salir){


            return true;

        }

        return super.onOptionsItemSelected(item)
    }


}