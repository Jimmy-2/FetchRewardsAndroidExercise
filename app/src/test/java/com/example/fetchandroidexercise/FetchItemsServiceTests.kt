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

//Test
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
    fun test_api_service_on_mock_json() {
        enqueue("fetch_items.json")
        runBlocking {
            val apiResponse = service.getNames()

            Assert.assertNotNull(apiResponse)
            Assert.assertTrue("Error: No fetch items received", apiResponse.isNotEmpty())

            val correctListIds = listOf(2, 2, 1, 1, 3, 4, 4, 1, 2, 1, 3, 2, 2, 3, 2, 4, 4, 1, 2, 2)
            for (i in 0..apiResponse.size - 1) {
                Assert.assertEquals("Error: list id did not match." , correctListIds[i], apiResponse[i].listId)
            }

        }
    }



}