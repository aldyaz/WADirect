package com.aldyaz.wadirect.ui.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

open class TextFieldState(
    private val validator: (String) -> Boolean = { true },
    private val errorFor: (String) -> String = { "" }
) {

    protected var mutableText = mutableStateOf("")
    val text: String by mutableText

    var isFocused: Boolean by mutableStateOf(false)
    var isFocusedDirty: Boolean by mutableStateOf(false)

    private var isAlreadyTyped: Boolean by mutableStateOf(false)
    private var displayError: Boolean by mutableStateOf(false)

    open val isValid: Boolean
        get() = validator(text)

    fun onValueChange(text: String) {
        mutableText.value = text
        isAlreadyTyped = true
    }

    fun onFocusChange(focused: Boolean) {
        isFocused = focused
        if (focused) {
            isFocusedDirty = true
        }
    }

    fun enableShowError() {
        if (isFocusedDirty) {
            displayError = true
        }
    }

    fun showError() = isAlreadyTyped && !isValid && displayError

    open fun getError(): String? = if (showError()) {
        errorFor(text)
    } else null

}