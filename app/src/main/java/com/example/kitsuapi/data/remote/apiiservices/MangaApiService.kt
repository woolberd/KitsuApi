package com.example.kitsuapi.data.remote.apiiservices

import com.example.kitsuapi.model.DataItem
import com.example.kitsuapi.model.Response
import retrofit2.http.GET

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(): Response<DataItem>
}