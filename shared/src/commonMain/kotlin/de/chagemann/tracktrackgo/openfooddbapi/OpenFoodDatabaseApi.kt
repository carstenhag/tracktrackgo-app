package de.chagemann.tracktrackgo.openfooddbapi

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

private const val baseUrl = "https://world.openfoodfacts.net/"

class OpenFoodDatabaseApi(
    private val httpClient: HttpClient
) {
    suspend fun getProductForBarcode(barcode: String): String? {
        val result = runCatching {
            httpClient
                .get(baseUrl + "api/v3/product/$barcode")
                .body<String>()
        }

        return result.getOrNull()
    }
}