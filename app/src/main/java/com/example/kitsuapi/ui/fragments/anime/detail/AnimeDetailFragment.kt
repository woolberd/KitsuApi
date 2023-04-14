package com.example.kitsuapi.ui.fragments.anime.detail

import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.utils.Resource
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.databinding.FragmentAnimeDetailBinding
import com.example.kitsuapi.extension.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>
    (R.layout.fragment_anime_detail) {

    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    override val viewModel: AnimeDetailViewModel by viewModels()
    private val args: AnimeDetailFragmentArgs by navArgs()

    override fun setupObserves() {
        viewModel.fetchDetailAnime(args.id).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    binding.progressBar.isInvisible = true
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    binding.progressBar.isInvisible = false
                    Toast.makeText(requireContext(), "no", Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    it.data.let { anime ->
                        binding.progressBar.isInvisible = true
                        binding.animeDetailName.text = anime!!.data.attributes.titles.enJp
                        binding.animeDetailImage.setImage(anime.data.attributes.posterImage.original)
                        Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}