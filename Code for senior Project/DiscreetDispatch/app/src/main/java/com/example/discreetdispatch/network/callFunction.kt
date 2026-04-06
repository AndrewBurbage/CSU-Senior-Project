//package com.example.discreetdispatch.network
//
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//fun placeCall(toNumber: String, script: String) {
//    CoroutineScope(Dispatchers.IO).launch {
//        val body = mapOf(
//            "to" to toNumber,
//            "script" to script
//        )
//
//        try {
//            val response = api.startCall(body)
//            if (response.isSuccessful) {
//                println("Call started successfully!")
//            } else {
//                println("Error: ${response.code()} ${response.errorBody()?.string()}")
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
//}
