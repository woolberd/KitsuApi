package com.example.kitsuapi.ui.fragments.anime.detail

import androidx.lifecycle.ViewModel
import com.example.kitsuapi.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel() {

    fun fetchDetailAnime(id: String) = animeRepository.fetchDetailAnime(id)
}