package com.aldyaz.wadirect.data.mapper

import com.aldyaz.wadirect.datasource.model.CountryPhoneCodeDto
import com.aldyaz.wadirect.domain.model.CountryCodeDomainModel

class PhoneCountryCodeToDomainMapper : (CountryPhoneCodeDto) -> List<CountryCodeDomainModel> {

    override fun invoke(p1: CountryPhoneCodeDto): List<CountryCodeDomainModel> {
        return p1.countryPhoneCodes?.let { items ->
            List(items.size) {
                val item = items[it]
                CountryCodeDomainModel(
                    name = item.name.orEmpty(),
                    dialCode = item.dialCode.orEmpty(),
                    emoji = item.emoji.orEmpty(),
                    code = item.code.orEmpty()
                )
            }
        } ?: emptyList()
    }
}