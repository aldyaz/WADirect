package com.aldyaz.wadirect.datasource.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aldyaz.wadirect.datasource.local.db.entity.HistoryDb

@Database(
    version = WADirectDatabase.DATABASE_VERSION,
    entities = [
        HistoryDb::class
    ]
)
abstract class WADirectDatabase : RoomDatabase() {

    abstract fun historyDao(): HistoryDao

    companion object {
        private const val DATABASE_NAME = "wa-direct"
        const val DATABASE_VERSION = 1

        fun instance(
            context: Context
        ): WADirectDatabase = Room.databaseBuilder(
            context = context,
            klass = WADirectDatabase::class.java,
            name = DATABASE_NAME
        ).build()
    }
}