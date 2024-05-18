package com.example.comicfun


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.comicfun.data.comic

class pantallaCrearEditarComic : AppCompatActivity() {
    val db = DBHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_bienbenida)
        val btn_crear_comic = findViewById<Button>(R.id.button6)
        val nombreUsuarioTextView = findViewById<TextView>(R.id.textView10)

        val username = intent.getStringExtra("nombre")
        //val id_del_username=intent.getStringExtra("id")?.toInt()
        val id_del_username = intent.getLongExtra("id",-1L).toInt()

        nombreUsuarioTextView.text = "${nombreUsuarioTextView.text} , ${username}"
        ///val buttonShowPopup = findViewById<Button>(R.id.button_show_popup)

       // buttonShowPopup.setOnClickListener {
            showAlertDialog()
        //}
        btn_crear_comic.setOnClickListener {

            val nuevoComic = comic("nuevoComic", id_del_username)

            var id_del_comic = db.guardarComic(nuevoComic, id_del_username)

            val intent= Intent(this,CrearComic::class.java).apply{}
            intent.putExtra("id_comic", id_del_comic)
            startActivity(intent);
//crearComic(id_del_comic)
        }
      /*  val bSalir: Button = findViewById(R.id.salir)


        bSalir.setOnClickListener {

            salir(bSalir)
        }
*/

    }


    fun crearComic(){

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

    private fun showAlertDialog() {

        val builder = AlertDialog.Builder(this)
      //  builder.setTitle("necesitas ayuda...?")
        builder.setMessage("\nDale al botón CREAR para iniciar un nuevo comic \no a EDITAR para recuperar uno ya existente.")
        builder.setCancelable(true) // Makes the dialog cancellable by tapping outside or pressing back
        val dialog = builder.create()
        dialog.show()

        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
        }, 5000)
    }
}