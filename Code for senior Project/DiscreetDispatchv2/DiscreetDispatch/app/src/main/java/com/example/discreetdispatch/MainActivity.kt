package com.example.discreetdispatch

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                MainScreen(
                    onPoliceClick = {
                        val intent = Intent(this, police::class.java)
                        intent.putExtra("SERVICE_TYPE", "Police") // Passing the page info
                        startActivity(intent)
                    },
                    onFireClick = {
                        val intent = Intent(this, Fire::class.java)
                        intent.putExtra("SERVICE_TYPE", "Fire")
                        startActivity(intent)
                    },
                    onEmsClick = {
                        val intent = Intent(this, EMS::class.java)
                        intent.putExtra("SERVICE_TYPE", "EMS")
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    onPoliceClick: () -> Unit,
    onFireClick: () -> Unit,
    onEmsClick: () -> Unit
) {
    val darkBlue = Color(0xFF00008B)
    val lightBlue = Color(0xFFADD8E6)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(darkBlue)
                    .padding(top = 40.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Discreet Dispatch",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Silent Emergency Contact",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(lightBlue)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            EmergencyButton(text = "Police Emergency", color = darkBlue, onClick = onPoliceClick)
            EmergencyButton(text = "Fire Emergency", color = darkBlue, onClick = onFireClick)
            EmergencyButton(text = "EMS Emergency", color = darkBlue, onClick = onEmsClick)
        }
    }
}

@Composable
fun EmergencyButton(text: String, color: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(vertical = 30.dp)
            .size(width = 300.dp, height = 100.dp),
//        colors = ButtonDefaults.buttonContentColor(containerColor = color),
        shape = MaterialTheme.shapes.extraSmall
    ) {
        Text(text = text, fontSize = 20.sp, color = Color.White)
    }
}
