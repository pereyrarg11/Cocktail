package com.pereyrarg11.cocktail.detail.data.network.service

import com.pereyrarg11.cocktail.common.data.Converter
import com.pereyrarg11.cocktail.detail.data.network.client.DrinkDetailClient
import com.pereyrarg11.cocktail.detail.data.network.model.schema.DrinkDetailWrapperSchema
import com.pereyrarg11.cocktail.detail.data.repository.model.content.DrinkDetailContent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DrinkDetailService @Inject constructor(
    private val apiClient: DrinkDetailClient,
    private val converter: Converter<DrinkDetailWrapperSchema, DrinkDetailContent>,
) {

    suspend fun requestById(id: String): DrinkDetailContent {
        // TODO: handle exceptions
        return withContext(Dispatchers.IO) {
            val responseBody = apiClient.requestById(id).body()
            val content = if (responseBody != null) {
                converter.convert(responseBody)
            } else {
                null
            }

            if (content != null && content.id.isNotEmpty() && content.name.isNotEmpty()) {
                content
            } else {
                throw Exception("Drink not found")
            }
        }
    }
}