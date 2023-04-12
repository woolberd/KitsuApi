package com.example.kitsuapi.data.remote.apiiservices

import com.example.kitsuapi.model.DataItem
import com.example.kitsuapi.model.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(): Response<DataItem>

    @GET("anime/{id}")
    suspend fun fetchDetailAnime(
        @Path("id") id : String
    ): Response<DataItem>
}