package com.example.numbers.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "http://numbersapi.com"

private val retrofit =
    Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create()).baseUrl(
        BASE_URL
    ).build()

interface NumbersApiService {
    @GET("{number}/trivia")
    suspend fun getFact(@Path("number") number: Int): String
}

object NumbersApi {
    val retrofitService: NumbersApiService by lazy {
        retrofit.create(NumbersApiService::class.java)
    }
}




