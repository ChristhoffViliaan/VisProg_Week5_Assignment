package com.example.soal1.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.soal1.ui.widgets.ExpensesListSection
import com.example.soal1.viewmodel.ExpensesViewModel
import com.example.soal1.util.formatRupiah
import com.example.soal1.ui.widgets.EditExpenses

@Composable
fun ExpensesScreen(viewModel: ExpensesViewModel = viewModel()) {
    val expenses by viewModel.expenses.collectAsState()
    val selectedExpense by viewModel.selectedExpense.collectAsState()
    var name by rememberSaveable() { mutableStateOf("") }
    var price by rememberSaveable { mutableStateOf("") }
    var showError by rememberSaveable { mutableStateOf(false) }
    val nameError = showError && name.isBlank()
    val priceError = showError && (price.toIntOrNull() == null || price.toIntOrNull()!! <= 0)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xfffaf8fe))
            .padding(16.dp)
    ) {
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Expenses",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
            color = Color(0xFF30323a)
        )//Expenses
        Text(
            text = "Total Expenses : ${formatRupiah(viewModel.getTotal())}",
            fontSize = 16.sp,
            color = Color(0xFF4a4b53)
        )//Total expenses
        Spacer(Modifier.height(10.dp))
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
            ),
            modifier = Modifier.fillMaxWidth()
        )//Expense Name
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {//Next bar
            OutlinedTextField(
                value = price,
                onValueChange = { price = it },
                label = { Text("Amount of Expense") },
                singleLine = true,
                isError = priceError,
                modifier = Modifier.weight(1f),
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
            )//Amount of Expense
            FilledIconButton(
                onClick = {
                    showError = true
                    val amount = price.toIntOrNull()
                    if (name.isNotBlank() && amount != null && amount > 0) {
                        viewModel.addExpense(name, amount)
                        name = ""
                        price = ""
                        showError = false
                    }
                },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .size(48.dp),
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = Color(0xFFE6E0E9),
                    contentColor = Color(0xFF49454F)
                )
            ) {//+ button
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add expense"
                )//+
            }
        }
        Spacer(Modifier.height(10.dp))
        ExpensesListSection(
            expenses = expenses,
            onDelete = { index ->
                viewModel.deleteExpense(index)
            },
            onEdit = { expense ->
                viewModel.selectExpense(expense)
            },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        if (selectedExpense != null) {
            EditExpenses(
                expense = selectedExpense!!,
                onDismiss = {
                    viewModel.cancelEdit()
                },
                onSave = { name, price ->
                    viewModel.updateExpense(name, price)
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ExpensesScreenPreview() {
    ExpensesScreen()
}