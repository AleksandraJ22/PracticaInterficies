package com.example.comicfun

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comicfun.Adapter.AdapterPanelComic
import com.example.comicfun.data.fondo
import com.example.comicfun.data.panelComic


class CrearComic : AppCompatActivity(), lista_fondo.FondoSeleccionadoListener {


    private lateinit var recyclerView: RecyclerView

    private  lateinit var panelAdapter: AdapterPanelComic
    private  lateinit var lista_panel: ArrayList<panelComic>


    private lateinit var botonAgregar: Button

    private var panelSeleccionadoId: Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_crear_comic)
        init()
        controlarPaneles()
        val listaFondo = lista_fondo()
        listaFondo.setFondoSeleccionadoListener(this)


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



lista_panel.add(panelComic(1))


        //lista_panel.add(panelComic(R.drawable.disco, R.drawable.burbuja_pensamiento,R.drawable.personaje1))



    }

    private fun controlarPaneles(){
        var cont: Int=0

        botonAgregar = findViewById(R.id.btn_agregar_panel)
        botonAgregar.setOnClickListener {
            if (lista_panel.size < 5) {

                //addDataToList()
                //val nuevoPanel = panelComic()
               lista_panel.add(panelComic(1))
                panelAdapter.notifyItemInserted(lista_panel.size - 1)
                recyclerView.scrollToPosition(lista_panel.size - 1)
            } else {

                Toast.makeText(this, "El limite maximo de paneles es 5!", Toast.LENGTH_SHORT).show()
            }
        }

    }


    fun regresarAtras(view: View){


        val intent= Intent(this, pantallaCrearEditarComic::class.java).apply{}
        startActivity(intent);

    }
    fun verPersonajes(view:View){


        val intent= Intent(this, personajes::class.java).apply{}
        startActivity(intent);
    }

    fun verFondos(panelId: Int){
        val intent= Intent(this, lista_fondo::class.java).apply{}
        intent.putExtra("panel_seleccionado_id", panelId)
        startActivity(intent);
    }
   /* fun verFondos(view:View){




        val intent= Intent(this, lista_fondo::class.java).apply{}
        intent.putExtra("panel_seleccionado_id", panelId)
        startActivity(intent);
    }*/


    fun verBurbujas(view:View){


        val intent= Intent(this, lista_burbujas::class.java).apply{}
        startActivity(intent);
    }

fun guardarComic(view:View){


    val intent = Intent(this, guardarComic::class.java).apply{}
    startActivity(intent);
}

    override fun onFondoSeleccionado(panelId: Int, fondoElegido: fondo) {

        for (panel in lista_panel) {
            if (panel.id == panelId) {
                panel.imageFondo = fondoElegido.imagenFondo

                break
            }
        }


    }


}
