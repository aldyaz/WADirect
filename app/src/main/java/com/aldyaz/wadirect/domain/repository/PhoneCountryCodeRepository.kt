package com.aldyaz.wadirect.domain.repository

import com.aldyaz.wadirect.domain.base.ResultState
import com.aldyaz.wadirect.domain.model.CountryCodeDomainModel
import com.aldyaz.wadirect.domain.model.HistoryDomainModel
import kotlinx.coroutines.flow.Flow

interface PhoneCountryCodeRepository {

    suspend fun getPhoneCountryCodeList(): ResultState<List<CountryCodeDomainModel>>

}