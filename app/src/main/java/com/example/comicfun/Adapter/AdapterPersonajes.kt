package com.example.comicfun.Adapter


import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import com.example.comicfun.R
import com.example.comicfun.data.fondo


class AdapterPersonajes(private val imagenes_de_personaje : ArrayList<fondo>) : RecyclerView.Adapter<AdapterPersonajes.ViewHolder>() {

    //lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.personaje, parent, false)

        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val imagen = imagenes_de_personaje[position]

        holder.personajeImageView.setImageResource(imagen.imagenFondo)


    }
    override fun getItemCount(): Int {
        //  return 10

        return imagenes_de_personaje.size

    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val personajeImageView : ImageView = itemView.findViewById(R.id.ImageViewPersonaje)

    }

}