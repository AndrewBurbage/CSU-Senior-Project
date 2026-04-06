package com.example.seniorproject_discreetdispatch

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun FireScreen(onFinishClick: (String) -> Unit) {
    // 1. State logic (restored from your old file)
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

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // M3 Header
        Text(
            text = "Fire Response Request",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )

        // 2. Personal Info & Address
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name:") },
            modifier = Modifier.fillMaxWidth()
        )

        M3RadioGroup(
            label = "Gender:",
            options = listOf("Male", "Female"),
            selectedOption = gender,
            onOptionSelected = { gender = it }
        )

        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Enter your address:") },
            placeholder = { Text("Street Address, City, State, Zip") },
            modifier = Modifier.fillMaxWidth()
        )

        // 3. Fire Specific Details
        M3RadioGroup(
            label = "Nature of Call:",
            options = listOf("Car Fire", "Structure Fire", "Forest Fire", "Hazardous Materials", "Other"),
            selectedOption = callType,
            onOptionSelected = { callType = it }
        )

        M3RadioGroup(
            label = "How intense is the fire?",
            options = listOf("Low", "Medium", "High", "Extreme"),
            selectedOption = intensity,
            onOptionSelected = { intensity = it }
        )

        // 4. Safety & Others
        M3RadioGroup(
            label = "Are you in immediate Danger?",
            options = listOf("Yes", "No"),
            selectedOption = danger,
            onOptionSelected = { danger = it }
        )

        M3RadioGroup(
            label = "Can you get to safety?",
            options = listOf("Yes", "No"),
            selectedOption = safety,
            onOptionSelected = { safety = it }
        )

        M3RadioGroup(
            label = "Is anyone else hurt or in danger?",
            options = listOf("Yes", "No"),
            selectedOption = othersAffected,
            onOptionSelected = { othersAffected = it }
        )

        OutlinedTextField(
            value = othersDetails,
            onValueChange = { othersDetails = it },
            label = { Text("If so, how many persons and what are their conditions?") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = otherInfo,
            onValueChange = { otherInfo = it },
            label = { Text("Give any additional details:") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )

        // 5. Action Button
        Button(
            onClick = {
                val script = """
                    Hello, my name is ${name.ifBlank { "Name not Given" }}.
                    I am a ${gender.ifBlank { "Gender not given" }}. 
                    I am currently at ${address.ifBlank { "Address not given" }}.
                    I am reporting a ${callType.ifBlank { "Fire" }} incident.
                    Fire intensity: ${intensity.ifBlank { "Unknown" }}
                    Am I in Immediate danger? ${danger.ifBlank { "Unknown" }}.
                    Can you get to safety? ${safety.ifBlank { "Unknown" }}.
                    Are others affected? ${othersAffected.ifBlank { "Unknown" }}. 
                    Details about others: ${othersDetails.ifBlank { "No details given" }}.
                    Other Details: ${otherInfo.ifBlank { "No details given" }}.
                """.trimIndent()
                onFinishClick(script)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("FINISH", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}