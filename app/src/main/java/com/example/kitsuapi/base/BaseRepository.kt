package com.example.kitsuapi.base

import androidx.lifecycle.liveData
import com.example.kitsuapi.utils.Resource
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {

    fun <T> doRequest(request: suspend () -> T) = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (exception: Exception) {
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
}