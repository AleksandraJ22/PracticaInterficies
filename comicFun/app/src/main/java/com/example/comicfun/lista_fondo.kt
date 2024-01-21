package com.example.comicfun

import android.content.Intent
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comicfun.Adapter.viewHolderFondo

class lista_fondo : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView

    private  lateinit var adapter: viewHolderFondo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_fondo1)


        recyclerView = findViewById(R.id.recycleView)
        adapter = viewHolderFondo()

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        recyclerView.adapter=adapter




    }


    fun OkFondo(view: View){



        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);


    }


    fun volverSinSeleccionarFondo(view: View){

        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);


    }

}
