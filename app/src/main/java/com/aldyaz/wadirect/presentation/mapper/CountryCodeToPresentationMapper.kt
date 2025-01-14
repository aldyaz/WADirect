package com.aldyaz.wadirect.presentation.mapper

import com.aldyaz.wadirect.domain.model.CountryCodeDomainModel
import com.aldyaz.wadirect.presentation.model.CountryCodePresentationModel

class CountryCodeToPresentationMapper : (CountryCodeDomainModel) -> CountryCodePresentationModel {

    override fun invoke(p1: CountryCodeDomainModel): CountryCodePresentationModel {
        return CountryCodePresentationModel(
            name = p1.name,
            dialCode = p1.dialCode,
            emoji = p1.emoji,
            code = p1.code
        )
    }
}