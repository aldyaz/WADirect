package com.aldyaz.wadirect.datasource.local.db

import androidx.room.Dao
import androidx.room.Query
import com.aldyaz.wadirect.datasource.local.db.entity.HistoryDb
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history")
    fun getHistories(): Flow<List<HistoryDb>>

}
