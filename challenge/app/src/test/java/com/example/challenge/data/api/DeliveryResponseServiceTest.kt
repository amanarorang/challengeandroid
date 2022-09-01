package com.example.challenge.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DeliveryResponseServiceTest {
    private lateinit var service: DeliveryApiService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url("https://mock-api-mobile.dev.lalamove.com/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DeliveryApiService::class.java)


    }

    private fun enqueueMockResponse(
        fileName:String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)

    }

    @Test
    fun getDeliveryResponse_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("DeliveryResponse.json")
            val responseBody = service.getDeliveryData(0,50)
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()



        }
    }

    @Test
    fun getDeliveryResponse_receivedResponse_correctPageSize(){
        runBlocking {
            enqueueMockResponse("DeliveryResponse.json")
            val responseBody = service.getDeliveryData(0,50).body()
            if (responseBody != null) {
                assertThat(responseBody.size).isEqualTo(50)
            }

        }
    }

    @Test
    fun getDelivryResponse_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getDeliveryData(0, 50).body()
            val deliveryResponseItem = responseBody!!.get(0)
            assertThat(deliveryResponseItem.id).isEqualTo("5dd5f3a7156bae72fa5a5d6c")



        }
    }
@After
    fun tearDown() {
        server.shutdown()
    }
}