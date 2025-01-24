package com.aldyaz.wadirect.domain.interactor

import com.aldyaz.wadirect.domain.base.FlowUseCase
import com.aldyaz.wadirect.domain.model.param.PhoneHistoryParamDomainModel
import com.aldyaz.wadirect.domain.repository.PhoneHistoryRepository
import kotlinx.coroutines.flow.Flow

class SavePhoneToHistoryUseCase(
    private val repository: PhoneHistoryRepository
) : FlowUseCase<PhoneHistoryParamDomainModel, Unit>() {

    override fun execute(param: PhoneHistoryParamDomainModel): Flow<Unit> {
        return repository.savePhone(param)
    }
}
