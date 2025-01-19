package com.aldyaz.wadirect.data.mapper

import com.aldyaz.wadirect.datasource.model.CountryCodeDto
import com.aldyaz.wadirect.domain.model.CountryCodeDomainModel

class PhoneCountryCodeToDomainMapper : (List<CountryCodeDto>) -> List<CountryCodeDomainModel> {

    override fun invoke(p1: List<CountryCodeDto>): List<CountryCodeDomainModel> {
        return List(p1.size) {
            val item = p1[it]
            CountryCodeDomainModel(
                name = item.name.orEmpty(),
                dialCode = item.dialCode.orEmpty(),
                emoji = item.emoji.orEmpty(),
                code = item.code.orEmpty()
            )
        }
    }
}