package com.example.asolima1_rapidrecall

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


/**
 * Displays completed attempts from the current session.
 */

@Composable
fun LogScreen(
    attempts: List<Attempt>,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {

        Button(
            onClick = {
                onBack()
            }
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Attempt Log",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (attempts.isEmpty()) {

            Text("No attempts yet.")

        } else {

            LazyColumn {

                items(attempts) { attempt ->

                    Card {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                "Sequence Length: ${attempt.sequenceLength}"
                            )

                            Text(
                                "Your Guess: ${attempt.userInput}"
                            )

                            Text(
                                "Correct Sequence: ${attempt.targetSequence}"
                            )

                            if (attempt.isCorrect) {
                                Text("Result: Correct")
                            } else {
                                Text("Result: Incorrect")
                            }

                            Text(
                                "Time: ${formatTime(attempt.time)}"
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )
                }
            }
        }
    }
}

private fun formatTime(time: Long): String {

    val formatter = SimpleDateFormat(
        "MMM d, yyyy h:mm a",
        Locale.getDefault()
    )

    return formatter.format(Date(time))
}