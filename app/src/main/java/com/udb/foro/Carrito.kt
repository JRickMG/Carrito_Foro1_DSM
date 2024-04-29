package com.udb.foro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.udb.foro.databinding.FragmentCarritoBinding

class Carrito : Fragment() {

    private var _binding: FragmentCarritoBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ProductoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarritoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ProductoViewModel::class.java)

        binding.rvListaCarro.apply {
            adapter = AdaptadorCarroCompras()
            layoutManager = LinearLayoutManager(context) // Asegúrate de tener un LayoutManager
        }

        viewModel.carroCompras.observe(viewLifecycleOwner) { carro ->
            (binding.rvListaCarro.adapter as AdaptadorCarroCompras).updateData(carro)
            updateTotal()
        }
    }


    private fun updateTotal() {
        val total = viewModel.carroCompras.value?.sumByDouble { it.precio } ?: 0.0
        binding.tvTotal.text = String.format("$%.2f", total)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
