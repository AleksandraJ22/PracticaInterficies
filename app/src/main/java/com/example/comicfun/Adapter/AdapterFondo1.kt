package com.example.comicfun.Adapter

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import com.example.comicfun.R
import com.example.comicfun.data.fondo


class AdapterFondo1(private val imagesList : ArrayList<fondo>) : RecyclerView.Adapter<AdapterFondo1.FondoViewHolder>() {

    //lateinit var context: Context
    private var onItemClickListener: ((ImageView) -> Unit)? = null

    fun setOnItemClickListener(listener: (ImageView) -> Unit) {
        this.onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FondoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fila_fondo, parent, false)
        return FondoViewHolder(view)
    }

    override fun onBindViewHolder(holder: FondoViewHolder, position: Int) {
        val imagen = imagesList[position]
        holder.fondoImageView.setImageResource(imagen.imagenFondo)
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(holder.fondoImageView)
        }
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    class FondoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val fondoImageView : ImageView = itemView.findViewById(R.id.ImageView)
    }
}