package com.aldyaz.wadirect.utils

import androidx.compose.ui.platform.UriHandler

class WhatsAppLaunchManagerImpl(
    private val uriHandler: UriHandler
) : WhatsAppLaunchManager {

    override fun launch(phone: String): Boolean {
        try {
            uriHandler.openUri(whatsAppUrl(phone))
            return true
        } catch (e: IllegalArgumentException) {
            return false
        }
    }

    companion object {
        fun whatsAppUrl(phone: String) = "https://api.whatsapp.com/send?phone=$phone"
    }
}