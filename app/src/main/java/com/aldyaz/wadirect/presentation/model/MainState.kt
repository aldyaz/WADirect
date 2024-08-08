package com.aldyaz.wadirect.presentation.model

import com.aldyaz.wadirect.domain.model.CountryCodeDomainModel

data class MainState(
    val loading: Boolean = true,
    val error: Boolean = false,
    val countryCodes: List<CountryCodeDomainModel> = listOf()
) {

    companion object {
        val Initial = MainState()
    }
}