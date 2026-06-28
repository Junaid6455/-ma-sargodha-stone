package com.masargodha.stone.data.repository

import androidx.lifecycle.LiveData
import com.masargodha.stone.data.dao.RateDao
import com.masargodha.stone.data.entity.RateEntity

class RateRepository(private val rateDao: RateDao) {
    
    fun getAllRates(): LiveData<List<RateEntity>> = rateDao.getAllRates()
    
    fun searchRates(materialName: String): LiveData<List<RateEntity>> = 
        rateDao.searchRates(materialName)
    
    suspend fun insertRate(rate: RateEntity): Long = rateDao.insertRate(rate)
    
    suspend fun updateRate(rate: RateEntity) = rateDao.updateRate(rate)
    
    suspend fun deleteRate(rate: RateEntity) = rateDao.deleteRate(rate)
    
    suspend fun getRateById(id: Int): RateEntity? = rateDao.getRateById(id)
}
