package com.example.f1standings.models.races

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("circuit")
    val circuit: Circuit,
    @SerializedName("competition")
    val competition: Competition,
    @SerializedName("date")
    val date: String,
    @SerializedName("distance")
    val distance: String,
    @SerializedName("fastest_lap")
    val fastestLap: FastestLap
)
