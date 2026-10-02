package com.example.asolima1_rapidrecall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.asolima1_rapidrecall.ui.theme.Asolima1RapidRecallTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Asolima1RapidRecallTheme {
                var currentScreen by remember { mutableStateOf("start") }

                if (currentScreen == "start") {
                    StartScreen(
                        onStart = {
                            currentScreen = "game"
                        },
                        onLog = {
                            currentScreen = "log"
                        },
                        onSummary = {
                            currentScreen = "summary"
                        }
                    )
                } else if (currentScreen == "game") {
                    GameScreen(
                        onBack = {
                            currentScreen = "start"
                        }
                    )
                } else if (currentScreen == "log") {
                    LogScreen(
                        onBack = {
                            currentScreen = "start"
                        }
                    )
                } else if (currentScreen == "summary") {
                    SummaryScreen(
                        onBack = {
                            currentScreen = "start"
                        }
                    )
                }


            }
        }
    }
}





//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Asolima1RapidRecallTheme {
//    }
//}