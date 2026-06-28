package com.masargodha.stone.data.dao

import androidx.room.*
import androidx.lifecycle.LiveData
import com.masargodha.stone.data.entity.LedgerEntity

@Dao
interface LedgerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: LedgerEntity): Long

    @Delete
    suspend fun deleteTransaction(transaction: LedgerEntity)

    @Query("SELECT * FROM ledger WHERE customerId = :customerId ORDER BY createdAt DESC")
    fun getCustomerLedger(customerId: Int): LiveData<List<LedgerEntity>>

    @Query("SELECT * FROM ledger ORDER BY createdAt DESC")
    fun getAllTransactions(): LiveData<List<LedgerEntity>>

    @Query("SELECT COALESCE(SUM(CASE WHEN transactionType = 'Debit' THEN amount ELSE -amount END), 0) FROM ledger WHERE customerId = :customerId")
    suspend fun getCustomerBalance(customerId: Int): Double

    @Query("DELETE FROM ledger")
    suspend fun deleteAllTransactions()
}
