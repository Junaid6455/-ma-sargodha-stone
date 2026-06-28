package com.masargodha.stone.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masargodha.stone.data.repository.OrderRepository
import com.masargodha.stone.data.entity.OrderEntity
import kotlinx.coroutines.launch

class OrderViewModel(private val orderRepository: OrderRepository) : ViewModel() {
    
    val allOrders: LiveData<List<OrderEntity>> = orderRepository.getAllOrders()

    fun addOrder(order: OrderEntity) {
        viewModelScope.launch {
            orderRepository.insertOrder(order)
        }
    }

    fun updateOrder(order: OrderEntity) {
        viewModelScope.launch {
            orderRepository.updateOrder(order)
        }
    }

    fun deleteOrder(order: OrderEntity) {
        viewModelScope.launch {
            orderRepository.deleteOrder(order)
        }
    }

    fun getTodayOrders(): LiveData<List<OrderEntity>> {
        return orderRepository.getTodayOrders()
    }

    fun getMonthlyOrders(): LiveData<List<OrderEntity>> {
        return orderRepository.getMonthlyOrders()
    }

    fun getOrdersByStatus(status: String): LiveData<List<OrderEntity>> {
        return orderRepository.getOrdersByStatus(status)
    }
}
