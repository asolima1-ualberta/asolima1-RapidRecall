package com.example.asolima1_rapidrecall

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds


/**
 * Displays the game interface and manages the UI state for one game round.
 */
@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onAttemptCompleted: (Attempt) -> Unit,
    generateSequence: (Int) -> String
) {
    var sequenceLength by remember {
        mutableIntStateOf(1)
    }

    var targetSequence by remember {
        mutableStateOf("")
    }

    var isBeingDisplayed by remember {
        mutableStateOf(false)
    }

    var currentDisplayedDigit by remember {
        mutableStateOf("")
    }

    var userInput by remember {
        mutableStateOf("")
    }

    var feedback by remember {
        mutableStateOf("")
    }

    var roundFinished by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(isBeingDisplayed) {

        if (isBeingDisplayed) {

            for (i in targetSequence.indices) {

                currentDisplayedDigit =
                    targetSequence[i].toString()

                delay(1000.milliseconds)

                currentDisplayedDigit = ""

                delay(300.milliseconds)
            }

            isBeingDisplayed = false
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    onBack()
                }
            ) {
                Text("Back")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "RapidRecall",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Setup stage
        if (targetSequence.isEmpty()) {

            Text(
                text = "Choose Sequence Length",
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                    onClick = {
                        if (sequenceLength > 1) {
                            sequenceLength--
                        }
                    }
                ) {
                    Text("-")
                }

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "$sequenceLength",
                    fontSize = 25.sp
                )

                Spacer(modifier = Modifier.width(20.dp))

                Button(
                    onClick = {
                        if (sequenceLength < 10) {
                            sequenceLength++
                        }
                    }
                ) {
                    Text("+")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    userInput = ""
                    feedback = ""
                    roundFinished = false
                    currentDisplayedDigit = ""

                    targetSequence =
                        generateSequence(sequenceLength)

                    isBeingDisplayed = true
                }
            ) {
                Text("Start Round")
            }
        }

        // Temporary testing display.
        if (targetSequence.isNotEmpty()) {
            Spacer(modifier = Modifier.height(15.dp))

//            Text(
//                text = "TEST - Generated Sequence: $targetSequence",
//                fontSize = 15.sp
//            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Sequence display stage
        if (isBeingDisplayed) {

            Text(
                text = "Remember this sequence",
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = currentDisplayedDigit,
                fontSize = 48.sp
            )
        }

        // Input stage
        if (
            targetSequence.isNotEmpty() &&
            !isBeingDisplayed &&
            !roundFinished
        ) {

            Text(
                text = "Enter the sequence you remember:",
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = userInput,
                onValueChange = { newInput ->

                    if (
                        newInput.all { it.isDigit() } &&
                        newInput.length <= sequenceLength
                    ) {
                        userInput = newInput
                    }
                },
                label = {
                    Text("Enter Sequence")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {

                    val isCorrect =
                        userInput == targetSequence

                    if (isCorrect) {
                        feedback = "Correct!"
                    } else {
                        feedback = "Incorrect!"
                    }

                    val attempt = Attempt(
                        sequenceLength = sequenceLength,
                        userInput = userInput,
                        targetSequence = targetSequence,
                        isCorrect = isCorrect,
                        time = System.currentTimeMillis()
                    )

                    onAttemptCompleted(attempt)

                    roundFinished = true
                },
                enabled = userInput.length == sequenceLength
            ) {
                Text("Submit")
            }
        }

        // Result stage
        if (roundFinished) {

            Text(
                text = feedback,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Your Guess: $userInput",
                fontSize = 18.sp
            )

            Text(
                text = "Correct Sequence: $targetSequence",
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    targetSequence = ""
                    userInput = ""
                    feedback = ""
                    roundFinished = false
                    currentDisplayedDigit = ""
                }
            ) {
                Text("New Round")
            }
        }
    }
}