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
fun PoliceScreen(onFinishClick: (String) -> Unit) {
    // 1. Existing State Logic (Identical to your original)
    var name by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var callType by rememberSaveable { mutableStateOf("") }
    var danger by rememberSaveable { mutableStateOf("") }
    var safety by rememberSaveable { mutableStateOf("") }
    var othersAffected by rememberSaveable { mutableStateOf("") }
    var othersDetails by rememberSaveable { mutableStateOf("") }
    var offenderDetails by rememberSaveable { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Police Response Request",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )

        // 2. Personal Info Section
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name:") },
            placeholder = { Text("Name") },
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

        // 3. Incident Details
        M3RadioGroup(
            label = "Nature of Call:",
            options = listOf("Theft", "Collision", "Intruder", "Attack"),
            selectedOption = callType,
            onOptionSelected = { callType = it }
        )

        // 4. Safety & Danger (Critical Questions)
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

        // 5. Others Involved
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
            placeholder = { Text("Number of persons, injuries, etc.") },
            modifier = Modifier.fillMaxWidth()
        )

        // 6. Offender Description
        OutlinedTextField(
            value = offenderDetails,
            onValueChange = { offenderDetails = it },
            label = { Text("Describe the offender or offenders:") },
            placeholder = { Text("Are they armed, gender, race, height, clothing, etc.") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 7. Finish Button
        Button(
            onClick = {
                val script = """
                    Hello, my name is ${name.ifBlank { "Name not Given" }}.
                    I am a ${gender.ifBlank { "Gender not given" }}. 
                    I am currently at ${address.ifBlank { "Address not given" }}.
                    I am reporting a ${callType.ifBlank { "incident" }} incident.
                    Am I in Immediate danger? ${danger.ifBlank { "Unknown" }}.
                    Can you get to safety? ${safety.ifBlank { "Unknown" }}.
                    Are others affected? ${othersAffected.ifBlank { "Unknown" }}. 
                    Details about others: ${othersDetails.ifBlank { "No details given" }}.
                    Details about offender: ${offenderDetails.ifBlank { "No details given" }}.
                """.trimIndent()
                onFinishClick(script)
            },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("FINISH", style = MaterialTheme.typography.titleMedium)
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

/**
 * A reusable M3 Radio Group
 */
@Composable
fun M3RadioGroup(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column {
        Text(text = label, style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.secondary)
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = { onOptionSelected(option) }
                )
                Text(text = option, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}