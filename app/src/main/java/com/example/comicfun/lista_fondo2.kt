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


class lista_fondo2 : AppCompatActivity() {
    interface FondoSeleccionadoListener {
        fun onFondoSeleccionado(panelSeleccionadoId: Int, fondoElegido: Elemento)
    }

    private var fondoSeleccionadoListener: FondoSeleccionadoListener? = null

    fun setFondoSeleccionadoListener(listener: FondoSeleccionadoListener) {
        fondoSeleccionadoListener = listener
    }
    private lateinit var recyclerView: RecyclerView

    private  lateinit var fondo1Adapter: AdapterFondo
    private lateinit var fondo1List: ArrayList<Elemento>

    private lateinit var fondo2List: ArrayList<Elemento>
    private lateinit var fondo3List: ArrayList<Elemento>
    private lateinit var btn_OK_fondo: Button


    private var fondoElegido: Elemento?=null
    //  private lateinit var panelComicList: ArrayList<panelComic>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_fondo1)

        ///val panelSeleccionadoId = intent.getIntExtra("panel_seleccionado_id", -1)
        /* if(panelSeleccionadoId != -1){

             Toast.makeText(this, "El panel seleccionado es ${panelSeleccionadoId}",Toast.LENGTH_SHORT).show()
         }
 */
        // val fondoSeleccionadoId = intent.getIntExtra("fondo_seleccionado_id", -1)
        btn_OK_fondo = findViewById(R.id.buttonOK)

        init()
        init2()
        init3()
        btn_OK_fondo = findViewById(R.id.buttonOK)
        /*  btn_OK_fondo.setOnClickListener {
              OkFondo(it)
          }*/
        /* recyclerView = findViewById(R.id.recycleView)
         adapter = AdapterFondo1()

         recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

         recyclerView.adapter=adapter
 */


    }

    /*fun obtenerIdPanel(): Int{
        val panelSeleccionadoId = intent.getIntExtra("panel_seleccionado_id", -1)


        return panelSeleccionadoId
    }*/
    /* fun onItemClick(item: fondo?) {
          item?.let { item ->
              // Hacer lo que necesites con el elemento seleccionado
              Toast.makeText(this, "Elemento seleccionado: ${item.idFondo}", Toast.LENGTH_SHORT).show()

          }
      }*/
    private fun init(){

        recyclerView = findViewById(R.id.recycleView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        fondo1List = ArrayList()


        addDataToList()

        fondo1Adapter= AdapterFondo(fondo1List)
        /*  fondo1Adapter.setOnItemClickListener { imageView ->
               fondoElegido = imageView.tag as fondo
           }*/
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


        fondo3List.add(Elemento(1,null,R.drawable.clima_lluvia2, "fondo"))
        fondo3List.add(Elemento(2,null,R.drawable.balcon, "fondo"))
        fondo3List.add(Elemento(3,null,R.drawable.tornado,"fondo"))
        fondo3List.add(Elemento(4,null ,R.drawable.clima_lluvia,"fondo"))

    }
    private fun addDataToList2(){


        fondo2List.add(Elemento(1,null,R.drawable.carretera,"fondo"))
        fondo2List.add(Elemento(2,null,R.drawable.bosque,"fondo"))
        fondo2List.add(Elemento(3,null,R.drawable.disco,"fondo"))
        fondo2List.add(Elemento(4,null,R.drawable.baile,"fondo"))

    }
    private fun addDataToList(){
        //los fondos de color solido y de patron

        fondo1List.add(Elemento(1,null,R.drawable.patron,"fondo"))
        fondo1List.add(Elemento(2,null,R.drawable.patron2,"fondo"))
        fondo1List.add(Elemento(3,null, R.drawable.color_azul,"fondo"))

    }

    /*
 fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val rootView : View = inflater.inflate(R.layout.lista_fondo1, container, false)

        return rootView
    }



  fun onViewCreated(view: View, savedInstanceState: Bundle?){

//super.onViewCreated(view, savedInstanceState)
     val layoutManager = LinearLayoutManager(context)
     recyclerView = view.findViewById(R.id.recycleView)
     recyclerView.layoutManager =layoutManager //variable k hemos creado
     recyclerView.setHasFixedSize(true)

     adapterFondo =ViewHolderFondo(getImagesList())
     recyclerView.adapter=adapterFondo

}
    fun getImagesList(): ArrayList<fondo>{


        var imagesList: ArrayList<fondo> = ArrayList()

        imagesList.add(fondo(1,R.drawable.patron))
        imagesList.add(fondo(2,R.drawable.patron2))
        imagesList.add(fondo(3,R.drawable.color_azul))



return imagesList



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
    /* fun onOkButtonClick() {

         val idFondoSeleccionado = obtenerIdFondoSeleccionado()


         val resultIntent = Intent()
         resultIntent.putExtra("idFondo", idFondoSeleccionado)


         setResult(RESULT_OK, resultIntent)
         finish()
     }



*/


}