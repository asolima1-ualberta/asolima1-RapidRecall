# asolima1-RapidRecall

RapidRecall is a memory game developed for CMPUT 301 Assignment 1.

The player selects a sequence length, views randomly generated digits one at a time, and then attempts to reproduce the full sequence in the correct order. The application records each completed attempt during the current session and provides both an attempt log and a summary of overall performance.

## Sources and References

### Course Materials

#### CMPUT 301 Assignment 0

Source: CMPUT 301 Fall 2026 Assignment 0  
Author: CMPUT 301 course staff

Used as a reference for basic Jetpack Compose application structure, including state, buttons, text elements, and `onClick` callbacks.

#### CMPUT 301 Lab 1

Source: CMPUT 301 Fall 2026 Lab 1  
Author: CMPUT 301 course staff

Used as a reference for basic Kotlin and Android application structure.

#### CMPUT 301 ListyCity Lab

Source: CMPUT 301 ListyCity lab  
Author: CMPUT 301 course staff

Used as a reference for displaying collections using `LazyColumn`.

### External Learning Resources

#### Android Basics with Compose

Author/Publisher: Android Developers  
URL: https://developer.android.com/courses/android-basics-compose/course

Used as supplementary documentation for Kotlin, Jetpack Compose, state, buttons, user input, and general Android application structure.

### ChatGPT

Tool: ChatGPT, OpenAI  
Date accessed: October 2026

ChatGPT was used as a supplementary learning, debugging, and design-review tool during development.

Prompts given to ChatGPT

- "What is a data class, and should I use one here or keep it as a normal class?"
- "Why does the feedback only appear for a split second?"
- "I only want the controls that are relevant to the current game stage to be accessible. How should I structure that?"
- "Can we use LazyColumn for the attempt log like we used in ListyCity?"
- "Review my current structure for separation of concerns and OOP without introducing anything outside the scope of an introductory Kotlin course."
- "Should generateSequence stay in GameScreen or move somewhere else for cleaner separation of concerns?"
- "The core functionality is working. What architecture changes actually make sense before I make the UML?"
- "Does the current design reasonably demonstrate separation of concerns and information hiding without overengineering the assignment?"

ChatGPT was primarily used to explain unfamiliar concepts and review design decisions, and what secondarily used to identify bugs, and suggest straightforward implementation approaches. The suggested changes were adapted and tested before being integrated into the application.