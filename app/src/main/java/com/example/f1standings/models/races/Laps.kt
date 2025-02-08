package com.example.f1standings.models.races


import com.google.gson.annotations.SerializedName

data class Laps(
    @SerializedName("current")
    val current: Any,
    @SerializedName("total")
    val total: Int
)