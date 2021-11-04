package com.example.gamesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gamesapp.R
import com.example.gamesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideTopBar()
        initNavigation()
    }

    private fun hideTopBar() {
        supportActionBar?.hide()
    }

    private fun initNavigation() {
        val navController = findNavController(R.id.fragment_container)
        binding.bottomNavigation.setupWithNavController(navController)
    }
}