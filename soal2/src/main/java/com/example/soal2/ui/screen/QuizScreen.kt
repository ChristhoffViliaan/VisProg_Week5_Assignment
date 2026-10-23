package com.example.soal2.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soal2.data.QuestionsData
import com.example.soal2.model.Question
import com.example.soal2.ui.theme.VisProg_Week5_AssignmentTheme

private val backgroundColour = 0xFFfaf8fe
private val purple = 0xFF4c5e8b
private val defaultButton = 0xFFdce2f9
private val mutedButton = 0xFFe6e4ea
private val mutedText = 0xFFbebcc4
private val textColour = 0xFF303030

@Composable
fun QuizScreen(
    questionCount: Int,
    onSubmitAnswer: (Question, String) -> Unit,
    onFinish: () -> Unit
) {
    val questions = remember(questionCount) {
        QuestionsData.questions.shuffled().take(
            questionCount.coerceIn(1, QuestionsData.questions.size)
        )
    }
    var questionIndex by remember { mutableIntStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    val question = questions[questionIndex]
    val answers = remember(question) {
        (question.wrongAnswers + question.correctAnswer).shuffled()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(backgroundColour))
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Question ${questionIndex + 1}",
            fontSize = 20.sp,
            color = Color(textColour)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = question.question,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                color = Color(textColour),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        answers.forEach { answer ->
            Button(
                onClick = {
                    selectedAnswer = answer
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp)
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedAnswer == answer) {
                        Color(purple)
                    } else {
                        Color(defaultButton)
                    },
                    contentColor = if (selectedAnswer == answer) {
                        Color.White
                    } else {
                        Color(textColour)
                    }
                )
            ) {
                Text(
                    text = answer,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        val isLastQuestion = questionIndex == questions.lastIndex
        Button(
            onClick = {
                val answer = selectedAnswer
                if (answer != null) {
                    onSubmitAnswer(question, answer)
                    if (isLastQuestion) {
                        onFinish()
                    } else {
                        questionIndex++
                        selectedAnswer = null
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(50),
            enabled = selectedAnswer != null,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(purple),
                contentColor = Color.White,
                disabledContainerColor = Color(mutedButton),
                disabledContentColor = Color(mutedText)
            )
        ) {
            Text(
                text = if (isLastQuestion) "Finish" else "Next",
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuizScreenPreview() {
    VisProg_Week5_AssignmentTheme {
        QuizScreen(
            questionCount = 10,
            onSubmitAnswer = { _, _ -> },
            onFinish = {}
        )
    }
}