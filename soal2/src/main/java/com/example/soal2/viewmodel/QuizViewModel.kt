package com.example.soal2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.soal2.model.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizViewModel : ViewModel() {
    private val _CurrentScreen = MutableStateFlow(Screen.START)
    val CurrentScreen: StateFlow<Screen> = _CurrentScreen.asStateFlow()
    fun navigateTo(screen: Screen) {
        _CurrentScreen.value = screen
    }
    fun startQuiz() {
        _CurrentScreen.value = Screen.QUIZ
    }

    fun finishQuiz() {
        _CurrentScreen.value = Screen.RESULT
    }

    fun returnToStart() {
        _CurrentScreen.value = Screen.START
    }

    private val _QuestionAmount = MutableStateFlow("")
    val QuestionAmount = _QuestionAmount.asStateFlow()

    fun updateQuestionCount(count: String) {
        if (count.all { it.isDigit() } && count.length <= 2) {
            val number = count.toIntOrNull()

            if (number == null || (number in 1..20)) {
                _QuestionAmount.value = count
            }
        }
    }

    private val _wrongQuestions = MutableStateFlow<List<Question>>(emptyList())
    val wrongQuestions = _wrongQuestions.asStateFlow()

    fun submitAnswer(question: Question, answer: String) {
        if (answer == question.correctAnswer) {
            _score.value++
        } else {
            _wrongQuestions.value += question.copy(
                userAnswer = answer
            )
        }
    }
    private val _score = MutableStateFlow(0)
    val score = _score.asStateFlow()


}



enum class Screen {
    START,
    QUIZ,
    RESULT
}