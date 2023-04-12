package com.example.kitsuapi.data.remote.apiiservices

import com.example.kitsuapi.model.DataItem
import com.example.kitsuapi.model.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(): Response<DataItem>

    @GET("manga/{id}")
    suspend fun fetchDetailManga(
        @Path("id") id : String
    ): Response<DataItem>
}