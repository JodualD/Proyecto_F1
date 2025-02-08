package com.example.f1standings.api.drivers

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DriverStandingsServiceGenerator {
    private val client = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder().baseUrl("https://api-formula-1.p.rapidapi.com/rankings/drivers/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>):T{
        return retrofit.create(service)
    }
}