package com.example.asolima1_rapidrecall

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onStart: () -> Unit,
    onLog: () -> Unit,
    onSummary: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "RapidRecall",
            fontSize = 40.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = {
                    onStart()
                }
            ) {
                Text("Start")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    onLog()
                }
            ) {
                Text("Log")
            }

            Spacer(modifier = Modifier.width(10.dp))

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