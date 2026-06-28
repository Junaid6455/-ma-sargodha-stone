package com.masargodha.stone.data.dao

import androidx.room.*
import androidx.lifecycle.LiveData
import com.masargodha.stone.data.entity.OrderEntity

@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(order: OrderEntity): Long

    @Update
    suspend fun updateOrder(order: OrderEntity)

    @Delete
    suspend fun deleteOrder(order: OrderEntity)

    @Query("SELECT * FROM orders ORDER BY createdAt DESC")
    fun getAllOrders(): LiveData<List<OrderEntity>>

    @Query("SELECT * FROM orders WHERE id = :id")
    suspend fun getOrderById(id: Int): OrderEntity?

    @Query("SELECT * FROM orders WHERE customerId = :customerId ORDER BY createdAt DESC")
    fun getOrdersByCustomerId(customerId: Int): LiveData<List<OrderEntity>>

    @Query("SELECT * FROM orders WHERE status = :status ORDER BY createdAt DESC")
    fun getOrdersByStatus(status: String): LiveData<List<OrderEntity>>

    @Query("SELECT * FROM orders WHERE DATE(createdAt / 1000, 'unixepoch') = DATE('now')")
    fun getTodayOrders(): LiveData<List<OrderEntity>>

    @Query("SELECT * FROM orders WHERE strftime('%Y-%m', createdAt / 1000, 'unixepoch') = strftime('%Y-%m', 'now')")
    fun getMonthlyOrders(): LiveData<List<OrderEntity>>

    @Query("DELETE FROM orders")
    suspend fun deleteAllOrders()
}
