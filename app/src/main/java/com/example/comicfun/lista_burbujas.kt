package com.example.comicfun

import android.content.Intent
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comicfun.Adapter.AdapterBurbujas
import com.example.comicfun.data.Elemento

class lista_burbujas : AppCompatActivity() {



    private lateinit var recyclerView: RecyclerView

    private  lateinit var AdapterBurbujas: AdapterBurbujas
    private lateinit var b_dialogo: ArrayList<Elemento>

    private lateinit var b_pensamiento: ArrayList<Elemento>

    private lateinit var b_grito: ArrayList<Elemento>


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

        AdapterBurbujas= AdapterBurbujas(b_dialogo)
        recyclerView.adapter = AdapterBurbujas
    }




    private fun init2(){

        recyclerView=findViewById(R.id.recycleView2)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        b_pensamiento = ArrayList()

        addDataToList()

        AdapterBurbujas= AdapterBurbujas(b_dialogo)
        recyclerView.adapter = AdapterBurbujas
    }


    private fun init3(){

        recyclerView=findViewById(R.id.recycleView3)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        b_grito = ArrayList()


        addDataToList()

        AdapterBurbujas= AdapterBurbujas(b_dialogo)
        recyclerView.adapter = AdapterBurbujas
    }

    private fun addDataToList3(){



    }
    private fun addDataToList2(){


        b_grito.add(Elemento(1,null,R.drawable.grito, "burbuja"))
        b_grito.add(Elemento(2,null,R.drawable.grito2, "burbuja"))


    }
    private fun addDataToList(){

        b_dialogo.add(Elemento(1,null,R.drawable.burbuja_dialogo, "burbuja"))
        b_dialogo.add(Elemento(2,null,R.drawable.burbuja_dialogo1, "burbuja"))
        b_dialogo.add(Elemento(3,null,R.drawable.dialogo3, "burbuja"))
        b_dialogo.add(Elemento(4,null,R.drawable.dialogo_4, "burbuja"))
        b_dialogo.add(Elemento(5,null,R.drawable.dialogo5, "burbuja"))

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