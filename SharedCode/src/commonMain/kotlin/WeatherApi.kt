package com.jetbrains.handson.mpp.mobile

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.serialization.*

class WeatherApi(localName: String) {
    private val client = HttpClient()
    private val location = localName

    suspend fun fetchWeather(): String {
        return client.get<String> {
            url("$baseUrl/location/search/?query=$location")
        }
    }

    /*
    suspend fun fetchWeather(): WeatherResponse {
        return client.get<WeatherResponse> {
            url("$baseUrl/location/search/?query=$location")
        }
    }
     */

    companion object {
        private const val baseUrl = "https://www.metaweather.com/api"
    }

    @Serializable
    data class WeatherResponse(val title: String, val location_type: String )
}