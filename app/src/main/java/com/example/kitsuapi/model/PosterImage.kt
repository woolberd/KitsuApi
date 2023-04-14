package com.example.kitsuapi.model

import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("original")
    val original: String
)