package com.example.comicfun

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comicfun.Adapter.AdapterPersonajes
import com.example.comicfun.data.Elemento
import com.google.android.material.snackbar.Snackbar


class personajes : AppCompatActivity() {

    val db = DBHandler(this)


    private lateinit var recyclerView: RecyclerView

    private  lateinit var personajesAdapter: AdapterPersonajes
    private lateinit var personajes: ArrayList<Elemento>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_personajes1)

        //db.insertDataTablaPersonajes()
        init()

    }

    private fun init(){

        recyclerView = findViewById(R.id.Recycler_View)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        personajes = ArrayList()


        addDataToList()

        personajesAdapter= AdapterPersonajes(personajes)
        recyclerView.adapter = personajesAdapter
    }

    private fun addDataToList(){


        val dbHelper = DBHandler(this)

        val elementosFromDB = dbHelper.getElementoPersonaje() // Método para obtener todos los elementos de la base de datos

        personajes.addAll(elementosFromDB)

    }

    fun OkPersonaje(view:View){

        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);


    }


    fun volverSinSeleccionarNada(view:View){

        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);


    }


}
