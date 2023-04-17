package com.example.kitsuapi.ui.fragments.anime

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.databinding.FragmentAnimeBinding
import com.example.kitsuapi.ui.adapter.AnimeAdapter
import com.example.kitsuapi.ui.fragments.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::onItemClick)

    override fun initialize() {
        binding.animeRecView.apply {
            adapter = animeAdapter
        }
    }

    override fun setupSubscribes() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                animeAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToAnimeDetailFragment(id)
        )
    }
}