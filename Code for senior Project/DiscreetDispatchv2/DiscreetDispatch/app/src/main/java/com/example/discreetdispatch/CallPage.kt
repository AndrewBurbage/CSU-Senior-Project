package com.example.discreetdispatch

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.discreetdispatch.network.ApiClient
import kotlinx.coroutines.launch

class CallPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val script = intent.getStringExtra("script") ?: "No information given."

        setContent {
            MaterialTheme {
                CallPageScreen(
                    script = script,
                    onBackClick = { finish() },
                    onMakeCallClick = { makeTestCall(script) }
                )
            }
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

@Composable
fun CallPageScreen(script: String, onBackClick: () -> Unit, onMakeCallClick: () -> Unit) {
    val lightBlue = Color(0xFFADD8E6)
    val darkBlue = Color(0xFF00008B)

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(lightBlue)
                    .padding(top = 48.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Discreet Dispatch",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Call Summary:",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Button(
                        onClick = onBackClick,
                        colors = ButtonDefaults.buttonColors(containerColor = darkBlue)
                    ) {
                        Text("Back", color = Color.White)
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = script,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onMakeCallClick,
                colors = ButtonDefaults.buttonColors(containerColor = darkBlue),
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Text("Make Call", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}
