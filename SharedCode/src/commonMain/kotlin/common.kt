package com.jetbrains.handson.mpp.mobile

expect fun locationName(): String

fun createWeatherApi() : WeatherApi {
    val location = locationName()
    return WeatherApi(location)
}