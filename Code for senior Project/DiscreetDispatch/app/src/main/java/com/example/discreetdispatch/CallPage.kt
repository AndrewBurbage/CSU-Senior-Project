//package com.example.discreetdispatch
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.TextView
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
//class CallPage : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_call_page)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//
//        val callSummary: TextView = findViewById(R.id.actual_summary)
//
//        val script = intent.getStringExtra("script") ?: "No information given."
//
//        callSummary.text = script
//
//        val backButton: Button = findViewById(R.id.btn_back)
//        backButton.setOnClickListener {
//            finish()
//        }
//
//        val callButton: Button = findViewById(R.id.btn_call)
//        backButton.setOnClickListener {
//            finish()
//        }
//    }
//}

package com.example.discreetdispatch

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.discreetdispatch.network.ApiClient
import kotlinx.coroutines.launch

class CallPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_call_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val callSummary: TextView = findViewById(R.id.actual_summary)
        val script = intent.getStringExtra("script") ?: "No information given."
        callSummary.text = script

        val backButton: Button = findViewById(R.id.btn_back)
        backButton.setOnClickListener { finish() }

        val callButton: Button = findViewById(R.id.btn_call)
        callButton.setOnClickListener {
            makeTestCall(script)
        }
    }

    private fun makeTestCall(script: String) {
        lifecycleScope.launch {
            try {
                val response = ApiClient.api.startCall(
                    mapOf(
                        "to" to "+18438131792",  // Your verified Twilio number
                        "script" to script
                    )
                )

                if (response.isSuccessful) {
                    Toast.makeText(this@CallPage, "Call started successfully!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@CallPage, "Failed: ${response.code()}", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@CallPage, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
