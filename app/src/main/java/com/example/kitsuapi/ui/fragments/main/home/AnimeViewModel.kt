package com.example.kitsuapi.ui.fragments.main.home

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.kitsuapi.base.BaseViewModel
import com.example.kitsuapi.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : BaseViewModel() {

    fun fetchAnime() = animeRepository.fetchAnime().cachedIn(viewModelScope)
}