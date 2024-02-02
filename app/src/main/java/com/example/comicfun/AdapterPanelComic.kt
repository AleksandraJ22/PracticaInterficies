package com.example.comicfun



import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import com.example.comicfun.R




    class AdapterPanelComic(private val objetosPanel: ArrayList<panelComic>) : RecyclerView.Adapter<AdapterPanelComic.PanelViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PanelViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.fila_fondo, parent, false)
            return PanelViewHolder(view)
        }

        override fun onBindViewHolder(holder: PanelViewHolder, position: Int) {
            val panel = objetosPanel[position]

            holder.PanelImageView.setImageResource(panel.imageFondo)
        }

        override fun getItemCount(): Int {
            return objetosPanel.size
        }

        class PanelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val PanelImageView: ImageView = itemView.findViewById(R.id.ImageView)
        }
    }
}