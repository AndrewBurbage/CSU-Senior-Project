package com.example.seniorproject_discreetdispatch

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PhoneInTalk
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.seniorproject_discreetdispatch.network.ApiClient
import com.example.seniorproject_discreetdispatch.ui.theme.SeniorProjectDiscreetDispatchTheme
import kotlinx.coroutines.launch

class CallPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Retrieve the generated script from the Intent
        val script = intent.getStringExtra("script") ?: "No information given."

        setContent {
            SeniorProjectDiscreetDispatchTheme {
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
                // Your Twilio/API logic
                val response = ApiClient.api.startCall(
                    mapOf(
                        "to" to "+18438131792",
                        "script" to script
                    )
                )

                if (response.isSuccessful) {
                    Toast.makeText(this@CallPage, "Call started successfully!", Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(this@CallPage, "Failed: ${response.code()}", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@CallPage, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallPageScreen(script: String, onBackClick: () -> Unit, onMakeCallClick: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Call Summary", style = MaterialTheme.typography.titleLarge)
                        Text("Review dispatch script", style = MaterialTheme.typography.labelSmall)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Script Preview Card
            Text(
                text = "The following script will be read to the dispatcher:",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(8.dp))

            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Text(
                    text = script,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp),
                    lineHeight = MaterialTheme.typography.bodyLarge.lineHeight * 1.2
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            // The Action Button
            Button(
                onClick = onMakeCallClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                contentPadding = PaddingValues(horizontal = 24.dp)
            ) {
                Icon(Icons.Default.PhoneInTalk, contentDescription = null)
                Spacer(Modifier.width(12.dp))
                Text(
                    text = "INITIATE EMERGENCY CALL",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Warning: This will trigger an automated voice call to the dispatch center.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center
            )
        }
    }
}