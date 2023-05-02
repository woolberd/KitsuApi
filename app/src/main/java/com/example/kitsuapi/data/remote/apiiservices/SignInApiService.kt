package com.example.kitsuapi.data.remote.apiiservices

import com.example.kitsuapi.models.auth.AuthModel
import com.example.kitsuapi.models.auth.TokenModel
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {

    @POST("oauth/token")
    suspend fun postAuth(
        @Body authModel: AuthModel
    ): TokenModel
}