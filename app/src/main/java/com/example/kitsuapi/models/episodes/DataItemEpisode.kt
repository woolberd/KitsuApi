package com.example.kitsuapi.models.episodes

import com.example.kitsuapi.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class DataItemEpisode(
    @SerializedName("attributes")
    val attributes: AttributesEpisode,
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("type")
    val type: String = ""
): IBaseDiffModel