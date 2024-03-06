package com.example.comicfun


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView

class pantallaCrearEditarComic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_bienbenida)

      /*  val bSalir: Button = findViewById(R.id.salir)


        bSalir.setOnClickListener {

            salir(bSalir)
        }
*/

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

finish()
            return true;

        }

        return super.onOptionsItemSelected(item)
    }


}