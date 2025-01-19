package com.aldyaz.wadirect.domain.interactor

import com.aldyaz.wadirect.domain.base.FlowUseCase
import com.aldyaz.wadirect.domain.model.param.FormatPhoneParamDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FormatPhoneOnlyUseCase : FlowUseCase<FormatPhoneParamDomainModel, String>() {

    override fun execute(param: FormatPhoneParamDomainModel): Flow<String> = flow {
        val dialCode = param.dialCode
        val phonePattern = Regex("^(\\+${dialCode})(\\d+)")
        val phone = param.phone
        if (phonePattern.matches(phone)) {
            emit(phone)
        } else {
            val numberOnlyPattern = Regex("\\D")
            val cleanDialCode = dialCode.replace(numberOnlyPattern, "")
            val newPhone = phone.replace(numberOnlyPattern, "")
            val initialPhone = newPhone.substring(0, cleanDialCode.length)
            if (initialPhone == cleanDialCode) {
                emit(newPhone)
            } else {
                emit("$dialCode$newPhone")
            }
        }
    }
}