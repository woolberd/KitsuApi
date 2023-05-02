package com.example.kitsuapi.models.episodes

import com.example.kitsuapi.models.PosterImage
import com.google.gson.annotations.SerializedName

data class AttributesEpisode(
    @SerializedName("relativeNumber")
    val relativeNumber: Int = 0,
    @SerializedName("createdAt")
    val createdAt: String = "",
    @SerializedName("number")
    val number: Int = 0,
    @SerializedName("canonicalTitle")
    val canonicalTitle: String = "",
    @SerializedName("thumbnail")
    val thumbnail:  PosterImage,
    @SerializedName("airdate")
    val airdate: String = "",
    @SerializedName("length")
    val length: Int = 0,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("synopsis")
    val synopsis: String = "",
    @SerializedName("titles")
    val titles: Titles,
    @SerializedName("seasonNumber")
    val seasonNumber: Int = 0,
    @SerializedName("updatedAt")
    val updatedAt: String = ""
)