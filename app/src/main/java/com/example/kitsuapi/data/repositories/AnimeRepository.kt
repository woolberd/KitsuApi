package com.example.kitsuapi.data.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.kitsuapi.base.BaseRepository
import com.example.kitsuapi.data.remote.apiiservices.AnimeApiService
import com.example.kitsuapi.data.repositories.pagingsource.AnimePagingSource
import com.example.kitsuapi.models.episodes.DataItemEpisode
import com.example.kitsuapi.models.episodes.ResponseEpisode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService
) : BaseRepository() {

    fun fetchAnime() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        AnimePagingSource(animeApiService)
    }.liveData

    fun fetchDetailAnime(id: String) = doRequest {
        animeApiService.fetchDetailAnime(id)
    }

    fun fetchEpisode(): MutableLiveData<ResponseEpisode<DataItemEpisode>> {
        val data: MutableLiveData<ResponseEpisode<DataItemEpisode>> =
            MutableLiveData()
        animeApiService.fetchEpisode()
            .enqueue(object :
                Callback<ResponseEpisode<DataItemEpisode>> {
                override fun onResponse(
                    call: Call<ResponseEpisode<DataItemEpisode>>,
                    response: Response<ResponseEpisode<DataItemEpisode>>
                ) {

                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<ResponseEpisode<DataItemEpisode>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}