package com.example.asolima1_rapidrecall

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SummaryScreen(
    totalAttempts: Int,
    correctAttempts: Int,
    accuracy: Double,
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
            text = "Attempt Summary",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Total Attempts: $totalAttempts",
            fontSize = 18.sp
        )

        Text(
            text = "Correct Attempts: $correctAttempts",
            fontSize = 18.sp
        )

        Text(
            text = "Accuracy: ${"%.1f".format(accuracy)}%",
            fontSize = 18.sp
        )
    }
}