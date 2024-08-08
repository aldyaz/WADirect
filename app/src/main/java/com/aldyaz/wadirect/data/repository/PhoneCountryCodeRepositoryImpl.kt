package com.aldyaz.wadirect.data.repository

import com.aldyaz.wadirect.data.mapper.PhoneCountryCodeToDomainMapper
import com.aldyaz.wadirect.datasource.local.PhoneCountryCodeAssetsDataSource
import com.aldyaz.wadirect.domain.base.JsonParseException
import com.aldyaz.wadirect.domain.base.ResultState
import com.aldyaz.wadirect.domain.model.CountryCodeDomainModel
import com.aldyaz.wadirect.domain.repository.PhoneCountryCodeRepository

class PhoneCountryCodeRepositoryImpl(
    private val phoneCountryCodeAssetsDataSource: PhoneCountryCodeAssetsDataSource,
    private val phoneCountryCodeToDomainMapper: PhoneCountryCodeToDomainMapper
) : PhoneCountryCodeRepository {

    override suspend fun getPhoneCountryCodeList(): ResultState<List<CountryCodeDomainModel>> {
        return try {
            val data = phoneCountryCodeAssetsDataSource.getPhoneCountryCodes()
            val result = phoneCountryCodeToDomainMapper(data)
            ResultState.Success(result)
        } catch (err: Exception) {
            ResultState.Error(JsonParseException(err))
        }
    }
}