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
fun EmsScreen(onFinishClick: (String) -> Unit) {
    // 1. State logic (identical to your original version)
    var name by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var callType by rememberSaveable { mutableStateOf("") }
    var emergencyDetails by rememberSaveable { mutableStateOf("") }
    var danger by rememberSaveable { mutableStateOf("") }
    var safety by rememberSaveable { mutableStateOf("") }
    var othersAffected by rememberSaveable { mutableStateOf("") }
    var othersDetails by rememberSaveable { mutableStateOf("") }
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
            text = "EMS Response Request",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )

        // 2. Personal Information
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name:") },
            modifier = Modifier.fillMaxWidth()
        )

        M3RadioGroup(
            label = "Age Group:",
            options = listOf(
                "Young: 25 years old or younger",
                "Adult: 25 years to 65 years old",
                "Elderly: over 65 years old"
            ),
            selectedOption = age,
            onOptionSelected = { age = it }
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

        // 3. Medical Nature of Call
        M3RadioGroup(
            label = "Nature of Call:",
            options = listOf(
                "Cardiac Issue",
                "Burn (Chemical or Thermal)",
                "Puncture or Laceration",
                "Unconscious or Unresponsive",
                "Other"
            ),
            selectedOption = callType,
            onOptionSelected = { callType = it }
        )

        OutlinedTextField(
            value = emergencyDetails,
            onValueChange = { emergencyDetails = it },
            label = { Text("What are you or the victim's condition?") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 2
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
            label = { Text("How many persons and their conditions?") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = otherInfo,
            onValueChange = { otherInfo = it },
            label = { Text("Additional details for EMS:") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )

        // 5. Action Button
        Button(
            onClick = {
                val script = """
                    Hello, my name is ${name.ifBlank { "Name not Given" }}.
                    Age group: ${age.ifBlank { "Age not given" }}.
                    Gender: ${gender.ifBlank { "Gender not given" }}.
                    Location: ${address.ifBlank { "Address not given" }}.
                    Emergency type: ${callType.ifBlank { "Medical" }}.
                    Victim condition: ${emergencyDetails.ifBlank { "No details given" }}.
                    Immediate danger? ${danger.ifBlank { "Unknown" }}.
                    Can you get to safety? ${safety.ifBlank { "Unknown" }}.
                    Are others affected? ${othersAffected.ifBlank { "Unknown" }}.
                    Others details: ${othersDetails.ifBlank { "No details given" }}.
                    Additional info: ${otherInfo.ifBlank { "No details given" }}.
                """.trimIndent()
                onFinishClick(script)
            },
            modifier = Modifier.fillMaxWidth().height(56.dp)
        ) {
            Text("FINISH", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}