package com.example.asolima1_rapidrecall

/**
 * Represents a completed RapidRecall game attempt.
 *
 * Purpose:
 * Stores the sequence length, user input, target sequence,
 * whether the response was correct, and the time of the attempt.
 *
 * Design rationale:
 * Attempt data is grouped into one object so that completed attempts
 * can be stored and passed between the model and UI as a single unit.
 *
 * Outstanding issues:
 * None known.
 */
data class Attempt(
    val sequenceLength: Int,
    val userInput: String,
    val targetSequence: String,
    val isCorrect: Boolean,
    val time: Long
)