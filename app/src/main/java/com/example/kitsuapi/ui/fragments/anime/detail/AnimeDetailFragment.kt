package com.example.kitsuapi.ui.fragments.anime.detail

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.Resource
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.databinding.FragmentAnimeDetailBinding
import com.example.kitsuapi.extension.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment: BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>
    (R.layout.fragment_anime_detail) {


    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    override val viewModel: AnimeDetailViewModel by viewModels()
    private val args by navArgs<AnimeDetailFragmentArgs>()

    override fun setupObserves() {

        viewModel.fetchDetailAnime(args.id).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error<*> -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading<*> -> {
                }
                is Resource.Success<*> -> {
                    binding.animeDetailName.text = it.message
                    binding.animeDetailImage.setImage(it.message.toString())
                }
            }
        }
    }
}