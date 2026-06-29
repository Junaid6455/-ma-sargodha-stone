package com.masargodha.stone

import android.app.Application
import com.masargodha.stone.data.database.AppDatabase

class StoneApp : Application() {
    companion object {
        lateinit var instance: StoneApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun getDatabase() = AppDatabase.getDatabase(this)
}
