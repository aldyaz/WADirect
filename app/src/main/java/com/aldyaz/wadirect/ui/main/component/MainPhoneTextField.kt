@file:OptIn(ExperimentalMaterial3Api::class)

package com.aldyaz.wadirect.ui.main.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aldyaz.wadirect.ui.common.model.PhoneTextFieldState
import com.aldyaz.wadirect.ui.common.textfield.PhoneTextField

@Composable
fun MainPhoneTextField(
    phoneTextFieldState: PhoneTextFieldState,
    onImeAction: () -> Unit,
    modifier: Modifier = Modifier,
    showError: Boolean = false,
    errorText: String? = null,
    isError: Boolean = false
) {
    PhoneTextField(
        modifier = modifier,
        value = phoneTextFieldState.text,
        onValueChange = phoneTextFieldState::onValueChange,
        showError = showError,
        errorText = errorText,
        isError = isError,
        onImeAction = onImeAction
    )
}

@Preview
@Composable
fun MainPhoneTextFieldPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
            MainPhoneTextField(
                phoneTextFieldState = PhoneTextFieldState(),
                isError = true,
                showError = true,
                errorText = "Error bang!",
                onImeAction = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
