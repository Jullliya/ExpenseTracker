package dev.jullls.expensetracker.presentation.ui

data class Transaction(
    val id: Long,
    val name: String,
    val category: String,
    val amount: Long
    )
