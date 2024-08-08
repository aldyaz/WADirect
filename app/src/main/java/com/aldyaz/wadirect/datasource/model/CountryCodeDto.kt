package com.aldyaz.wadirect.datasource.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryCodeDto(
    @SerialName("name")
    val name: String? = null,
    @SerialName("dial_code")
    val dialCode: String? = null,
    @SerialName("emoji")
    val emoji: String? = null,
    @SerialName("code")
    val code: String? = null
)