package com.example.kitsuapi.models.episodes

import com.google.gson.annotations.SerializedName

data class ResponseEpisode<T>(
    @SerializedName("data")
    val data: List<T>,
    @SerializedName("meta")
    val meta: Meta
)