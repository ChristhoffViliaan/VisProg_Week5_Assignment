package com.example.soal2.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val userAnswerColour = 0xFFc65e5a
private val correctAnswerColour = 0xFF8994b3
private val dividerColour = 0xFFc8c6ce
private val textColour = 0xFF303030

@Composable
fun RevealAnswer(
    questionNumber: Int,
    questionText: String,
    userAnswer: String,
    correctAnswer: String,
    explanation: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
    ) {
        Text(
            text = "Q$questionNumber: $questionText",
            fontSize = 12.sp,
            color = Color(textColour)
        )
        Text(
            text = "Your Answer: $userAnswer",
            fontSize = 11.sp,
            color = Color(userAnswerColour)
        )
        Text(
            text = "Correct Answer: $correctAnswer",
            fontSize = 11.sp,
            color = Color(correctAnswerColour)
        )
        Text(
            text = "Explaination: $explanation",
            fontSize = 11.sp,
            lineHeight = 14.sp,
            color = Color(correctAnswerColour)
        )
        HorizontalDivider(
            modifier = Modifier.padding(top = 6.dp),
            thickness = 1.dp,
            color = Color(dividerColour)
        )
    }
}