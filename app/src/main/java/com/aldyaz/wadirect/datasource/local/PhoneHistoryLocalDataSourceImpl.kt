package com.aldyaz.wadirect.datasource.local

import com.aldyaz.wadirect.datasource.local.db.HistoryDao
import com.aldyaz.wadirect.datasource.local.db.entity.HistoryDb
import kotlinx.coroutines.flow.Flow

class PhoneHistoryLocalDataSourceImpl(
    private val historyDao: HistoryDao
) : PhoneHistoryLocalDataSource {

    override fun getHistories(): Flow<List<HistoryDb>> {
        return historyDao.getHistories()
    }
}
