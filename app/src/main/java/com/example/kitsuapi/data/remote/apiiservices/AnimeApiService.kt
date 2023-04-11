package com.example.kitsuapi.data.remote.apiiservices

import com.example.kitsuapi.model.DataItem
import com.example.kitsuapi.model.Response
import retrofit2.http.GET

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(): Response<DataItem>
}