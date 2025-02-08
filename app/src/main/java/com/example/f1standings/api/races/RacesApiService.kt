package com.example.f1standings.api.races

import com.example.f1standings.models.races.BaseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RacesApiService {
    @Headers(
        "X-RapidAPI-Key: da883eacd4msh951169361fe1e14p1f8151jsn1a03e4cc8c1e",
        "X-RapidAPI-Host: api-formula-1.p.rapidapi.com"
    )
    @GET("?season=2022&type=race")
    fun getRaces(): Call<BaseModel>
}