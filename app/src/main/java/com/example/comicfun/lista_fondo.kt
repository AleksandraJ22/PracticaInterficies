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
import com.example.comicfun.Adapter.AdapterFondo1
import com.example.comicfun.data.fondo
import com.example.comicfun.data.panelComic

class lista_fondo : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView

    private  lateinit var fondo1Adapter: AdapterFondo1
private lateinit var fondo1List: ArrayList<fondo>

    private lateinit var fondo2List: ArrayList<fondo>
    private lateinit var fondo3List: ArrayList<fondo>
private lateinit var btn_OK_fondo: Button

//private  var fondo_elegido: ImageView?=null
    private var fondoElegidoId: Int? = null
    private lateinit var panelComicList: ArrayList<panelComic>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_fondo1)
        btn_OK_fondo = findViewById(R.id.buttonOK)

        init()
        init2()
        init3()
        btn_OK_fondo = findViewById(R.id.buttonOK)
        btn_OK_fondo.setOnClickListener {
            OkFondo(it)
        }



       /* recyclerView = findViewById(R.id.recycleView)
        adapter = AdapterFondo1()

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        recyclerView.adapter=adapter
*/


    }


    private fun init(){

        recyclerView = findViewById(R.id.recycleView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        fondo1List = ArrayList()


        addDataToList()

        fondo1Adapter= AdapterFondo1(fondo1List)
        fondo1Adapter.setOnItemClickListener { imageView ->
            fondoElegidoId = imageView.tag as Int
        }
        recyclerView.adapter = fondo1Adapter


        panelComicList = ArrayList()
        panelComicList.add(panelComic(1))
        panelComicList.add(panelComic(2))

    }




    private fun init2(){

        recyclerView=findViewById(R.id.recycleView2)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        fondo2List = ArrayList()

        addDataToList2()

        fondo1Adapter= AdapterFondo1(fondo2List)
        recyclerView.adapter = fondo1Adapter
    }


    private fun init3(){

        recyclerView=findViewById(R.id.recycleView3)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        fondo3List = ArrayList()

        addDataToList3()
        fondo1Adapter= AdapterFondo1(fondo3List)

        recyclerView.adapter = fondo1Adapter
    }

    private fun addDataToList3(){


        fondo3List.add(fondo(1,null,R.drawable.clima_lluvia2))
        fondo3List.add(fondo(2,null,R.drawable.balcon))
        fondo3List.add(fondo(3,null,R.drawable.tornado))
        fondo3List.add(fondo(4,null ,R.drawable.clima_lluvia))

    }
    private fun addDataToList2(){


        fondo2List.add(fondo(1,null,R.drawable.carretera))
        fondo2List.add(fondo(2,null,R.drawable.bosque))
        fondo2List.add(fondo(3,null,R.drawable.disco))
        fondo2List.add(fondo(4,null,R.drawable.baile))

    }
    private fun addDataToList(){
        //los fondos de color solido y de patron

        fondo1List.add(fondo(1,null,R.drawable.patron))
        fondo1List.add(fondo(2,null,R.drawable.patron2))
        fondo1List.add(fondo(3,null, R.drawable.color_azul))

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


    fun seleccionarUnFondo(){



    }

    fun OkFondo(view: View) {
        if (fondoElegidoId != null) {

            val panelIndex = obtenerIndicePanelSeleccionado()
            if (panelIndex != -1) {
                panelComicList[panelIndex] = panelComic(panelComicList[panelIndex].id, fondoElegidoId)

            }
        }
        startActivity(Intent(this, CrearComic::class.java))
    }
    private fun obtenerIndicePanelSeleccionado(): Int {
        // Aquí deberías implementar la lógica para determinar qué panel de cómic se ha seleccionado
        // por ejemplo, si el usuario hace clic en un panel específico antes de seleccionar un fondo
        // Puedes devolver el índice del panel seleccionado, o -1 si no se seleccionó ningún panel
        return -1
    }
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