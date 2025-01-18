package com.aldyaz.wadirect.data.repository

import com.aldyaz.wadirect.data.mapper.HistoryToDomainMapper
import com.aldyaz.wadirect.datasource.local.PhoneHistoryLocalDataSource
import com.aldyaz.wadirect.domain.model.HistoryDomainModel
import com.aldyaz.wadirect.domain.repository.PhoneHistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PhoneHistoryRepositoryImpl(
    private val phoneHistoryLocalDataSource: PhoneHistoryLocalDataSource,
    private val historyToDomainMapper: HistoryToDomainMapper
) : PhoneHistoryRepository {

    override fun getHistories(): Flow<List<HistoryDomainModel>> {
        return phoneHistoryLocalDataSource.getHistories().map { items ->
            List(items.size) { index ->
                historyToDomainMapper(items[index])
            }
        }
    }
}