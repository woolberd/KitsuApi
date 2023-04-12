package com.example.kitsuapi.ui.fragments.manga.detail

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.Resource
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.databinding.FragmentMangaDetailBinding
import com.example.kitsuapi.extension.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment(
) : BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(R.layout.fragment_manga_detail) {

    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    override val viewModel: MangaDetailViewModel by viewModels()
    private val args by navArgs<MangaDetailFragmentArgs>()

    override fun setupObserves() {

        viewModel.fetchDetailManga(args.id).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error<*> -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading<*> -> {
                }
                is Resource.Success<*> -> {
                    binding.mangaDetailName.text = it.message
                    binding.mangaDetailImage.setImage(it.message.toString())
                }
            }
        }
    }
}