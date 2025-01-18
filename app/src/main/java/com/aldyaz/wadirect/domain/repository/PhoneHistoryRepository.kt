package com.aldyaz.wadirect.domain.repository

import com.aldyaz.wadirect.domain.model.HistoryDomainModel
import kotlinx.coroutines.flow.Flow

interface PhoneHistoryRepository {

    fun getHistories(): Flow<List<HistoryDomainModel>>
}