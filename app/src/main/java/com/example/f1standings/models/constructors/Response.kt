package com.example.f1standings.models.constructors


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("points")
    val points: Int,
    @SerializedName("position")
    val position: Int,
    @SerializedName("season")
    val season: Int,
    @SerializedName("team")
    val team: Team
)