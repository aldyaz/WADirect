package com.aldyaz.wadirect.presentation.model

import com.aldyaz.wadirect.presentation.base.StateEventWithContent
import com.aldyaz.wadirect.presentation.base.StateEventWithContentConsumed

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
    val phoneSubmitEvent: StateEventWithContent<String> = StateEventWithContentConsumed
) {

    companion object {
        val INITIAL = MainState()
    }
}