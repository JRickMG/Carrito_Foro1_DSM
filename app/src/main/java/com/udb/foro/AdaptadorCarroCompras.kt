package com.udb.foro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCarroCompras(

): RecyclerView.Adapter<AdaptadorCarroCompras.ViewHolder>() {


    private var carroCompras = ArrayList<Producto>()

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvNomProducto: TextView = itemView.findViewById(R.id.tvNomProducto)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcion)
        val tvPrecio: TextView = itemView.findViewById(R.id.tvPrecio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_carro_compras, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = carroCompras[position]
        holder.tvNomProducto.text = producto.nomProducto
        holder.tvDescripcion.text = producto.descripcion
        holder.tvPrecio.text = String.format("$%.2f", producto.precio)
    }

    override fun getItemCount(): Int {
        return carroCompras.size
    }

    fun updateData(newCarroCompras: ArrayList<Producto>) {
        carroCompras = newCarroCompras
        notifyDataSetChanged() // Notifica al RecyclerView que los datos han cambiado
    }

}