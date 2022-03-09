package com.example.fetchandroidexercise

import com.example.fetchandroidexercise.network.FetchApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class FetchItemsServiceTests: BaseTest() {
    private lateinit var service: FetchApiService

    @Before
    fun setup() {
        val url = mockWebServer.url("/")
        service = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                ))
            .build()
            .create(FetchApiService::class.java)
    }

    @Test
    fun api_service() {
        enqueue("fetchItems.json")
        runBlocking {
            val apiResponse = service.getNames()

            Assert.assertNotNull(apiResponse)
            Assert.assertTrue("The list was empty", apiResponse.isNotEmpty())
            Assert.assertEquals("The id's did not match", "755", apiResponse[0].id)
        }
    }
}