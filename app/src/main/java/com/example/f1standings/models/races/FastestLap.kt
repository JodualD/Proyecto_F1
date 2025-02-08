package com.example.f1standings.models.races


import com.google.gson.annotations.SerializedName

data class FastestLap(
    @SerializedName("driver")
    val driver: Driver,
    @SerializedName("time")
    val time: String
)