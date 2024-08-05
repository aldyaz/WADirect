package com.aldyaz.wadirect.ui.main.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aldyaz.wadirect.R
import com.aldyaz.wadirect.ui.main.component.MainPhoneTextField
import com.aldyaz.wadirect.ui.common.model.PhoneTextFieldState

@Composable
fun MainPage() {
    MainScaffold()
}

@Composable
private fun MainScaffold() {
    Scaffold { contentPadding ->
        MainContent(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        )
    }
}

@Composable
private fun MainContent(
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
                MainPhoneTextField(
                    phoneTextFieldState = phoneTextState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
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
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
}
