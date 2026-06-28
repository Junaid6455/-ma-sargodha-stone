package com.masargodha.stone.data.repository

import androidx.lifecycle.LiveData
import com.masargodha.stone.data.dao.CustomerDao
import com.masargodha.stone.data.entity.CustomerEntity

class CustomerRepository(private val customerDao: CustomerDao) {
    
    fun getAllCustomers(): LiveData<List<CustomerEntity>> = customerDao.getAllCustomers()
    
    fun searchCustomers(name: String): LiveData<List<CustomerEntity>> = 
        customerDao.searchCustomers(name)
    
    suspend fun insertCustomer(customer: CustomerEntity): Long = 
        customerDao.insertCustomer(customer)
    
    suspend fun updateCustomer(customer: CustomerEntity) = 
        customerDao.updateCustomer(customer)
    
    suspend fun deleteCustomer(customer: CustomerEntity) = 
        customerDao.deleteCustomer(customer)
    
    suspend fun getCustomerById(id: Int): CustomerEntity? = 
        customerDao.getCustomerById(id)
    
    suspend fun getCustomerCount(): Int = customerDao.getCustomerCount()
}
