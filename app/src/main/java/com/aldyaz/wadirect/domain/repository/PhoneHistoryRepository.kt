package com.aldyaz.wadirect.domain.repository

import com.aldyaz.wadirect.domain.model.HistoryDomainModel
import com.aldyaz.wadirect.domain.model.param.PhoneHistoryParamDomainModel
import kotlinx.coroutines.flow.Flow

interface PhoneHistoryRepository {

    fun getHistories(): Flow<List<HistoryDomainModel>>

    fun savePhone(param: PhoneHistoryParamDomainModel): Flow<Unit>
}