package com.aldyaz.wadirect.presentation.model

sealed class MainIntent {

    data object OpenCountryCodeBottomSheet : MainIntent()

    data object DismissCountryCodeBottomSheet : MainIntent()

    data class SelectCountryCode(
        val countryCode: CountryCodePresentationModel
    ) : MainIntent()

}