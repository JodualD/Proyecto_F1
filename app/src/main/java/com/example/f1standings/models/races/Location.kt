package com.example.f1standings.models.races


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String
)