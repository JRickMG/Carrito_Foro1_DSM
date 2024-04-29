package com.udb.foro

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class AdaptadorProducto(
    var context: Context,
    var tvCantProductos:TextView,
): RecyclerView.Adapter<AdaptadorProducto.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvNomProducto = itemView.findViewById(R.id.tvNomProducto) as TextView
        val tvDescripcion = itemView.findViewById(R.id.tvDescripcion) as TextView
        val cbCarro = itemView.findViewById(R.id.cbCarro) as CheckBox
        val tvPrecio = itemView.findViewById(R.id.tvPrecio) as TextView

    }

    private val viewModel: ProductoViewModel = ViewModelProvider(context as AppCompatActivity).get(ProductoViewModel::class.java)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_productos, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = viewModel.listaProductos.value?.get(position) ?: return

        holder.tvNomProducto.text = producto.nomProducto
        holder.tvDescripcion.text = producto.descripcion
        holder.tvPrecio.text = "$${producto.precio}"

        holder.cbCarro.setOnCheckedChangeListener(null)
        holder.cbCarro.isChecked = viewModel.carroCompras.value?.contains(producto) ?: false
        holder.cbCarro.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.agregarAlCarro(producto)
            } else {
                viewModel.quitarDelCarro(producto)
            }
            tvCantProductos.text = "${viewModel.carroCompras.value?.size ?: 0}"
        }
    }

    override fun getItemCount(): Int {
        return viewModel.listaProductos.value?.size ?: 0
    }


}