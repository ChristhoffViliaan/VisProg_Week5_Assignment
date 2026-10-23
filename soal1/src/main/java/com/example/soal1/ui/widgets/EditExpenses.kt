package com.example.soal1.ui.widgets

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.soal1.model.Expenses

@Composable
fun EditExpenses(
    expense: Expenses,
    onDismiss: () -> Unit,
    onSave: (String, Int) -> Unit
) {
    var name by remember(expense) { mutableStateOf(expense.name) }
    var price by remember(expense) { mutableStateOf(expense.price.toString()) }
    val amount = price.toIntOrNull()
    var showError by rememberSaveable { mutableStateOf(false) }
    val nameError = showError && name.isBlank()
    val priceError = showError && (price.toIntOrNull() == null || price.toIntOrNull()!! <= 0)
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text("Edit Expense")
        },
        text = {
            androidx.compose.foundation.layout.Column {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Expense Name") },
                    singleLine = true,
                    isError = nameError,
                    supportingText = if (nameError) {
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
                    )
                )

                OutlinedTextField(
                    value = price,
                    onValueChange = { price = it },
                    label = { Text("Amount of Expense") },
                    singleLine = true,
                    isError = priceError,
                    supportingText = if (priceError) {
                        { Text("Amount must be greater than 0") }
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
                    )
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    showError = true
                    if (name.isNotBlank() && amount != null && amount > 0) {
                        onSave(name.trim(), amount!!)
                    }
                }
            ) {
                Text("Save")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}