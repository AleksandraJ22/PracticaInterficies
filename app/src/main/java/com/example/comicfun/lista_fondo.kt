package com.example.comicfun

import android.content.Intent
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comicfun.AdapterFondo1

class lista_fondo : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView

    private  lateinit var fondo1Adapter: AdapterFondo1
private lateinit var fondo1List: ArrayList<fondo>

/**/
  // private lateinit var recyclerView2: RecyclerView
//private lateinit var fondo2Adapter: AdapterFondo2
    private lateinit var fondo2List: ArrayList<fondo>



    //private lateinit var recyclerView3: RecyclerView
   // private lateinit var fondo3Adapter: AdapterFondo3
    private lateinit var fondo3List: ArrayList<fondo>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_fondo1)

        init()
        init2()
        init3()

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


        fondo3List.add(fondo(R.drawable.clima_lluvia2))
        fondo3List.add(fondo(R.drawable.balcon))
        fondo3List.add(fondo(R.drawable.tornado))
        fondo3List.add(fondo(R.drawable.clima_lluvia))

    }
    private fun addDataToList2(){


        fondo2List.add(fondo(R.drawable.carretera))
        fondo2List.add(fondo(R.drawable.bosque))
        fondo2List.add(fondo(R.drawable.disco))
        fondo2List.add(fondo(R.drawable.baile))

    }
    private fun addDataToList(){
        //los fondos de color solido y de patron

        fondo1List.add(fondo(R.drawable.patron))
        fondo1List.add(fondo(R.drawable.patron2))
        fondo1List.add(fondo(R.drawable.color_azul))




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

    fun OkFondo(view: View){



        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);


    }


    fun volverSinSeleccionarFondo(view: View){

        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);


    }

}