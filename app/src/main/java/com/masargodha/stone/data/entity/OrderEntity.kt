package com.masargodha.stone.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class OrderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val customerId: Int,
    val materialName: String,
    val quantity: Double,
    val rate: Double,
    val totalAmount: Double,
    val status: String = "Pending", // Pending, Dispatched, Delivered
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
