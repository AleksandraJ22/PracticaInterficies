package com.example.comicfun.Adapter




import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.comicfun.R
import com.example.comicfun.data.comic


class AdapterSeleccionarComic(private val listaComics : ArrayList<comic>) : RecyclerView.Adapter<AdapterSeleccionarComic.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.fila_seleccionar_comic, parent, false)

        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val unComic = listaComics[position]

        holder.encontrarComic.text = unComic.nombre


    }
    override fun getItemCount(): Int {
        //  return 10

        return listaComics.size

    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val encontrarComic: TextView = itemView.findViewById(R.id.comic1)


        init {
            itemView.setOnClickListener{


                v: View -> val nombre: Int = adapterPosition
                Toast.makeText(itemView.context, "You clicked on item # $nombre",
                Toast.LENGTH_SHORT).show();
            }
        }

    }

}