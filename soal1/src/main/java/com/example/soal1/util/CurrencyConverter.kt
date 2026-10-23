package com.example.soal1.util

import java.text.NumberFormat
import java.util.Locale

fun formatRupiah(amount: Int): String {
    val formatter = NumberFormat.getNumberInstance(
        Locale("id", "ID")
    )
    return "Rp ${formatter.format(amount)}"
}