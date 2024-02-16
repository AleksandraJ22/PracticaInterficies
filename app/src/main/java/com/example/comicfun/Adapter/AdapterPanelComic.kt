package com.example.comicfun.Adapter

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import com.example.comicfun.R
import com.example.comicfun.data.panelComic


class AdapterPanelComic(private val objetosPanel: ArrayList<panelComic>) : RecyclerView.Adapter<AdapterPanelComic.PanelViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PanelViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.panel_comic, parent, false)
            return PanelViewHolder(view)
        }

        override fun onBindViewHolder(holder: PanelViewHolder, position: Int) {
            val panel = objetosPanel[position]

          /*  if (panel.imageFondo != null) {
                holder.imageViewFondo.setImageResource(panel.imageFondo)
            }
*/


          /*  if (panel.personaje != null)
            {
                holder.imageViewPersonaje.setImageResource(panel.personaje)
            }*/

          /*  if (panel.textoBurbuja != null) {
                holder.textViewBurbuja.text = panel.textoBurbuja

                holder.textViewBurbuja.setOnClickListener {

                }
            }*/

          if (panel.burbuja != null) {
                holder.imageViewBurbuja.setImageResource(panel.burbuja!!)
                holder.imageViewBurbuja.visibility = View.VISIBLE
            } else {
                holder.imageViewBurbuja.visibility = View.GONE
            }


            if (panel.personaje != null) {
                holder.imageViewPersonaje.setImageResource(panel.personaje!!)
                holder.imageViewPersonaje.visibility = View.VISIBLE
            } else {
                holder.imageViewPersonaje.visibility = View.GONE
            }
            if (panel.imageFondo != null) {
                holder.imageViewFondo.setImageResource(panel.imageFondo!!)
                holder.imageViewFondo.visibility = View.VISIBLE
            } else {
                holder.imageViewPersonaje.visibility = View.GONE
            }


        }

        override fun getItemCount(): Int {
            return objetosPanel.size
        }

        class PanelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageViewFondo: ImageView = itemView.findViewById(R.id.imageViewFondo)
            val imageViewBurbuja: ImageView = itemView.findViewById(R.id.imageViewBurbuja)
          //  val textViewBurbuja: TextView = itemView.findViewById(R.id.textViewBurbuja)
            val imageViewPersonaje: ImageView = itemView.findViewById(R.id.imageViewPersonaje)

       // val textNombreComic: TextView = itemView.findViewById(R.id.comic1)
        }
    }

