package com.masargodha.stone.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masargodha.stone.data.repository.LedgerRepository
import com.masargodha.stone.data.entity.LedgerEntity
import kotlinx.coroutines.launch

class LedgerViewModel(private val ledgerRepository: LedgerRepository) : ViewModel() {
    
    val allTransactions: LiveData<List<LedgerEntity>> = ledgerRepository.getAllTransactions()

    fun addTransaction(transaction: LedgerEntity) {
        viewModelScope.launch {
            ledgerRepository.insertTransaction(transaction)
        }
    }

    fun deleteTransaction(transaction: LedgerEntity) {
        viewModelScope.launch {
            ledgerRepository.deleteTransaction(transaction)
        }
    }

    fun getCustomerLedger(customerId: Int): LiveData<List<LedgerEntity>> {
        return ledgerRepository.getCustomerLedger(customerId)
    }
}
