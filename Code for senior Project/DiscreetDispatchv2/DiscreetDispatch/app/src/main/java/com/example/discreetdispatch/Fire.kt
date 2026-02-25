package com.example.discreetdispatch

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Fire : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                FireScreen(
                    onBackClick = { finish() },
                    onFinishClick = { script ->
                        val intent = Intent(this, CallPage::class.java)
                        intent.putExtra("script", script)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@Composable
fun FireScreen(onBackClick: () -> Unit, onFinishClick: (String) -> Unit) {
    var name by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var callType by rememberSaveable { mutableStateOf("") }
    var danger by rememberSaveable { mutableStateOf("") }
    var safety by rememberSaveable { mutableStateOf("") }
    var othersAffected by rememberSaveable { mutableStateOf("") }
    var othersDetails by rememberSaveable { mutableStateOf("") }
    var intensity by rememberSaveable { mutableStateOf("") }
    var otherInfo by rememberSaveable { mutableStateOf("") }

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
                    Button(
                        onClick = onBackClick,
                        colors = ButtonDefaults.buttonColors(containerColor = darkBlue)
                    ) {
                        Text("Back", color = Color.White)
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Discreet Dispatch",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Fire Response Request",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
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
                .padding(16.dp)
        ) {
            FormField(label = "Enter your name:", value = name, onValueChange = { name = it }, hint = "Name")

            RadioGroupField(
                label = "Gender:",
                options = listOf("Male", "Female"),
                selectedOption = gender,
                onOptionSelected = { gender = it }
            )

            FormField(
                label = "Enter your address:",
                value = address,
                onValueChange = { address = it },
                hint = "Street Address, City, State, Zip"
            )

            RadioGroupField(
                label = "Nature of Call:",
                options = listOf("Car Fire", "Structure Fire", "Forest Fire", "Hazardous Materials", "Other"),
                selectedOption = callType,
                onOptionSelected = { callType = it },
                orientation = "vertical"
            )

            RadioGroupField(
                label = "Are you in immediate Danger?",
                options = listOf("Yes", "No"),
                selectedOption = danger,
                onOptionSelected = { danger = it }
            )

            RadioGroupField(
                label = "Can you get to safety?",
                options = listOf("Yes", "No"),
                selectedOption = safety,
                onOptionSelected = { safety = it }
            )

            RadioGroupField(
                label = "Is anyone else hurt or in danger?",
                options = listOf("Yes", "No"),
                selectedOption = othersAffected,
                onOptionSelected = { othersAffected = it }
            )

            FormField(
                label = "If so, how many persons are what are their conditions?",
                value = othersDetails,
                onValueChange = { othersDetails = it },
                hint = "Number of persons, injuries, etc."
            )

            RadioGroupField(
                label = "How intense is the fire?",
                options = listOf("Low", "Medium", "High", "Extreme"),
                selectedOption = intensity,
                onOptionSelected = { intensity = it },
                orientation = "vertical"
            )

            FormField(
                label = "Give any additional details:",
                value = otherInfo,
                onValueChange = { otherInfo = it },
                hint = "Details"
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    val script = """
                        Hello, my name is ${name.ifBlank { "Name not Given" }}.
                        I am a ${gender.ifBlank { "Gender not given" }}. 
                        I am currently at ${address.ifBlank { "Address not given" }}.
                        I am reporting a ${callType.ifBlank { "Fire" }} incident.
                        Am I in Immediate danger? ${danger.ifBlank { "Unknown" }}. 
                        Are others affected? ${othersAffected.ifBlank { "Unknown" }}. 
                        Details about others: ${othersDetails.ifBlank { "No details given" }}.
                        Fire intensity: ${intensity.ifBlank { "Unknown" }}
                        Other Details: ${otherInfo.ifBlank { "No details given" }}.
                    """.trimIndent()
                    onFinishClick(script)
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = darkBlue)
            ) {
                Text("FINISH", color = Color.White)
            }
        }
    }
}
