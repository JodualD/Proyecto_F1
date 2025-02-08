package com.example.f1standings.models.races


import com.google.gson.annotations.SerializedName

data class Circuit(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
)