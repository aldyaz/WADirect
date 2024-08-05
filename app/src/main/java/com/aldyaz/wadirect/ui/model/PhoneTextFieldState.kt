package com.aldyaz.wadirect.ui.model

class PhoneTextFieldState : TextFieldState(
    validator = ::isValidPhoneNumber,
    errorFor = ::validatePhoneError
)

private fun isValidPhoneNumber(input: String): Boolean = false

private fun validatePhoneError(input: String): String = ""