package com.aldyaz.wadirect.domain.interactor

import com.aldyaz.wadirect.domain.base.ResultState
import com.aldyaz.wadirect.domain.base.UseCase
import com.aldyaz.wadirect.domain.model.CountryCodeDomainModel
import com.aldyaz.wadirect.domain.repository.PhoneCountryCodeRepository

class GetPhoneCountryCodesUseCase(
    private val repository: PhoneCountryCodeRepository
) : UseCase<Unit, List<CountryCodeDomainModel>>() {

    override suspend fun execute(param: Unit): ResultState<List<CountryCodeDomainModel>> {
        return repository.getPhoneCountryCodeList()
    }
}