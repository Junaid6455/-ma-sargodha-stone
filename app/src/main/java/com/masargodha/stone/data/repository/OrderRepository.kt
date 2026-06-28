package com.masargodha.stone.data.repository

import androidx.lifecycle.LiveData
import com.masargodha.stone.data.dao.OrderDao
import com.masargodha.stone.data.entity.OrderEntity

class OrderRepository(private val orderDao: OrderDao) {
    
    fun getAllOrders(): LiveData<List<OrderEntity>> = orderDao.getAllOrders()
    
    fun getOrdersByCustomerId(customerId: Int): LiveData<List<OrderEntity>> = 
        orderDao.getOrdersByCustomerId(customerId)
    
    fun getOrdersByStatus(status: String): LiveData<List<OrderEntity>> = 
        orderDao.getOrdersByStatus(status)
    
    fun getTodayOrders(): LiveData<List<OrderEntity>> = orderDao.getTodayOrders()
    
    fun getMonthlyOrders(): LiveData<List<OrderEntity>> = orderDao.getMonthlyOrders()
    
    suspend fun insertOrder(order: OrderEntity): Long = orderDao.insertOrder(order)
    
    suspend fun updateOrder(order: OrderEntity) = orderDao.updateOrder(order)
    
    suspend fun deleteOrder(order: OrderEntity) = orderDao.deleteOrder(order)
    
    suspend fun getOrderById(id: Int): OrderEntity? = orderDao.getOrderById(id)
}
