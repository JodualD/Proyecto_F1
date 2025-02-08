package com.example.f1standings.models.drivers


import com.google.gson.annotations.SerializedName

data class BaseModel(
    @SerializedName("errors")
    val errors: List<Any>,
    @SerializedName("get")
    val `get`: String,
    @SerializedName("parameters")
    val parameters: Parameters,
    @SerializedName("response")
    var response: List<Response>,
    @SerializedName("results")
    var results: Int
)