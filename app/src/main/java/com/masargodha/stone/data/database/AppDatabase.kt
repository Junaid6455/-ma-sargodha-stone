package com.masargodha.stone.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.masargodha.stone.data.dao.*
import com.masargodha.stone.data.entity.*

@Database(
    entities = [
        RateEntity::class,
        CustomerEntity::class,
        OrderEntity::class,
        LedgerEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun rateDao(): RateDao
    abstract fun customerDao(): CustomerDao
    abstract fun orderDao(): OrderDao
    abstract fun ledgerDao(): LedgerDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "ma_sargodha_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
