package com.example.comicfun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comicfun.Adapter.AdapterPersonajes
import com.example.comicfun.data.Elemento


class personajes : AppCompatActivity() {

    val db = DBHandler(this)


    private lateinit var recyclerView: RecyclerView

    private  lateinit var personajesAdapter: AdapterPersonajes
    private lateinit var personajes: ArrayList<Elemento>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_personajes1)
    //   val personaje1 = Elemento(null,null,R.drawable.personaje1, "personaje");
        val personaje1 = Elemento(idElemento = null, idPanel = null, imagenElemento = R.drawable.personaje1, tipoElemento = "personaje")

         val personaje2 = Elemento(null,null,R.drawable.personaje2, "personaje");
         val personaje3 = Elemento(null,null,R.drawable.perssonaje3, "personaje");
         val personaje4 = Elemento(null,null,R.drawable.personaje4, "personaje");
        db.insertDataTablaPersonajes(personaje1);
       db.insertDataTablaPersonajes(personaje2);
        db.insertDataTablaPersonajes(personaje3);
        db.insertDataTablaPersonajes(personaje4);

        init()
      /*  val nuevoElemento = Elemento(
            1,
            1,
            R.drawable.personaje1,
            "personaje"
        )
        val db = DBHandler(this)
        db.insertDataTablaPersonajes(nuevoElemento)
*/



    }
    private fun init(){

        recyclerView = findViewById(R.id.Recycler_View)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        personajes = ArrayList()


        addDataToList()

        personajesAdapter= AdapterPersonajes(personajes)
        recyclerView.adapter = personajesAdapter
    }

    private fun addDataToList(){


        personajes.add(Elemento(1,null,R.drawable.personaje1, "personaje"))
        personajes.add(Elemento(2,null,R.drawable.personaje2,"personaje"))
        personajes.add(Elemento(3,null,R.drawable.perssonaje3,"personaje"))
        personajes.add(Elemento(4,null,R.drawable.personaje4,"personaje"))

    }

    fun OkPersonaje(view:View){



        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);


    }


    fun volverSinSeleccionarNada(view:View){

        val intent= Intent(this, CrearComic::class.java).apply{}
        startActivity(intent);


    }

}
