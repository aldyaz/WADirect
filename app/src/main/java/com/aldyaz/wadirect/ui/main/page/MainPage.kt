@file:OptIn(ExperimentalMaterial3Api::class)

package com.aldyaz.wadirect.ui.main.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aldyaz.wadirect.R
import com.aldyaz.wadirect.presentation.model.CountryCodePresentationModel
import com.aldyaz.wadirect.presentation.model.MainIntent
import com.aldyaz.wadirect.presentation.model.MainState
import com.aldyaz.wadirect.presentation.viewmodel.MainViewModel
import com.aldyaz.wadirect.ui.common.model.PhoneTextFieldState
import com.aldyaz.wadirect.ui.main.component.CountryCodeBottomSheet
import com.aldyaz.wadirect.ui.main.component.CountryCodeButton
import com.aldyaz.wadirect.ui.main.component.MainPhoneTextField
import kotlinx.coroutines.launch

@Composable
fun MainPage(
    viewModel: MainViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    MainScaffold(
        state = state,
        onIntent = viewModel::onIntentReceived
    )
}

@Composable
private fun MainScaffold(
    state: MainState,
    onIntent: (MainIntent) -> Unit
) {
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val bottomSheetScope = rememberCoroutineScope()

    Scaffold { contentPadding ->
        MainContent(
            state = state,
            onIntent = onIntent,
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        )

        if (state.isChoosingCountryCode) {
            ModalBottomSheet(
                sheetState = bottomSheetState,
                onDismissRequest = {
                    onIntent(MainIntent.DismissCountryCodeBottomSheet)
                },
                content = {
                    CountryCodeBottomSheet(
                        countryCodes = state.countryCodes,
                        onClickItem = { country ->
                            bottomSheetScope.launch {
                                onIntent(MainIntent.SelectCountryCode(country))
                                bottomSheetState.hide()
                            }.invokeOnCompletion {
                                if (!bottomSheetState.isVisible) {
                                    onIntent(MainIntent.DismissCountryCodeBottomSheet)
                                }
                            }
                        }
                    )
                }
            )
        }
    }
}

@Composable
private fun MainContent(
    state: MainState,
    onIntent: (MainIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        content = {
            val phoneTextState by remember {
                mutableStateOf(PhoneTextFieldState())
            }
            Text(
                text = stringResource(R.string.label_sub_title_text),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    CountryCodeButton(
                        countryCode = state.countryCode,
                        onClick = {
                            onIntent(MainIntent.OpenCountryCodeBottomSheet)
                        },
                        expanded = state.isChoosingCountryCode,
                        modifier = Modifier
                            .defaultMinSize(minHeight = OutlinedTextFieldDefaults.MinHeight)
                            .weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    MainPhoneTextField(
                        phoneTextFieldState = phoneTextState,
                        modifier = Modifier.weight(2f)
                    )
                }
                OutlinedButton(
                    onClick = {},
                    enabled = false,
                    border = null,
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = colorResource(R.color._128c7e),
                        contentColor = Color.White,
                        disabledContainerColor = colorResource(R.color._c0c2c3),
                        disabledContentColor = Color.White
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp)
                ) {
                    Text(text = stringResource(R.string.label_open_whatsapp))
                }
            }
        }
    )
}

@Preview
@Composable
private fun MainContentPreview() {
    MainContent(
        state = MainState(
            loading = false,
            error = false,
            countryCodes = listOf(
                CountryCodePresentationModel(
                    name = "Afghanistan",
                    dialCode = "+93",
                    emoji = "🇦🇫",
                    code = "AF"
                ),
                CountryCodePresentationModel(
                    name = "Aland Islands",
                    dialCode = "+358",
                    emoji = "🇦🇽",
                    code = "AX"
                ),
                CountryCodePresentationModel(
                    name = "Albania",
                    dialCode = "+355",
                    emoji = "🇦🇱",
                    code = "AL"
                ),
                CountryCodePresentationModel(
                    name = "Algeria",
                    dialCode = "+213",
                    emoji = "🇩🇿",
                    code = "DZ"
                )
            )
        ),
        onIntent = {},
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
}
