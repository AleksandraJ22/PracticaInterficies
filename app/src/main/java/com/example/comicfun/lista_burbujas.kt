package com.example.comicfun

import android.content.Intent
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class lista_burbujas : AppCompatActivity() {



    private lateinit var recyclerView: RecyclerView

    private  lateinit var fondo1Adapter: AdapterFondo1
    private lateinit var fondo1List: ArrayList<fondo>

    private lateinit var fondo2List: ArrayList<fondo>

    private lateinit var fondo3List: ArrayList<fondo>


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
        fondo1List = ArrayList()


        addDataToList()

        fondo1Adapter=AdapterFondo1(fondo1List)
        recyclerView.adapter = fondo1Adapter
    }




    private fun init2(){

        recyclerView=findViewById(R.id.recycleView2)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        fondo2List = ArrayList()

        addDataToList2()

        fondo1Adapter=AdapterFondo1(fondo2List)
        recyclerView.adapter = fondo1Adapter
    }


    private fun init3(){

        recyclerView=findViewById(R.id.recycleView3)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        fondo3List = ArrayList()

        addDataToList3()
        fondo1Adapter=AdapterFondo1(fondo3List)

        recyclerView.adapter = fondo1Adapter
    }

    private fun addDataToList3(){



    }
    private fun addDataToList2(){


        fondo2List.add(fondo(R.drawable.grito))
        fondo2List.add(fondo(R.drawable.grito2))


    }
    private fun addDataToList(){

        fondo1List.add(fondo(R.drawable.burbuja_dialogo))
        fondo1List.add(fondo(R.drawable.burbuja_dialogo1))
        fondo1List.add(fondo(R.drawable.dialogo3))
        fondo1List.add(fondo(R.drawable.dialogo_4))
        fondo1List.add(fondo(R.drawable.dialogo5))

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