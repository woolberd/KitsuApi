package com.example.kitsuapi.ui.fragments.anime

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.Resource
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.databinding.FragmentAnimeBinding
import com.example.kitsuapi.ui.adapter.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::onItemClick)

    override fun initialize() {
        binding.animeRecView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun setupObserves() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error<*> -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading<*> -> {
                }
                is Resource.Success<*> -> {
                    it.data?.let { data ->
                        animeAdapter.submitList(data.data)
                    }
                }
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            AnimeFragmentDirections.actionAnimeFragmentToAnimeDetailFragment(id)
        )
    }
}