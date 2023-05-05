package com.example.kitsuapi.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.databinding.FragmentAnimeDetailBinding
import com.example.kitsuapi.extension.setImage
import com.example.kitsuapi.ui.adapter.episode.EpisodeDataAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>
    (R.layout.fragment_anime_detail) {

    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    override val viewModel: AnimeDetailViewModel by viewModels()
    private val args: AnimeDetailFragmentArgs by navArgs()
    private val episodeDataAdapter = EpisodeDataAdapter()

    override fun initialize() {
//        binding.animeEpisodeRecycler.apply {
//            adapter = episodeDataAdapter
//        }
    }

    override fun setupSubscribes() {
        subscribeToFetchDetailAnime()
        subscribeToFetchEpisodes()
    }

    private fun subscribeToFetchDetailAnime() {

        viewModel.fetchDetailAnime(args.id).subscribe(
            onError = {},
            onSuccess = { it ->
                it.data.let {
                    binding.animeName.text = it.attributes.titles.enJp
                    binding.animeImageView.setImage(it.attributes.posterImage.original)
                    binding.backgroundImg.setImage(it.attributes.posterImage.large)
                }
            }
        )
//        viewModel.fetchDetailAnime(args.id).observe(viewLifecycleOwner) {
//            when (it) {
//                is Resource.Error -> {
//                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
//                }
//                is Resource.Loading -> {}
//                is Resource.Success -> {
//                    it.data.let { anime ->
//                        binding.animeName.text = anime!!.data.attributes.titles.enJp
//                        binding.animeImageView.setImage(anime.data.attributes.posterImage.original)
//                        binding.backgroundImg.setImage(anime.data.attributes.posterImage.large)
//                        Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        }
    }

    private fun subscribeToFetchEpisodes() {
        viewModel.fetchEpisode().observe(viewLifecycleOwner) {
            episodeDataAdapter.submitList(it.data)
        }
    }
}