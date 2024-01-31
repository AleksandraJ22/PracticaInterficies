package com.example.comicfun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class personajes : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private  lateinit var personajesAdapter: AdapterPersonajes
    private lateinit var personajes: ArrayList<fondo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_personajes1)


        init()
    }
    private fun init(){

        recyclerView = findViewById(R.id.Recycler_View)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        personajes = ArrayList()


        addDataToList()

        personajesAdapter=AdapterPersonajes(personajes)
        recyclerView.adapter = personajesAdapter
    }

    private fun addDataToList(){


        personajes.add(fondo(R.drawable.personaje1))
        personajes.add(fondo(R.drawable.personaje2))
        personajes.add(fondo(R.drawable.perssonaje3))
        personajes.add(fondo(R.drawable.personaje4))

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
