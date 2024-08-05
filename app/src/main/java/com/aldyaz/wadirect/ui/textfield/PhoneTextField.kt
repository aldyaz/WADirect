package com.aldyaz.wadirect.ui.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.aldyaz.wadirect.R

@Composable
fun PhoneTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = stringResource(R.string.label_phone_field_placeholder),
    showError: Boolean = false,
    errorText: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Phone,
        imeAction = ImeAction.Done
    ),
    isError: Boolean = false
) = BaseTextField(
    modifier = modifier,
    value = value,
    onValueChange = onValueChange,
    label = label,
    showError = showError,
    errorText = errorText,
    keyboardOptions = keyboardOptions,
    isError = isError
)