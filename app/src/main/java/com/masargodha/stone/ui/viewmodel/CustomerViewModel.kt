package com.masargodha.stone.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masargodha.stone.data.repository.CustomerRepository
import com.masargodha.stone.data.entity.CustomerEntity
import kotlinx.coroutines.launch

class CustomerViewModel(private val customerRepository: CustomerRepository) : ViewModel() {
    
    val allCustomers: LiveData<List<CustomerEntity>> = customerRepository.getAllCustomers()

    fun addCustomer(customer: CustomerEntity) {
        viewModelScope.launch {
            customerRepository.insertCustomer(customer)
        }
    }

    fun updateCustomer(customer: CustomerEntity) {
        viewModelScope.launch {
            customerRepository.updateCustomer(customer)
        }
    }

    fun deleteCustomer(customer: CustomerEntity) {
        viewModelScope.launch {
            customerRepository.deleteCustomer(customer)
        }
    }

    fun searchCustomers(name: String): LiveData<List<CustomerEntity>> {
        return customerRepository.searchCustomers(name)
    }
}
