package com.aldyaz.wadirect.datasource.local

import com.aldyaz.wadirect.datasource.local.db.entity.HistoryDb
import kotlinx.coroutines.flow.Flow

interface PhoneHistoryLocalDataSource {

    fun getHistories(): Flow<List<HistoryDb>>

}