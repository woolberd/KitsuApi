package com.example.kitsuapi.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.kitsuapi.base.BaseRepository
import com.example.kitsuapi.data.remote.apiiservices.AnimeApiService
import com.example.kitsuapi.data.repositories.pagingsource.AnimePagingSource
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService
) : BaseRepository(){
    fun fetchAnime() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        AnimePagingSource(animeApiService)
    }.liveData

    fun fetchDetailAnime(id: String) = doRequest {
        animeApiService.fetchDetailAnime(id)
    }
}