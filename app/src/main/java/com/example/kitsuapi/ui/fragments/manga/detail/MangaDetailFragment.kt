package com.example.kitsuapi.ui.fragments.manga.detail

import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.utils.Resource
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.databinding.FragmentMangaDetailBinding
import com.example.kitsuapi.extension.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment: BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>
    (R.layout.fragment_manga_detail) {

    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    override val viewModel: MangaDetailViewModel by viewModels()
    private val args: MangaDetailFragmentArgs by navArgs()

    override fun setupObserves() {
        viewModel.fetchDetailManga(args.id).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error<*> -> {
                    binding.progressBar.isInvisible = true
                    Toast.makeText(requireContext(), "anime", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading<*> -> {
                    binding.progressBar.isInvisible = false
                }
                is Resource.Success<*> -> {
                    it.data.let { manga ->
                        binding.progressBar.isInvisible = true
                        binding.mangaDetailName.text = manga!!.data.attributes.titles.enJp
                        binding.mangaDetailImage.setImage(manga.data.attributes.posterImage.original)
                        Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}