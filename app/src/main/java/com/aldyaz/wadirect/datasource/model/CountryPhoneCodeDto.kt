package com.aldyaz.wadirect.datasource.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryPhoneCodeDto(
    @SerialName("country_phone_codes")
    val countryPhoneCodes: List<CountryCodeDto>? = null
)