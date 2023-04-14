package com.example.kitsuapi.data.remote.apiiservices

import com.example.kitsuapi.model.DataItem
import com.example.kitsuapi.model.Response
import com.example.kitsuapi.model.ResponseDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(
        @Query("page[limit]") pageLimit: Int,
        @Query("page[offset]") pageOffset: Int
    ): Response<DataItem>

    @GET("manga/{id}")
    suspend fun fetchDetailManga(
        @Path("id") id: String
    ): ResponseDetail
}