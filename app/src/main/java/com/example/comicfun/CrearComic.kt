package com.example.comicfun

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comicfun.Adapter.AdapterPanelComic
import com.example.comicfun.data.panelComic


class CrearComic : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView

    private  lateinit var panelAdapter: AdapterPanelComic
    private  lateinit var lista_panel: ArrayList<panelComic>

    private lateinit var botonAgregar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_crear_comic)
        botonAgregar = findViewById(R.id.btn_agregar_panel)
        botonAgregar.setOnClickListener {
            if (lista_panel.size < 5) {
                //val nuevoPanel = panelComic()
                lista_panel.add(panelComic())
                panelAdapter.notifyItemInserted(lista_panel.size - 1)
                recyclerView.scrollToPosition(lista_panel.size - 1)
            } else {

                Toast.makeText(this, "El limite maximo de paneles es 5!", Toast.LENGTH_SHORT).show()
            }
        }

       init()


    }



    private fun init(){

        recyclerView = findViewById(R.id.recyclerView2)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        lista_panel = ArrayList()


        addDataToList()

        panelAdapter= AdapterPanelComic(lista_panel)
        recyclerView.adapter = panelAdapter
    }

    private fun addDataToList(){


        lista_panel.add(panelComic(R.drawable.disco, R.drawable.burbuja_pensamiento,R.drawable.personaje1))


    //  panelAdapter.notifyItemInserted(lista_panel.size - 1)
    //   recyclerView.scrollToPosition(lista_panel.size - 1)

    }
    fun regresarAtras(view: View){


        val intent= Intent(this, pantallaCrearEditarComic::class.java).apply{}
        startActivity(intent);

    }
    fun verPersonajes(view:View){


        val intent= Intent(this, personajes::class.java).apply{}
        startActivity(intent);
    }


    fun verFondos(view:View){


        val intent= Intent(this, lista_fondo::class.java).apply{}
        startActivity(intent);
    }


    fun verBurbujas(view:View){


        val intent= Intent(this, lista_burbujas::class.java).apply{}
        startActivity(intent);
    }

fun guardarComic(view:View){


    val intent = Intent(this, guardarComic::class.java).apply{}
    startActivity(intent);
}


}
