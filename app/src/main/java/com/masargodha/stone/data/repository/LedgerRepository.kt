package com.masargodha.stone.data.repository

import androidx.lifecycle.LiveData
import com.masargodha.stone.data.dao.LedgerDao
import com.masargodha.stone.data.entity.LedgerEntity

class LedgerRepository(private val ledgerDao: LedgerDao) {
    
    fun getCustomerLedger(customerId: Int): LiveData<List<LedgerEntity>> = 
        ledgerDao.getCustomerLedger(customerId)
    
    fun getAllTransactions(): LiveData<List<LedgerEntity>> = 
        ledgerDao.getAllTransactions()
    
    suspend fun insertTransaction(transaction: LedgerEntity): Long = 
        ledgerDao.insertTransaction(transaction)
    
    suspend fun deleteTransaction(transaction: LedgerEntity) = 
        ledgerDao.deleteTransaction(transaction)
    
    suspend fun getCustomerBalance(customerId: Int): Double = 
        ledgerDao.getCustomerBalance(customerId)
}
