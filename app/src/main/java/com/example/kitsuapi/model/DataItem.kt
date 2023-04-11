package com.example.kitsuapi.model

import com.example.kitsuapi.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("id")
    override val id: String,
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("type")
    val type: String
) : IBaseDiffModel