package com.aldyaz.wadirect.ui.main.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aldyaz.wadirect.presentation.model.CountryCodePresentationModel

@Composable
fun CountryCodeListItem(
    item: CountryCodePresentationModel,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
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
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun CountryCodeListItemPreview(modifier: Modifier = Modifier) {
    CountryCodeListItem(
        item = CountryCodePresentationModel(
            name = "Afghanistan",
            dialCode = "+93",
            emoji = "🇦🇫",
            code = "AF"
        ),
        modifier = Modifier.fillMaxWidth()
    )
}
