package com.udb.foro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udb.foro.databinding.ActivityMainBinding
import com.udb.foro.databinding.FragmentCarritoBinding


class Carrito : Fragment(R.layout.fragment_carrito) {

        private lateinit var binding: FragmentCarritoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentCarritoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.Carritotexto.text = "Fragmento Carrito"
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carrito, container, false)
    }
}
