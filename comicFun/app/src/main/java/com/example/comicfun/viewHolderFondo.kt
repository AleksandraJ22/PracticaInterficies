package com.example.comicfun

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.example.comicfun.R


class viewHolderFondo : RecyclerView.Adapter<viewHolderFondo.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_fondo_recycler_view, parent, false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return 10

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //var idImagen : String = ""
       // var image_view : ImageView = itemView.findViewById(R.id.)



    }

}
