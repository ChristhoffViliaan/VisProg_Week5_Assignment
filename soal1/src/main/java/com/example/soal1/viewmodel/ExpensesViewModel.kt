package com.example.soal1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.soal1.model.Expenses
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ExpensesViewModel : ViewModel() {
    private val _expenses = MutableStateFlow<List<Expenses>>(emptyList())
    val expenses = _expenses.asStateFlow()

    private val _selectedExpense = MutableStateFlow<Expenses?>(null)
    val selectedExpense = _selectedExpense.asStateFlow()

    fun addExpense(name: String, cost: Int) {
        val newExpense = Expenses(
            name = name,
            price = cost
        )
        _expenses.update { it + newExpense }
    }

    fun deleteExpense(index: Int) {
        _expenses.update { list ->
            list.filterIndexed { i, _ -> i != index }
        }
    }

    fun updateExpense(name: String, price: Int) {
        val selected = _selectedExpense.value ?: return
        _expenses.update { list ->
            list.map { expense ->
                if (expense === selected) {
                    expense.copy(
                        name = name,
                        price = price
                    )
                } else {
                    expense
                }
            }
        }
        _selectedExpense.value = null
    }
    fun selectExpense(expense: Expenses) {
        _selectedExpense.value = expense
    }

    fun cancelEdit() {
        _selectedExpense.value = null
    }

    fun getTotal(): Int {
        return _expenses.value.sumOf { it.price }
    }
}