package com.example.comicfun.Adapter


import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import com.example.comicfun.R
import com.example.comicfun.data.Elemento


class AdapterBurbujas(private val imagesList : ArrayList<Elemento>) : RecyclerView.Adapter<AdapterBurbujas.BurbujaViewHolder>() {

    //lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BurbujaViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.fila_burbujas, parent, false)

        return BurbujaViewHolder(view)

    }
    override fun onBindViewHolder(holder: BurbujaViewHolder, position: Int) {


        val imagen = imagesList[position]

       // holder.fondoImageView.setImageResource(imagen.imagenElemento)
        imagen.imagenElemento?.let { holder.fondoImageView.setImageResource(it) }

    }
    override fun getItemCount(): Int {

        return imagesList.size

    }



    class BurbujaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val fondoImageView : ImageView = itemView.findViewById(R.id.ImageViewBurbuja)

    }

}