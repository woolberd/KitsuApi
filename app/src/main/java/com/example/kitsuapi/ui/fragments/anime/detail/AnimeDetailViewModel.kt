package com.example.kitsuapi.ui.fragments.anime.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kitsuapi.Resource
import com.example.kitsuapi.data.repositories.AnimeRepository
import com.example.kitsuapi.model.DataItem
import com.example.kitsuapi.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
)  : ViewModel() {

    fun fetchDetailAnime(id: String): LiveData<Resource<Response<DataItem>>> {
        return animeRepository.fetchDetailAnime(id)
    }
}