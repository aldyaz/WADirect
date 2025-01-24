package com.aldyaz.wadirect.presentation.model

sealed class MainIntent {

    data class LaunchWhatsApp(
        val phone: String
    ) : MainIntent()

    data object OnConsumedPhoneSubmitEvent : MainIntent()

}