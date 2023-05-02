package com.example.kitsuapi.data.repositories

import com.example.kitsuapi.base.BaseRepository
import com.example.kitsuapi.data.remote.apiiservices.SignInApiService
import com.example.kitsuapi.models.auth.AuthModel
import javax.inject.Inject

class SignInRepository @Inject constructor(
    private val signInApiService: SignInApiService
): BaseRepository() {

    fun postAuth(authModel: AuthModel) = doRequest {
        signInApiService.postAuth(authModel)
    }
}