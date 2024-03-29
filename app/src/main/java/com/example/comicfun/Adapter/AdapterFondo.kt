package com.example.comicfun.Adapter


import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.comicfun.R
import com.example.comicfun.data.Elemento
//import com.example.comicfun.data.fondo


class AdapterFondo(private val imagesList : ArrayList<Elemento>) : RecyclerView.Adapter<AdapterFondo.ViewHolder>() {


    interface OnFondoClickListener{

        fun onImageClick()
        fun onItemClick()
    }

    //lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.fila_fondo, parent, false)

        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val imagen = imagesList[position]

     //   holder.fondoImageView.setImageResource(imagen.imagenElemento)
        imagen.imagenElemento?.let { holder.fondoImageView.setImageResource(it) }
holder.fondoImageView.setOnClickListener{

    Toast.makeText(holder.itemView.context, "Has seleccionado imagen", Toast.LENGTH_SHORT).show()

}

    }
    override fun getItemCount(): Int {

        return imagesList.size

    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val fondoImageView : ImageView = itemView.findViewById(R.id.ImageView)

    }

}