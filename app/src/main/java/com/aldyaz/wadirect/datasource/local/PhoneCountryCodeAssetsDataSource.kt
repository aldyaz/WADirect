package com.aldyaz.wadirect.datasource.local

import com.aldyaz.wadirect.datasource.model.CountryPhoneCodeDto

interface PhoneCountryCodeAssetsDataSource {

    suspend fun getPhoneCountryCodes(): CountryPhoneCodeDto

}