package com.masargodha.stone.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rates")
data class RateEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val materialName: String,
    val materialNameUrdu: String,
    val rate: Double,
    val unit: String = "من",
    val updatedAt: Long = System.currentTimeMillis()
)
