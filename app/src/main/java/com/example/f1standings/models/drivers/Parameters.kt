package com.example.f1standings.models.drivers


import com.google.gson.annotations.SerializedName

data class Parameters(
    @SerializedName("season")
    val season: String
)