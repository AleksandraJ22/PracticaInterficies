package com.example.comicfun


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

}