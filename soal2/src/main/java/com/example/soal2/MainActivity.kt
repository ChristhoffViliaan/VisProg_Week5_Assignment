package com.example.soal2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.soal2.ui.theme.VisProg_Week5_AssignmentTheme
import com.example.soal2.viewmodel.QuizViewModel
import com.example.soal2.viewmodel.Screen
import com.example.soal2.ui.screen.ResultScreen
import com.example.soal2.ui.screen.QuizScreen
import com.example.soal2.ui.screen.StartScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisProg_Week5_AssignmentTheme {
                val viewModel: QuizViewModel = viewModel()
                val _CurrentScreen by viewModel.CurrentScreen.collectAsState()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(Modifier.padding(innerPadding)){
                        when (_CurrentScreen) {
                            Screen.START -> {
                                val questionCount by viewModel.QuestionAmount.collectAsState()

                                StartScreen(
                                    questionCount = questionCount,
                                    onQuestionCountChange = { viewModel.updateQuestionCount(it) },
                                    onStartQuiz = { viewModel.startQuiz() }
                                )
                            }

                            Screen.QUIZ -> {
                                val questionCount by viewModel.QuestionAmount.collectAsState()
                                QuizScreen(
                                    questionCount = questionCount.toIntOrNull() ?: 1,
                                    onSubmitAnswer = { question, answer ->
                                        viewModel.submitAnswer(question, answer)
                                    },
                                    onFinish = {
                                        viewModel.finishQuiz()
                                    }
                                )
                            }
                            Screen.RESULT -> {
                                val score by viewModel.score.collectAsState()
                                val wrongQuestions by viewModel.wrongQuestions.collectAsState()

                                ResultScreen(
                                    score = score,
                                    wrongQuestions = wrongQuestions,
                                    onReturnToStart = {
                                        viewModel.returnToStart()
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}