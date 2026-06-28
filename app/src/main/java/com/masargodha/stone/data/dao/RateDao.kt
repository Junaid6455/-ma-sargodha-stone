package com.masargodha.stone.data.dao

import androidx.room.*
import androidx.lifecycle.LiveData
import com.masargodha.stone.data.entity.RateEntity

@Dao
interface RateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRate(rate: RateEntity): Long

    @Update
    suspend fun updateRate(rate: RateEntity)

    @Delete
    suspend fun deleteRate(rate: RateEntity)

    @Query("SELECT * FROM rates ORDER BY materialName ASC")
    fun getAllRates(): LiveData<List<RateEntity>>

    @Query("SELECT * FROM rates WHERE id = :id")
    suspend fun getRateById(id: Int): RateEntity?

    @Query("SELECT * FROM rates WHERE materialName LIKE '%' || :materialName || '%'")
    fun searchRates(materialName: String): LiveData<List<RateEntity>>

    @Query("DELETE FROM rates")
    suspend fun deleteAllRates()
}
