package com.example.gamesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gamesapp.FavoriteFragment
import com.example.gamesapp.R
import com.example.gamesapp.SearchFragment
import com.example.gamesapp.databinding.ActivityMainBinding
import com.example.gamesapp.ui.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideTopBar()
        initFragmentContainer()
        menuAction()
    }

    private fun hideTopBar() {
        supportActionBar?.hide()
    }

    private fun initFragmentContainer() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, HomeFragment())
            .commit()
    }

    private fun menuAction() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, HomeFragment())
                        .commit()

                    true
                }
                R.id.searchFragment -> {
                    supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, SearchFragment())
                        .commit()

                    true
                }
                R.id.favoriteFragment -> {
                    supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, FavoriteFragment())
                        .commit()

                    true
                }
                else -> true
            }
        }
    }
}