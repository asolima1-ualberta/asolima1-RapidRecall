package com.example.asolima1_rapidrecall

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class StartScreen {
}

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onStart: () -> Unit,
    onLog: () -> Unit,
    onSummary: () -> Unit
) {
    Column(
        modifier = modifier.padding(top=60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Rapid Recall", fontSize = 40.sp)
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    onStart()
                }
            ) {
                Text("Start")
            }

            Spacer(modifier = modifier.width(10.dp))

            Button(
                onClick = {
                    onLog()
                }
            ) {
                Text("Log")
            }

            Spacer(modifier = modifier.width(10.dp))

            Button(
                onClick = {
                    onSummary()
                }
            ) {
                Text("Attempt Summary")
            }
        }
    }
}