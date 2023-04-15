package com.example.kitsuapi.model

import com.google.gson.annotations.SerializedName

data class ResponseDetail(
    @SerializedName("data")
    val data: DataItem
)