package com.aldyaz.wadirect.presentation.model

sealed class MainIntent {

    data object OpenCountryCodeDropDown : MainIntent()

    data object DismissCountryCodeDropDown : MainIntent()

    data class SelectCountryCode(
        val countryCode: CountryCodePresentationModel
    ) : MainIntent()

}