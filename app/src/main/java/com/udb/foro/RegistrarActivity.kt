package com.udb.foro

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.udb.foro.databinding.ActivityRegistrarBinding

class RegistrarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarBinding
    private lateinit var daoUsuario: daoUsuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        daoUsuario = daoUsuario(this)
        binding.button2.setOnClickListener {
            registrarUsuario()
        }
    }

    private fun registrarUsuario() {
        val usuario = binding.editTextText.text.toString().trim()
        val password = binding.editTextTextPassword.text.toString().trim()
        val confirmPassword = binding.editTextTextPassword2.text.toString().trim()

        if (usuario.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return
        }

        // Intentar registrar el usuario
        val newUser = Usuario(usuario, "", usuario, password) // Ajusta según los parámetros de tu constructor Usuario
        if (daoUsuario.insertUsuario(newUser)) {
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()  // Finaliza esta actividad para que el usuario no pueda regresar con el botón atrás
        } else {
            Toast.makeText(this, "El usuario ya existe o no se pudo registrar", Toast.LENGTH_LONG).show()
        }
    }

}
