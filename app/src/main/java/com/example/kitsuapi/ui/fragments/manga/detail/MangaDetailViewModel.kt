package com.example.kitsuapi.ui.fragments.manga.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kitsuapi.Resource
import com.example.kitsuapi.data.repositories.MangaRepository
import com.example.kitsuapi.model.DataItem
import com.example.kitsuapi.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(
    private val mangaRepository: MangaRepository
)  : ViewModel() {

    fun fetchDetailManga(id: String): LiveData<Resource<Response<DataItem>>> {
        return mangaRepository.fetchDetailManga(id)
    }
}