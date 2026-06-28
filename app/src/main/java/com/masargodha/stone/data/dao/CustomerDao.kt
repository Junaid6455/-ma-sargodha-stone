package com.masargodha.stone.data.dao

import androidx.room.*
import androidx.lifecycle.LiveData
import com.masargodha.stone.data.entity.CustomerEntity

@Dao
interface CustomerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customer: CustomerEntity): Long

    @Update
    suspend fun updateCustomer(customer: CustomerEntity)

    @Delete
    suspend fun deleteCustomer(customer: CustomerEntity)

    @Query("SELECT * FROM customers ORDER BY name ASC")
    fun getAllCustomers(): LiveData<List<CustomerEntity>>

    @Query("SELECT * FROM customers WHERE id = :id")
    suspend fun getCustomerById(id: Int): CustomerEntity?

    @Query("SELECT * FROM customers WHERE name LIKE '%' || :name || '%' OR phone LIKE '%' || :name || '%'")
    fun searchCustomers(name: String): LiveData<List<CustomerEntity>>

    @Query("DELETE FROM customers")
    suspend fun deleteAllCustomers()

    @Query("SELECT COUNT(*) FROM customers")
    suspend fun getCustomerCount(): Int
}
