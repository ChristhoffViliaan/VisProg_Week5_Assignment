package com.example.soal2.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soal2.model.Question
import com.example.soal2.ui.theme.VisProg_Week5_AssignmentTheme
import com.example.soal2.ui.widgets.RevealAnswer

private val backgroundColour = Color(0xFFFAF8FE)
private val purple = Color(0xFF4C5E8B)
private val textColour = Color(0xFF303030)
private val wrongColour = Color(0xFFCE4545)
private val dividerColour = Color(0xFFC8C6CE)

@Composable
fun ResultScreen(
    score: Int,
    wrongQuestions: List<Question>,
    onReturnToStart: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColour)
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Quiz Finished!",
            fontSize = 20.sp,
            color = textColour
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Your Score: $score / ${score + wrongQuestions.size}",
            fontSize = 14.sp,
            color = textColour
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (wrongQuestions.isEmpty()) {
            Text(
                text = "Perfect! No wrong answers.",
                fontSize = 14.sp,
                color = purple,
                textAlign = TextAlign.Center
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = false)
            ) {
                itemsIndexed(wrongQuestions) { index, question ->
                    RevealAnswer(
                        questionNumber = index + 1,
                        questionText = question.question,
                        userAnswer = question.userAnswer,
                        correctAnswer = question.correctAnswer,
                        explanation = question.explanation
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onReturnToStart,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = purple,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Restart Quiz",
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ResultScreenPreview() {
    VisProg_Week5_AssignmentTheme {
        ResultScreen(
            score = 3,
            wrongQuestions = emptyList(),
            onReturnToStart = {}
        )
    }
}
