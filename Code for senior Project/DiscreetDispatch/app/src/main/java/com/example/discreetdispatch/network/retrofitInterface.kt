package com.example.discreetdispatch.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TwilioApi {
    @POST("start-call")
    suspend fun startCall(@Body body: Map<String, String>): Response<Unit>
}
