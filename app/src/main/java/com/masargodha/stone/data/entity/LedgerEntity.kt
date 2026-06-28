package com.masargodha.stone.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ledger")
data class LedgerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val customerId: Int,
    val orderId: Int,
    val transactionType: String, // Debit, Credit
    val amount: Double,
    val description: String,
    val createdAt: Long = System.currentTimeMillis()
)
