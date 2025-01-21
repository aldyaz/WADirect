package com.aldyaz.wadirect.presentation.model

sealed class MainHomeTabIntent {

    data object OpenCountryCodeBottomSheet : MainHomeTabIntent()

    data object DismissCountryCodeBottomSheet : MainHomeTabIntent()

    data class SelectCountryCode(
        val countryCode: CountryCodePresentationModel
    ) : MainHomeTabIntent()

    data class PhoneSubmission(
        val countryCode: CountryCodePresentationModel,
        val phone: String
    ) : MainHomeTabIntent()

}