package com.udb.foro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.udb.foro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavegacion()

        }

    private fun setupNavegacion(){
        val NavBarBottom = binding.NavBarBottom
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)as NavHostFragment
        NavigationUI.setupWithNavController(
            NavBarBottom,
            navHostFragment.navController
        )
    }
}