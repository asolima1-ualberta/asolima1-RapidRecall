package com.example.asolima1_rapidrecall

/**
 * Stores session data and provides the main non-UI logic for RapidRecall.
 *
 * Purpose:
 * Keeps the list of completed attempts along with calculations of summary stats.
 * Also performs the generation of the sequences
 *
 * Design rationale:
 * Game and session logic is intentionally kept separate from the Compose screens so
 * the UI components are what are responsible for displaying information

 *
 * Outstanding issues:
 * Attempt data is only stored for the current app session, as persistent
 * storage is not required for this assignment.
 */

class RapidRecallModel {

    private val attempts = mutableListOf<Attempt>()

    fun addAttempt(attempt: Attempt) {
        attempts.add(attempt)
    }

    fun getAttempts(): List<Attempt> {
        return attempts.toList()
    }

    fun generateSequence(length: Int): String {
        var sequence = ""

        repeat(length) {
            val digit = (0..9).random()
            sequence += digit
        }

        return sequence
    }

    fun getTotalAttempts(): Int {
        return attempts.size
    }

    fun getCorrectAttempts(): Int {
        var correctAttempts = 0

        for (attempt in attempts) {
            if (attempt.isCorrect) {
                correctAttempts++
            }
        }

        return correctAttempts
    }

    fun getAccuracy(): Double {
        if (attempts.isEmpty()) {
            return 0.0
        }

        return getCorrectAttempts().toDouble() / attempts.size * 100
    }
}