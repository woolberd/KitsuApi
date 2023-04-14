package com.example.kitsuapi.ui.fragments.manga.detail

import androidx.lifecycle.ViewModel
import com.example.kitsuapi.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(
    private val mangaRepository: MangaRepository
) : ViewModel() {

    fun fetchDetailManga(id: String) = mangaRepository.fetchDetailManga(id)
}
