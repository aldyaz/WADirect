package com.aldyaz.wadirect.domain.repository

import com.aldyaz.wadirect.domain.base.ResultState
import com.aldyaz.wadirect.domain.model.CountryCodeDomainModel

interface PhoneCountryCodeRepository {

    suspend fun getPhoneCountryCodeList(): ResultState<List<CountryCodeDomainModel>>

}