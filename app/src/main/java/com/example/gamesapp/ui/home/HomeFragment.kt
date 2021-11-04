package com.example.gamesapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        homeViewModel.games.observe(viewLifecycleOwner, { data ->
            when (data) {
                is ResultState.Success -> {
                    createCarousel(data.data, 5)
                }
                is ResultState.Empty -> Log.d("Empty", "Data Kosong Bosss")
                is ResultState.Error -> Log.d("Retrofit Error", data.error)
            }
        })
    }

    private fun createCarousel(games: List<DataGame>, size: Int) {
        binding.carouselView.apply {
            pageCount = size
            setImageListener(
                ImageListener { position, imageView -> Picasso.get().load(games[position].background_image).into(imageView) }
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}