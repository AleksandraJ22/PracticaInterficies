package com.example.comicfun

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import com.example.comicfun.R



class AdapterFondo1(private val imagesList : ArrayList<fondo>) : RecyclerView.Adapter<AdapterFondo1.FondoViewHolder>() {

    //lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FondoViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.fila_fondo, parent, false)

        return FondoViewHolder(view)

    }
    override fun onBindViewHolder(holder: FondoViewHolder, position: Int) {


        val imagen = imagesList[position]

        holder.fondoImageView.setImageResource(imagen.imagenFondo)


    }
    override fun getItemCount(): Int {
        //  return 10

        return imagesList.size

    }



    class FondoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val fondoImageView : ImageView = itemView.findViewById(R.id.ImageView)

    }

}