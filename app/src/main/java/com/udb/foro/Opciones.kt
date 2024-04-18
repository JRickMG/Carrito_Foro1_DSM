package com.udb.foro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udb.foro.databinding.FragmentOpcionesBinding

class Opciones : Fragment(R.layout.fragment_opciones) {

    private lateinit var binding: FragmentOpcionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentOpcionesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.Opcionestexto.text = "Fragmento Texto"
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_opciones, container, false)
    }
}