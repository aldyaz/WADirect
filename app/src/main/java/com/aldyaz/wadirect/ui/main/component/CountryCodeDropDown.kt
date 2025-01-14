package com.aldyaz.wadirect.ui.main.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aldyaz.wadirect.R
import com.aldyaz.wadirect.presentation.model.CountryCodePresentationModel

@Composable
fun CountryCodeDropDown(
    countryCode: CountryCodePresentationModel,
    countryCodes: List<CountryCodePresentationModel>,
    expanded: Boolean,
    onClick: () -> Unit,
    onDismiss: () -> Unit,
    onSelect: (CountryCodePresentationModel) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        onClick = onClick,
        border = BorderStroke(
            width = 1.dp,
            color = colorResource(R.color._c0c2c3)
        ),
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .wrapContentSize()
                .defaultMinSize(minHeight = OutlinedTextFieldDefaults.MinHeight)
        ) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = onDismiss
            ) {
                countryCodes.forEach { item ->
                    CountryCodeDropDownItem(
                        item = item,
                        onClick = {
                            onSelect(item)
                        }
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 8.dp)
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
    }
}

@Composable
fun CountryCodeDropDownItem(
    item: CountryCodePresentationModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    DropdownMenuItem(
        text = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${item.emoji} ${item.name} (${item.code})",
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .weight(2f)
                        .padding(end = 8.dp)
                )
                Text(
                    text = item.dialCode,
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(1f)
                )
            }
        },
        onClick = onClick,
        modifier = modifier
    )
}

@Preview
@Composable
private fun CountryCodeDropDownItemPreview() {
    CountryCodeDropDownItem(
        item = CountryCodePresentationModel(
            name = "Afghanistan",
            dialCode = "+93",
            emoji = "🇦🇫",
            code = "AF"
        ),
        onClick = {},
        modifier = Modifier.background(Color.White)
    )
}
