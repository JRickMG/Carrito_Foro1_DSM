package com.udb.foro

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.udb.foro.databinding.FragmentHomeBinding

class home : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter : AdaptadorProducto



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root // Aquí retornamos la vista vinculada
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun setupRecyclerView(){
        var context = this.requireContext()
        binding.rvListaProductos.layoutManager = LinearLayoutManager(context)
        adapter = AdaptadorProducto(context, binding.tvCantProductos)
        binding.rvListaProductos.adapter = adapter
    }


}
