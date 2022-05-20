package com.example.practiceTask.api

import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCountries() = apiService.getCountries()
    suspend fun getCountry(countrySlug: String) = apiService.getCountry(countrySlug)
}