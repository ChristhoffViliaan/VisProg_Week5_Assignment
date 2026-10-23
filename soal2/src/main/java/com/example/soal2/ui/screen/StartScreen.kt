package com.example.soal2.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val backgroundColour = 0xFFfaf8fe
private val purple = 0xFF4c5e8b
private val mutedButton = 0xFFe6e4ea
private val mutedText = 0xFFbebcc4
private val textColour = 0xFF303030

@Composable
fun StartScreen(
    questionCount: String,
    onQuestionCountChange: (String) -> Unit,
    onStartQuiz: () -> Unit
) {
    var showError by remember { mutableStateOf(false) }
    val valueError = showError && (questionCount.toIntOrNull()?.let { it in 1..20 } != true)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(backgroundColour))
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Mini Quiz",
            fontSize = 24.sp,
            color = Color(textColour)
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = "How many questions do you want? (1 - 20)",
            fontSize = 16.sp,
            color = Color(textColour),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(22.dp))
        OutlinedTextField(
            value = questionCount,
            onValueChange = { input ->
                if (
                    input.length <= 2 &&
                    input.all { it.isDigit() }
                ) {
                    onQuestionCountChange(input)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Number of questions",
                    fontSize = 12.sp
                )
            },
            supportingText = if (valueError) {
                { Text("Please fill in the name") }
            } else {
                null
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFa5a6ae),
                unfocusedLabelColor = Color(0xFFa5a6ae),
                focusedBorderColor = Color(0xFF4f618d),
                focusedLabelColor = Color(0xFF4f618d),
                cursorColor = Color(0xFF4f618d),
                errorBorderColor = Color(0xFFb32820),
                errorLabelColor = Color(0xFFb32820),
                errorSupportingTextColor = Color(0xFFb32820),
                errorCursorColor = Color(0xFFb32820)
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                showError = true
                if (questionCount.toIntOrNull()?.let { it in 1..20 } == true) {
                    onStartQuiz()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            enabled = questionCount.toIntOrNull()?.let {
                it in 1..20
            } == true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(purple),
                contentColor = Color.White,
                disabledContainerColor = Color(mutedButton),
                disabledContentColor = Color(mutedText)
            )
        ) {
            Text(
                text = "Start Quiz",
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StartScreenPreview() {
    StartScreen(
        questionCount = "10",
        onQuestionCountChange = {},
        onStartQuiz = {}
    )
}