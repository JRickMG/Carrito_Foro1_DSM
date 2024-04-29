package com.udb.foro
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ProductoViewModel : ViewModel() {
    private val _listaProductos = MutableLiveData<ArrayList<Producto>>()
    val listaProductos: LiveData<ArrayList<Producto>> = _listaProductos

    private val _carroCompras = MutableLiveData<ArrayList<Producto>>()
    val carroCompras: LiveData<ArrayList<Producto>> = _carroCompras

    init {
        cargarProductos()
    }

    private fun cargarProductos() {
        val productosCargados = ArrayList<Producto>()
        // Simulación de productos cargados
        productosCargados.add(Producto("1", "Apple MacBook Air M1", "Chip M1 de Apple, 8 GB RAM, 256 GB SSD, 13.3 pulgadas", 999.00))
        productosCargados.add(Producto("2", "Dell XPS 13", "Intel Core i7, 16 GB RAM, 512 GB SSD, 13.4 pulgadas, FHD+", 1200.00))
        productosCargados.add(Producto("3", "Lenovo ThinkPad X1 Carbon", "Intel Core i7, 16 GB RAM, 1 TB SSD, 14 pulgadas, UHD+", 1400.99))
        productosCargados.add(Producto("4", "HP Spectre x360", "Intel Core i7, 16 GB RAM, 1 TB SSD, 13.5 pulgadas, OLED Touch", 1600.00))
        productosCargados.add(Producto("5", "ASUS ROG Zephyrus G14", "AMD Ryzen 9, 32 GB RAM, 1 TB SSD, 14 pulgadas, QHD, NVIDIA RTX 3060", 1450.00))
        productosCargados.add(Producto("6", "Microsoft Surface Laptop 4", "AMD Ryzen 5, 8 GB RAM, 256 GB SSD, 13.5 pulgadas, Touch Screen", 999.99))


        _listaProductos.value = productosCargados
    }



    fun agregarAlCarro(producto: Producto) {
        val listaActual = _carroCompras.value ?: ArrayList()
        listaActual.add(producto)
        _carroCompras.value = listaActual
    }

    fun quitarDelCarro(producto: Producto) {
        val listaActual = _carroCompras.value ?: ArrayList()
        listaActual.remove(producto)
        _carroCompras.value = listaActual
    }
}
