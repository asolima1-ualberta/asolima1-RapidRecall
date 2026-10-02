package com.example.asolima1_rapidrecall

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SummaryScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    Spacer(modifier.height(40.dp))
    Button(
        onClick = {
            onBack()
        }
    ) {
        Text("Back")
    }

    Column(
        modifier = modifier.padding(top=60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Summary Screen", fontSize = 30.sp)
    }

}