package com.aldyaz.wadirect.datasource.local

import com.aldyaz.wadirect.datasource.model.CountryCodeDto

interface PhoneCountryCodeAssetsDataSource {

    suspend fun getPhoneCountryCodes(): List<CountryCodeDto>

}