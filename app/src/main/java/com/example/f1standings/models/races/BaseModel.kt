package com.example.f1standings.models.races

import com.google.gson.annotations.SerializedName

data class BaseModel(
    @SerializedName("errors")
    val errors: List<Any> = emptyList(), // Lista vacía por defecto
    @SerializedName("get")
    val `get`: String = "sample_get", // Valor por defecto
    @SerializedName("parameters")
    val parameters: Parameters, // Instancia por defecto
    @SerializedName("response")
    val response: List<Response>,
    @SerializedName("results")
    val results: Int = 2 // Valor predeterminado, por ejemplo, 2 resultados
)
