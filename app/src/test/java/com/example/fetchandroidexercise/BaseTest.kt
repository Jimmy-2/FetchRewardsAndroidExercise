package com.example.fetchandroidexercise

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source

//BaseTest file copied from Google's Android Basics in Kotlin Unit 4 tutorial.
open class BaseTest {

    //Simulate receiving data from a mock json file
    val mockWebServer = MockWebServer()

    fun enqueue(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val buffer = inputStream.source().buffer()

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(buffer.readString(Charsets.UTF_8))
        )
    }




}
