package com.example.kitsuapi.models.episodes

import com.google.gson.annotations.SerializedName

data class Titles(
    @SerializedName("en_us")
    val enUs: String = "",
    @SerializedName("en_jp")
    val enJp: String = ""
)