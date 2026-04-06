package com.example.seniorproject_discreetdispatch

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FireTruck
import androidx.compose.material.icons.filled.LocalPolice
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.seniorproject_discreetdispatch.ui.theme.SeniorProjectDiscreetDispatchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SeniorProjectDiscreetDispatchTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current // 3. Grab the context here

    val items = listOf("Police", "Fire", "EMS")
    val icons = listOf(Icons.Default.LocalPolice, Icons.Default.FireTruck, Icons.Default.MedicalServices)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Discreet Dispatch", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        Text("Silent Emergency Contact", style = MaterialTheme.typography.labelMedium)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                items.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(icons[items.indexOf(item)], contentDescription = item) },
                        label = { Text(item) },
                        selected = currentRoute == item.lowercase(),
                        onClick = {
                            navController.navigate(item.lowercase()) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen(navController) }

            composable("police") {
                // Now matches the definition below
                PoliceScreen(onFinishClick = { script ->
                    val intent = Intent(context, CallPage::class.java)
                    intent.putExtra("script", script)
                    context.startActivity(intent)
                })
            }
            composable("fire") {
                FireScreen(onFinishClick = { script ->
                val intent = Intent(context, CallPage::class.java).apply {
                    putExtra("script", script)
                }
                context.startActivity(intent)
            })
            }
            composable("ems") {
                EmsScreen(onFinishClick = { script ->
                    val intent = Intent(context, CallPage::class.java).apply {
                        putExtra("script", script)
                    }
                    context.startActivity(intent)
                })
            }
        }
    }
}