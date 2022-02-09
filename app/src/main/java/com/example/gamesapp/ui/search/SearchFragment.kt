package com.example.gamesapp.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamesapp.databinding.FragmentSearchBinding
import com.example.gamesapp.utils.ResultState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private val searchViewModel: SearchViewModel by viewModels()

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val searchGameAdapter = SearchGaneAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            initRecyclerView()
            searchGame()
        }
    }

    private fun initRecyclerView() {
        binding.rvSearch.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = searchGameAdapter
        }
    }

    private fun observeViewModel(keyword: String) {
        searchViewModel.searchGames(keyword).observe(this, { data ->
            if (data is ResultState.Success) {
                searchGameAdapter.setData(data.data)
            }
        })
    }

    private fun searchGame() {
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(keyword: String?): Boolean {
                if (keyword != null) {
                    observeViewModel(keyword)
                }
                return false
            }

            override fun onQueryTextChange(keyword: String?): Boolean {
                if (keyword != null) {
                    observeViewModel(keyword)
                }
                return false
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}