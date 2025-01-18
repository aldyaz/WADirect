package com.aldyaz.wadirect.domain.interactor

import com.aldyaz.wadirect.domain.base.FlowUseCase
import com.aldyaz.wadirect.domain.model.HistoryDomainModel
import com.aldyaz.wadirect.domain.repository.PhoneHistoryRepository
import kotlinx.coroutines.flow.Flow

class GetSentHistories(
    private val phoneHistoryRepository: PhoneHistoryRepository
) : FlowUseCase<Unit, List<HistoryDomainModel>>() {

    override fun execute(param: Unit): Flow<List<HistoryDomainModel>> {
        return phoneHistoryRepository.getHistories()
    }
}