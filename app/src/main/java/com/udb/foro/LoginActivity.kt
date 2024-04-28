package com.udb.foro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.udb.foro.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var daoUsuario: daoUsuario // Añade esta línea

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        daoUsuario = daoUsuario(this) // Inicializa daoUsuario

        // Establecer el listener del botón de inicio de sesión
        binding.button.setOnClickListener {
            iniciarSesion()
        }

        // Establecer el listener del texto para registrarse
        binding.textView5.setOnClickListener {
            startActivity(Intent(this, RegistrarActivity::class.java))
        }
    }

    private fun iniciarSesion() {
        val usuario = binding.usuarioLogin.text.toString().trim()
        val password = binding.passwordLogin.text.toString().trim()
        Log.d("LoginAttempt", "Usuario: $usuario, Password: $password");

        if (daoUsuario.checkLogin(usuario, password)) { // Asegúrate de que checkLogin sea accesible y esté correctamente implementado
            // Credenciales correctas, continuar a MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            // Credenciales incorrectas, mostrar error
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show()
        }

    }
}
