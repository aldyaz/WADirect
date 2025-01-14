package com.aldyaz.wadirect.data.mapper

import com.aldyaz.wadirect.datasource.model.CountryPhoneCodeDto
import com.aldyaz.wadirect.domain.model.CountryCodeDomainModel

class PhoneCountryCodeToDomainMapper : (CountryPhoneCodeDto) -> List<CountryCodeDomainModel> {

    override fun invoke(p1: CountryPhoneCodeDto): List<CountryCodeDomainModel> {
        return p1.countryPhoneCodes?.map { countryCodeDto ->
            CountryCodeDomainModel(
                name = countryCodeDto.name.orEmpty(),
                dialCode = countryCodeDto.dialCode.orEmpty(),
                emoji = countryCodeDto.emoji.orEmpty(),
                code = countryCodeDto.code.orEmpty()
            )
        }.orEmpty()
    }
}