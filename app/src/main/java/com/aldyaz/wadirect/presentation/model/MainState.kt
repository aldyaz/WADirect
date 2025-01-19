package com.aldyaz.wadirect.presentation.model

data class MainState(
    val loading: Boolean = true,
    val error: Boolean = false,
    val isChoosingCountryCode: Boolean = false,
    val countryCode: CountryCodePresentationModel = CountryCodePresentationModel(
        name = "Indonesia",
        dialCode = "+62",
        emoji = "🇮🇩",
        code = "ID"
    ),
    val countryCodes: List<CountryCodePresentationModel> = listOf(),
    val phone: String = "",
    val cleanedPhone: String = ""
) {

    companion object {
        val INITIAL = MainState()
    }
}