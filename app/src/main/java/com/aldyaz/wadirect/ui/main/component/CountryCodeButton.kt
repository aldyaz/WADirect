package com.aldyaz.wadirect.ui.main.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aldyaz.wadirect.R
import com.aldyaz.wadirect.presentation.model.CountryCodePresentationModel

@Composable
fun CountryCodeButton(
    countryCode: CountryCodePresentationModel,
    onClick: () -> Unit,
    expanded: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                BorderStroke(
                    width = 1.dp,
                    color = colorResource(R.color._c0c2c3)
                ),
                RoundedCornerShape(8.dp)
            )
            .clickable {
                onClick()
            }
    ) {
        Text(
            text = "${countryCode.emoji} ${countryCode.code} (${countryCode.dialCode})",
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = if (expanded) Icons.Default.ArrowDropUp
            else Icons.Default.ArrowDropDown,
            contentDescription = "expanded-icon"
        )
    }
}

@Preview(
    heightDp = 100
)
@Composable
fun CountryCodeButtonPreview() {
    CountryCodeButton(
        countryCode = CountryCodePresentationModel(
            name = "Afghanistan",
            dialCode = "+93",
            emoji = "🇦🇫",
            code = "AF"
        ),
        onClick = { /*TODO*/ },
        expanded = false
    )
}
