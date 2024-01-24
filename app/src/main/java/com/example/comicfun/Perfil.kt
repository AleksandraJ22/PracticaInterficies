package com.example.comicfun
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class Perfil : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.pantalla_perfil)
        }



    fun volverMenuPrincipal(view: View?){

        val intent= Intent(this,pantallaCrearEditarComic::class.java).apply{}
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

            return true
        }

        if(id==R.id.menu_principal){
            volverMenuPrincipal(null)
            return true
        }
        if(id==R.id.salir){

            salir(null);
            return true;

        }

        return super.onOptionsItemSelected(item)
    }

}