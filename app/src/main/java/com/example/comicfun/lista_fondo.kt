package com.example.comicfun

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comicfun.Adapter.AdapterFondo
import com.example.comicfun.Adapter.AdapterFondo1
import com.example.comicfun.data.Elemento
import com.example.comicfun.data.panelComic


class lista_fondo : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView

    private  lateinit var fondo1Adapter: AdapterFondo
private lateinit var fondo1List: ArrayList<Elemento>

    private lateinit var fondo2List: ArrayList<Elemento>
    private lateinit var fondo3List: ArrayList<Elemento>
private lateinit var btn_OK_fondo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_fondo1)


        btn_OK_fondo = findViewById(R.id.buttonOK)

        init()
        init2()
        init3()
      btn_OK_fondo = findViewById(R.id.buttonOK)



    }




    private fun init(){

        recyclerView = findViewById(R.id.recycleView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        fondo1List = ArrayList()


        addDataToList()

        fondo1Adapter= AdapterFondo(fondo1List)

        recyclerView.adapter = fondo1Adapter



    }

    private fun init2(){

        recyclerView=findViewById(R.id.recycleView2)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        fondo2List = ArrayList()

        addDataToList2()

        fondo1Adapter= AdapterFondo(fondo2List)
        recyclerView.adapter = fondo1Adapter
    }


    private fun init3(){

        recyclerView=findViewById(R.id.recycleView3)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        fondo3List = ArrayList()

        addDataToList3()
        fondo1Adapter= AdapterFondo(fondo3List)

        recyclerView.adapter = fondo1Adapter
    }

    private fun addDataToList3(){


        fondo3List.add(Elemento(1,null,R.drawable.clima_lluvia2, "fondo de panel"))
        fondo3List.add(Elemento(2,null,R.drawable.balcon, "fondo de panel"))
        fondo3List.add(Elemento(3,null,R.drawable.tornado, "fondo de panel"))
        fondo3List.add(Elemento(4,null ,R.drawable.clima_lluvia, "fondo de panel"))

    }
    private fun addDataToList2(){


        fondo2List.add(Elemento(1,null,R.drawable.carretera, "fondo de panel"))
        fondo2List.add(Elemento(2,null,R.drawable.bosque, "fondo de panel"))
        fondo2List.add(Elemento(3,null,R.drawable.disco, "fondo de panel "))
        fondo2List.add(Elemento(4,null,R.drawable.baile, "fondo de panel"))

    }
    private fun addDataToList(){
        //los fondos de color solido y de patron

        fondo1List.add(Elemento(1,null,R.drawable.patron, "fondo de panel"))
        fondo1List.add(Elemento(2,null,R.drawable.patron2, "fondo de panel"))
        fondo1List.add(Elemento(3,null, R.drawable.color_azul, "fondo de panel"))

    }

    /*
 fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val rootView : View = inflater.inflate(R.layout.lista_fondo1, container, false)

        return rootView
    }






*/
  /* fun OkFondo(view: View) {

        val panelSeleccionadoId = obtenerIdPanel()
        if (panelSeleccionadoId != -1) {
            fondoElegido?.let { fondo ->
                fondoSeleccionadoListener?.onFondoSeleccionado(panelSeleccionadoId, fondo)
            } ?: run {
                Toast.makeText(this, "Por favor, selecciona un fondo", Toast.LENGTH_SHORT).show()
            }
        } else {
            // Manejo cuando no se selecciona ningún panel
            Toast.makeText(this, "Para elegir un fondo, primero selecciona un panel", Toast.LENGTH_SHORT).show()
        }


      /*  fondoElegido?.let { fondo ->
            val panelSeleccionadoId = intent.getIntExtra("panel_seleccionado_id", -1)
            fondoSeleccionadoListener?.onFondoSeleccionado(panelSeleccionadoId, fondo)
        }*/


    }

*/

    fun volverSinSeleccionarFondo(view: View){


            val intent= Intent(this, CrearComic::class.java).apply{}
            startActivity(intent);

    }



}