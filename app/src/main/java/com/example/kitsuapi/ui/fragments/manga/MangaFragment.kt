package com.example.kitsuapi.ui.fragments.manga

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.Resource
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.databinding.FragmentMangaBinding
import com.example.kitsuapi.ui.adapter.MangaAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter(this::onItemClick)

    override fun initialize() {
        binding.mangaRecView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = mangaAdapter
        }
    }

    override fun setupObserves() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error<*> -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading<*> -> {
                }
                is Resource.Success<*> -> {
                    it.data?.let { data ->
                        mangaAdapter.submitList(data.data)
                    }
                }
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            MangaFragmentDirections.actionMangaFragmentToMangaDetailFragment(id)
        )
    }
}