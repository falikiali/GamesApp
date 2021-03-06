package com.example.gamesapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.gamesapp.databinding.FragmentHomeBinding
import com.example.gamesapp.domain.model.DataGame
import com.example.gamesapp.utils.ResultState
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.ImageListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            observeViewModel()
        }
    }

    private fun observeViewModel() {
        with(homeViewModel) {
            resultGames.observe(viewLifecycleOwner, {
                createCarousel(it, 5)
            })

            error.observe(viewLifecycleOwner, {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun createCarousel(games: List<DataGame>, size: Int) {
        val imageListener = ImageListener { position, imageView -> Picasso.get().load(games[position].background_image).into(imageView) }
        binding.carouselView.apply {
            setImageListener(
                imageListener
            )
            pageCount = size

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}