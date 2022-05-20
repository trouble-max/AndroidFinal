package com.example.practiceTask.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("countries")
    suspend fun getCountries(): Response<List<Countries>>

    @GET("country/{slug}")
    suspend fun getCountry(@Path("slug") countrySlug: String): Response<List<Country>>

}