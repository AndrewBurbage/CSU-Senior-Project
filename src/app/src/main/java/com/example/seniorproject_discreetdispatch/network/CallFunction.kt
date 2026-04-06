package com.example.seniorproject_discreetdispatch.network

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun placeCall(toNumber: String, script: String) {
    CoroutineScope(Dispatchers.IO).launch {
        val body = mapOf("to" to toNumber, "script" to script)
        try {
            val response = ApiClient.api.startCall(body)
            // Handle response...
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}