package com.example.comicfun


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comicfun.Adapter.AdapterSeleccionarComic
import com.example.comicfun.data.comic

class seleccionarComic : AppCompatActivity() {

    private lateinit var rv: RecyclerView

    private  lateinit var adapter: AdapterSeleccionarComic
    private lateinit var listaDeComics: ArrayList<comic>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seleccionar_comic)


        init()
        showAlertDialog()
    }

    private fun init(){

        rv = findViewById(R.id.recyclerView)
        rv.setHasFixedSize(true)
        rv.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        listaDeComics = ArrayList()


        //addDataToList()

        adapter= AdapterSeleccionarComic(listaDeComics)
        rv.adapter = adapter
    }
   /* private fun addDataToList(){


        listaDeComics.add(comic(1, "comic1", ArrayList(),0))
        listaDeComics.add(comic(2,"comic2",ArrayList(),0))
        listaDeComics.add(comic(3,"comic3",ArrayList(),0))
        listaDeComics.add(comic(4, "comic4",ArrayList(),0))

        listaDeComics.add(comic(5, "comic5",ArrayList(),0))
        listaDeComics.add(comic(6,"comic6",ArrayList(),0))
        listaDeComics.add(comic(7,"comic7",ArrayList(),0))
        listaDeComics.add(comic(8, "comic8",ArrayList(),0))

    }*/
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

    private fun showAlertDialog() {

        val builder = AlertDialog.Builder(this)
        //  builder.setTitle("necesitas ayuda...?")
        builder.setMessage("Empieza por crear un nuevo comic ;)")
        builder.setCancelable(true) // Makes the dialog cancellable by tapping outside or pressing back
        val dialog = builder.create()
        dialog.show()

        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
        }, 5000)
    }


}