package com.example.soal1.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soal1.model.Expenses
import com.example.soal1.util.formatRupiah

@Composable
fun ExpensesListSection(
    expenses: List<Expenses>,
    onDelete: (Int) -> Unit,
    onEdit: (Expenses) -> Unit,
    modifier: Modifier = Modifier
) {
    Spacer(Modifier.height(10.dp))

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(expenses) { index, expense ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFdce2f9),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Name : ${expense.name}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4b5164)
                    )
                    Text(
                        text = formatRupiah(expense.price),
                        fontSize = 16.sp,
                        color = Color(0xFF4b5164)
                    )
                }

                Edit(
                    onClick = {
                        onEdit(expense)
                    }
                )
                TrashCan(
                    onClick = {
                        onDelete(index)
                    }
                )

            }
        }
    }
}