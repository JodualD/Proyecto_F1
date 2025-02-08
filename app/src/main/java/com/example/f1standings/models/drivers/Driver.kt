package com.example.f1standings.models.drivers


import com.google.gson.annotations.SerializedName

data class Driver(
    @SerializedName("abbr")
    val abbr: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: Int
)