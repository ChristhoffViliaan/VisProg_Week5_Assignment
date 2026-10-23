package com.example.soal2.model

data class Question(
    val question: String,
    val correctAnswer: String,
    val wrongAnswers: List<String>,
    val userAnswer: String = "",
    val explanation: String
)