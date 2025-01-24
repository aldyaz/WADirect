package com.aldyaz.wadirect.data.repository

import com.aldyaz.wadirect.data.mapper.HistoryToDomainMapper
import com.aldyaz.wadirect.datasource.local.PhoneHistoryLocalDataSource
import com.aldyaz.wadirect.datasource.local.db.entity.HistoryDb
import com.aldyaz.wadirect.domain.model.HistoryDomainModel
import com.aldyaz.wadirect.domain.model.param.PhoneHistoryParamDomainModel
import com.aldyaz.wadirect.domain.repository.PhoneHistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.todayIn

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

    override fun savePhone(param: PhoneHistoryParamDomainModel): Flow<Unit> = flow {
        val currentDate = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val currentDateString = currentDate.format(
            LocalDate.Format {
                year()
                chars("-")
                monthNumber()
                chars("-")
                dayOfMonth()
            }
        )
        phoneHistoryLocalDataSource.savePhone(
            HistoryDb(
                countryCode = param.dialCode,
                phone = param.phone,
                text = "",
                timestamp = currentDateString
            )
        )
        emit(Unit)
    }
}