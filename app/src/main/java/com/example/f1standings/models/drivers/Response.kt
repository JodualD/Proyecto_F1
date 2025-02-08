package com.example.f1standings.models.drivers


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("behind")
    val behind: Any?,
    @SerializedName("driver")
    val driver: Driver,
    @SerializedName("points")
    val points: Int,
    @SerializedName("position")
    val position: Int,
    @SerializedName("season")
    val season: Int,
    @SerializedName("team")
    val team: Team,
    @SerializedName("wins")
    val wins: Any?
)