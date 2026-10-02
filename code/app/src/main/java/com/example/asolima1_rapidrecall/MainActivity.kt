package com.example.asolima1_rapidrecall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.asolima1_rapidrecall.ui.theme.Asolima1RapidRecallTheme

/**
 * Main Android activity for the RapidRecall application.
 *
 * Purpose:
 * Starts the Compose UI with the main role of handling
 * navigation between the start/game/log/summary screens,
 * owns the application model
 *
 * Design rationale:
 * MainActivity connects the application's screens and shared model together while
 * intentionally leaving gameplay logic and screen-specific UI to their respective files.
 *
 * Outstanding issues:
 * None known.
 */

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Asolima1RapidRecallTheme {

                var currentScreen by remember {
                    mutableStateOf(Screen.START)
                }

                val model = remember {
                    RapidRecallModel()
                }

                when (currentScreen) {

                    Screen.START -> {
                        StartScreen(
                            onStart = {
                                currentScreen = Screen.GAME
                            },
                            onLog = {
                                currentScreen = Screen.LOG
                            },
                            onSummary = {
                                currentScreen = Screen.SUMMARY
                            }
                        )
                    }

                    Screen.GAME -> {
                        GameScreen(
                            onBack = {
                                currentScreen = Screen.START
                            },
                            onAttemptCompleted = { attempt ->
                                model.addAttempt(attempt)
                            },
                            generateSequence = { length ->
                                model.generateSequence(length)
                            }
                        )
                    }

                    Screen.LOG -> {
                        LogScreen(
                            attempts = model.getAttempts(),
                            onBack = {
                                currentScreen = Screen.START
                            }
                        )
                    }

                    Screen.SUMMARY -> {
                        SummaryScreen(
                            totalAttempts = model.getTotalAttempts(),
                            correctAttempts = model.getCorrectAttempts(),
                            accuracy = model.getAccuracy(),
                            onBack = {
                                currentScreen = Screen.START
                            }
                        )
                    }
                }
            }
        }
    }
}