package com.example.kadoc

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.json.Json

class TipOfDayRepository(
    private val client: HttpClient
) {
    suspend fun getTipOfDay(): Fact {
        return client.get("https://catfact.ninja/fact").let {
            if (it.status == HttpStatusCode.OK) {
                 Json.decodeFromString(it.bodyAsText())
            } else {
                throw Exception("Error while fetching tip of day")
            }
        }
    }
}