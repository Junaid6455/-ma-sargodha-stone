package com.masargodha.stone.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masargodha.stone.data.repository.RateRepository
import com.masargodha.stone.data.entity.RateEntity
import kotlinx.coroutines.launch

class RateViewModel(private val rateRepository: RateRepository) : ViewModel() {
    
    val allRates: LiveData<List<RateEntity>> = rateRepository.getAllRates()

    fun addRate(rate: RateEntity) {
        viewModelScope.launch {
            rateRepository.insertRate(rate)
        }
    }

    fun updateRate(rate: RateEntity) {
        viewModelScope.launch {
            rateRepository.updateRate(rate)
        }
    }

    fun deleteRate(rate: RateEntity) {
        viewModelScope.launch {
            rateRepository.deleteRate(rate)
        }
    }

    fun searchRates(materialName: String): LiveData<List<RateEntity>> {
        return rateRepository.searchRates(materialName)
    }
}
