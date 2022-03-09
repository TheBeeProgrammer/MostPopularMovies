package com.example.data.model.entities

import com.google.gson.annotations.SerializedName

data class MoviesAndSeries(
    @SerializedName("name") val movieName: String?,
    @SerializedName("type") val movieGenre: String?
)