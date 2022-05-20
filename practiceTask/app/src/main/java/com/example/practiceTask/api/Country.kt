package com.example.practiceTask.api

data class Country(
    val ID: String,
    val Country: String,
    val CountryCode: String,
    val Province: String,
    val City: String,
    val CityCode: String,
    val Lat: String,
    val Lon: String,
    val Confirmed: String,
    val Deaths: Long,
    val Recovered: Long,
    val Active: Long,
    val Date: String
)
