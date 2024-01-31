package com.example.comicfun

import android.content.Intent
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class lista_burbujas : AppCompatActivity() {



    private lateinit var recyclerView: RecyclerView

    private  lateinit var AdapterBurbujas: AdapterBurbujas
    private lateinit var b_dialogo: ArrayList<fondo>

    private lateinit var b_pensamiento: ArrayList<fondo>

    private lateinit var b_grito: ArrayList<fondo>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_burbujas)

        init()
        init2()
        //init3()
    }


    private fun init(){

        recyclerView = findViewById(R.id.recycleView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        b_dialogo = ArrayList()


        addDataToList()

        AdapterBurbujas=AdapterBurbujas(b_dialogo)
        recyclerView.adapter = AdapterBurbujas
    }




    private fun init2(){

        recyclerView=findViewById(R.id.recycleView2)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        b_pensamiento = ArrayList()

        addDataToList()

        AdapterBurbujas=AdapterBurbujas(b_dialogo)
        recyclerView.adapter = AdapterBurbujas
    }


    private fun init3(){

        recyclerView=findViewById(R.id.recycleView3)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        b_grito = ArrayList()


        addDataToList()

        AdapterBurbujas=AdapterBurbujas(b_dialogo)
        recyclerView.adapter = AdapterBurbujas
    }

    private fun addDataToList3(){



    }
    private fun addDataToList2(){


        b_grito.add(fondo(R.drawable.grito))
        b_grito.add(fondo(R.drawable.grito2))


    }
    private fun addDataToList(){

        b_dialogo.add(fondo(R.drawable.burbuja_dialogo))
        b_dialogo.add(fondo(R.drawable.burbuja_dialogo1))
        b_dialogo.add(fondo(R.drawable.dialogo3))
        b_dialogo.add(fondo(R.drawable.dialogo_4))
        b_dialogo.add(fondo(R.drawable.dialogo5))

    }

    fun OkBurbuja(view: View){

        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);

    }


    fun volverSinSeleccionarburbuja(view: View){

        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);


    }
}