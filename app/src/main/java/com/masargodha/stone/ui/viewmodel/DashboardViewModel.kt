package com.masargodha.stone.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masargodha.stone.data.repository.OrderRepository
import com.masargodha.stone.data.repository.CustomerRepository
import com.masargodha.stone.data.entity.OrderEntity
import com.masargodha.stone.data.entity.CustomerEntity
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val orderRepository: OrderRepository,
    private val customerRepository: CustomerRepository
) : ViewModel() {

    val todayOrders: LiveData<List<OrderEntity>> = orderRepository.getTodayOrders()
    val allOrders: LiveData<List<OrderEntity>> = orderRepository.getAllOrders()
    
    private val _totalCustomers = MutableLiveData<Int>()
    val totalCustomers: LiveData<Int> = _totalCustomers

    private val _totalSales = MutableLiveData<Double>()
    val totalSales: LiveData<Double> = _totalSales

    init {
        loadDashboardData()
    }

    private fun loadDashboardData() {
        viewModelScope.launch {
            _totalCustomers.value = customerRepository.getCustomerCount()
        }
    }
}
